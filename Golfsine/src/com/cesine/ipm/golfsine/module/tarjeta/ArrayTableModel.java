/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module.tarjeta;

import javax.microedition.lcdui.TextField;

/**
 *
 * @author julioa
 */
public class ArrayTableModel implements ITableModel {

    String[][] array = null;

    public ArrayTableModel() {
    }

    public ArrayTableModel(String[][] array) {
        setArray(array);
    }

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    public int getRows() {
        if (array != null) {
            return array.length;
        } else {
            return 0;
        }
    }

    public int getColumns() {
        if (array != null && array[0] != null) {
            return array[0].length;
        } else {
            return 0;
        }
    }

    public String getCellValue(int row, int column) {
        if (array != null) {
            return array[row][column];
        } else {
            return null;
        }
    }

    public int getCellType(int row, int column) {
       return TextField.ANY;
    }

    public int getCellColor(int row, int column) {
        return 0x000000;
    }

    public void notifyCellChange(int row, int column, String value) {
        array[row][column]=value;
    }

    public int getCellBackgroud(int row, int column) {
        return 0xffffff;
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }
}
