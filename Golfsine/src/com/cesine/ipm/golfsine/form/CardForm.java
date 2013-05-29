/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.form;

import com.cesine.ipm.golfsine.GolfController;
import com.cesine.ipm.golfsine.data.Game;
import com.sun.lwuit.CheckBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.plaf.Style;
import com.sun.lwuit.table.DefaultTableModel;
import com.sun.lwuit.table.Table;
import com.sun.lwuit.table.TableModel;

/**
 *
 * @author julioa
 */
public class CardForm extends Form implements ActionListener {

    private Game game = null;
    Command exitCommand = null;
    Command okCommand = null;

    public CardForm() {
        this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 1000));

        this.refreshTheme();
        exitCommand = new Command("Volver");
        this.addCommand(exitCommand);

        okCommand = new Command("OK");
        this.addCommand(okCommand);

        this.addCommandListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        Command command = evt.getCommand();

        if (command == exitCommand) {
            // Confirmamos y salimos
            GolfController.getInstance().keepPlaying();
        } else if (command == okCommand) {
            // Confirmamos y Guardamos datos
            GolfController.getInstance().keepPlaying();
        }
    }

    private void updateGame() {
        //if (game == null) {
        //    return;
        //}

        Form f = this;
        f.setLayout(new BorderLayout());

        TableModel model = new DefaultTableModel(new String[]{"", "1", "2", "3","4", "5", "6", "7", "8","9","Total"}, new Object[][]{
                    {"Par", "4", "3", "4","3","5","4","4","4","3","34"},
                    {"Yo", "4", "3", "4","3","5","4","4","4","3","34"},
                    {"AJ", "4", "3", "4","3","5","4","4","4","3","34"},
                    {"MN", "4", "3", "4","3","5","4","4","4","3","34"},
        }) {

            public boolean isCellEditable(int row, int col) {
                return col != 0 && col != 3;
            }
        };

        Table table = new Table(model) {

            private CellListener listener;

            protected Component createCell(Object value, final int row, final int column, boolean editable) {
                if (row != -1) {
                    //if (listener == null) {
                    //    listener = new CellListener(this);
                    //}

                   // if (row == 1) {
                   //     TextArea t = new TextArea(1,2);
                   //     t.setText((String)value);
                   //     t.getStyle().setBgColor(0);
                   //     return t;
                   // }
//                    switch (column) {
//                        case 2:
//                            // checkbox column
//                            final CheckBox c = new CheckBox();
//                            c.setSelected(((Boolean) value).booleanValue());
//                            c.addActionListener(listener);
//                            return c;
//                        case 3:
//                            TextArea t = new TextArea(2, 10);
//                            t.setGrowByContent(true);
//                            t.setText((String) value);
//                            return t;
//                    }
                }
                Component cell = super.createCell(value, row, column, editable);
                if (row == -1) {
                    cell.getStyle().setBgColor(0x0000ff,false);
                    cell.getUnselectedStyle().setBgColor(0x0000ff,false);
                    cell.getSelectedStyle().setBgColor(0x0000ff,false);
                }
                if (row == 0) {
                    cell.getStyle().setBgColor(0x00ff00,false);
                    cell.getUnselectedStyle().setBgColor(0x0000ff,false);
                    cell.getSelectedStyle().setBgColor(0x0000ff,false);
                    Style newStyle = cell.getUnselectedStyle();
                    newStyle.setFgColor(0xff0000,false);
                    cell.setUnselectedStyle(newStyle);
                    cell.setSelectedStyle(newStyle);
                    cell.setStyle(newStyle);
                }
                if (row == 1) {
                    cell.getStyle().setBgColor(0xff0000,false);
                    cell.getUnselectedStyle().setBgColor(0xff0000,false);
                }

                return cell;
            }

        };
        table.setScrollableX(true);
        table.setScrollableY(true);
        f.setScrollable(false);
        f.addComponent(BorderLayout.CENTER, table);

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        updateGame();
    }

    class CellListener implements ActionListener {

        private Table t;

        public CellListener(Table t) {
            this.t = t;
        }

        public void actionPerformed(ActionEvent evt) {
            Component source = (Component) evt.getSource();
            if (source instanceof CheckBox) {
                t.getModel().setValueAt(t.getCellRow(source), t.getCellColumn(source),
                        new Boolean(((CheckBox) source).isSelected()));
            }
        }
    }
}
