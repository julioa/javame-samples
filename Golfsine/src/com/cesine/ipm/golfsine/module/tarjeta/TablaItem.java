package com.cesine.ipm.golfsine.module.tarjeta;

import javax.microedition.lcdui.*;
/**
 *
 * Ignacio López Sierra, Javier García Rodriguez, Daniel Delgado Torre
 */
public class TablaItem extends CustomItem implements ItemCommandListener {
    private static final Command CMD_EDIT = new Command("Editar", Command.ITEM, 1);
    private static final int superior = 0;
    private static final int dentro = 1;
    private static final int inferior = 2;
    private Display display;
    //private int filas = 6;
    //private int cols = 11;
    private int dx = 20;
    private int dy = 20;
    private int location = superior;
    private int actX = 1;
    private int actY = 2;
    //private String[][] datos = new String[filas][cols];

    boolean horiz;
    boolean vert;

    ITableModel model = null;

    public TablaItem(String title, Display d, ITableModel model) {
        super(title);
        display = d;
        setDefaultCommand(CMD_EDIT);
        setItemCommandListener(this);

        int interacion = getInteractionModes();
        horiz = ((interacion & CustomItem.TRAVERSE_HORIZONTAL) != 0);
        vert = ((interacion & CustomItem.TRAVERSE_VERTICAL) != 0);

        this.model = model;

//        datos[0][0] = "Hoyos";
//        datos[0][1] = "1";
//        datos[0][2] = "2";
//        datos[0][3] = "3";
//        datos[0][4] = "4";
//        datos[0][5] = "5";
//        datos[0][6] = "6";
//        datos[0][7] = "7";
//        datos[0][8] = "8";
//        datos[0][9] = "9";
//        datos[0][10] = "Total";
//        datos[1][0] = "Par";
//        datos[1][1] = "3";
//        datos[1][2] = "4";
//        datos[1][3] = "4";
//        datos[1][4] = "4";
//        datos[1][5] = "5";
//        datos[1][6] = "3";
//        datos[1][7] = "3";
//        datos[1][8] = "4";
//        datos[1][9] = "5";
//        datos[1][10] = "35";
//        datos[2][0] = "Yo";
    }

    protected int getMinContentHeight() {
        return (model.getRows() * dy) + 1;
    }

    protected int getMinContentWidth() {
        return (model.getColumns() * dx) + 1;
    }

    protected int getPrefContentHeight(int width) {
        return (model.getRows() * dy) + 1;
    }

    protected int getPrefContentWidth(int height) {
        return (model.getColumns() * dx) + 1;
    }

    protected void paint(Graphics g, int w, int h) {
        for (int i = 0; i <= model.getRows(); i++) {
            g.drawLine(0, i * dy, model.getColumns() * dx, i * dy);
        }

        for (int i = 0; i <= model.getColumns(); i++) {
            g.drawLine(i * dx, 0, i * dx, model.getRows() * dy);
        }

        int antColor = g.getColor();
        g.setColor(0x00D0D0D0);
        g.fillRect((actX * dx) + 1, (actY * dy) + 1, dx - 1, dy - 1);
        g.setColor(antColor);

        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                if (model.getCellValue(i, j) != null) {
                    int antClipX = g.getClipX();
                    int antClipY = g.getClipY();
                    int antClipWidth = g.getClipWidth();
                    int antClipHeight = g.getClipHeight();
                    g.setClip((j * dx) + 1, i * dy, dx - 1, dy - 1);
                    g.setColor(model.getCellColor(i, j));
                    g.drawString(model.getCellValue(i, j), (j * dx) + 2, ((i + 1) * dy) - 2,
                        Graphics.BOTTOM | Graphics.LEFT);
                    g.setColor(antColor);
                    g.setClip(antClipX, antClipY, antClipWidth, antClipHeight);
                }
            }
        }
    }

    protected boolean traverse(int dir, int Width, int Height, int[] visRect_inout) {
        if (horiz && vert) {
            switch (dir) {
            case Canvas.DOWN:

                if (location == superior) {
                    location = dentro;
                } else {
                    if (actY < (model.getRows() - 1)) {
                        actY++;
                        repaint(actX * dx, (actY - 1) * dy, dx, dy);
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else {
                        location = inferior;

                        return false;
                    }
                }

                break;

            case Canvas.UP:

                if (location == inferior) {
                    location = dentro;
                } else {
                    if (actY > 0) {
                        actY--;
                        repaint(actX * dx, (actY + 1) * dy, dx, dy);
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else {
                        location = superior;
                        return false;
                    }
                }

                break;

            case Canvas.LEFT:

                if (actX > 0) {
                    actX--;
                    repaint((actX + 1) * dx, actY * dy, dx, dy);
                    repaint(actX * dx, actY * dy, dx, dy);
                }

                break;

            case Canvas.RIGHT:

                if (actX < (model.getColumns() - 1)) {
                    actX++;
                    repaint((actX - 1) * dx, actY * dy, dx, dy);
                    repaint(actX * dx, actY * dy, dx, dy);
                }
            }
        } else if (horiz || vert) {
            switch (dir) {
            case Canvas.UP:
            case Canvas.LEFT:

                if (location == inferior) {
                    location = dentro;
                } else {
                    if (actX > 0) {
                        actX--;
                        repaint((actX + 1) * dx, actY * dy, dx, dy);
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else if (actY > 0) {
                        actY--;
                        repaint(actX * dx, (actY + 1) * dy, dx, dy);
                        actX = model.getColumns() - 1;
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else {
                        location = superior;

                        return false;
                    }
                }

                break;

            case Canvas.DOWN:
            case Canvas.RIGHT:

                if (location == superior) {
                    location = dentro;
                } else {
                    if (actX < (model.getColumns() - 1)) {
                        actX++;
                        repaint((actX - 1) * dx, actY * dy, dx, dy);
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else if (actY < (model.getRows() - 1)) {
                        actY++;
                        repaint(actX * dx, (actY - 1) * dy, dx, dy);
                        actX = 0;
                        repaint(actX * dx, actY * dy, dx, dy);
                    } else {
                        location = inferior;

                        return false;
                    }
                }
            }
        } else {

        }

        visRect_inout[0] = actX;
        visRect_inout[1] = actY;
        visRect_inout[2] = dx;
        visRect_inout[3] = dy;

        return true;
    }

    public void setText(String text) {
        //datos[actY][actX] = text;
        model.notifyCellChange(actY, actX, text);
        repaint(actY * dx, actX * dy, dx, dy);
    }

    public void commandAction(Command c, Item i) {
        if (c == CMD_EDIT) {
            EditarTexto editar = new EditarTexto(model.getCellValue(actY,actX), this, display, model.getCellType(actY,actX));
            display.setCurrent(editar);
        }
    }
}