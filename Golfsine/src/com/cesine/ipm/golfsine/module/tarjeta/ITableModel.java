/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.golfsine.module.tarjeta;

/**
 *
 * @author julioa
 */
public interface ITableModel {

    public int getRows();
    public int getColumns();
    public String getCellValue(int row, int column);
    public int getCellType(int row, int column);
    public int getCellColor(int row, int column);
    public int getCellBackgroud(int row, int column);
    public boolean isCellEditable(int row, int column);
    public void notifyCellChange(int row, int column, String value);


}
