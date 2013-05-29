/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module.tarjeta;

import com.cesine.ipm.golfsine.data.Game;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author julioa
 */
public class GameTableModel implements ITableModel {

    Game game = null;
    int rows = 0;
    int columns = 0;
    int offset = 0;
    int limit = 0;
    boolean readOnly = false;

    private static int PAR_COLOR = 0x000000;
    private static int BIRDIE_COLOR = 0xff0000;
    private static int BOGEY_COLOR = 0x0000ff;

    public GameTableModel() {
    }

    public GameTableModel(Game game) {
        setGame(game);
    }

    public GameTableModel(Game game, int offset, int limit, boolean readOnly) {

        setReadOnly(readOnly);

        if (game.getScores().size() > offset) {
            this.offset = offset;
        }
        this.limit = limit;
        if (game.getScores().size() < limit) {
            this.limit = game.getScores().size();
        }
        setGame(game);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        if (game != null) {
            rows = (1 + 1) + (1 + 1 + 1 + 1 + 1) + (1 + 1 + 1);
            columns = 2 + limit - offset;
        } else {
            columns = rows = 0;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getCellValue(int row, int column) {
        String aux = getValue(row, column);
        if (aux != null && "-1".equals(aux)) {
            return "--";
        } else {
            return aux;
        }
    }

    private String getValue(int row, int column) {
        if (game != null) {
            if (row == 0) {
                if (column == 0) {
                    return null;
                } else if (column == columns - 1) {
                    return "Tot.";
                } else {
                    return Integer.toString(column+offset);
                }
            } else if (row == 1) {
                if (column == 0) {
                    return "Par";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPar());
                }
            } else if (row == 2) {
                if (column == 0) {
                    return "Long";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getLongs());
                }
            } else if (row == 3) {
                if (column == 0) {
                    return "Short";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getShorts());
                }
            } else if (row == 4) {
                if (column == 0) {
                    return "Puts";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPutts());
                }
            } else if (row == 5) {
                if (column == 0) {
                    return "Pen.";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPenalties());
                }
            } else if (row == 6) {
                if (column == 0) {
                    return "Total";
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getTotal());
                }
            } else if (row == 7) {
                if (column == 0) {
                    return game.getPlayer2();
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPlayer2());
                }
            } else if (row == 8) {
                if (column == 0) {
                    return game.getPlayer3();
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPlayer3());
                }
            } else if (row == 9) {
                if (column == 0) {
                    return game.getPlayer4();
                } else if (column >= columns - 1) {
                    return null;
                } else {
                    return Integer.toString(game.getScore(column - 1 + offset).getPlayer4());
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public int getCellType(int row, int column) {
        return TextField.ANY;
    }

    public int getCellColor(int row, int column) {
        if (game != null) {
            if (row == 0) {
                if (column == 0) {
                    return 0x000000;
                } else if (column == columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 1) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 2) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 3) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 4) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 5) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    return 0x000000;
                }
            } else if (row == 6) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    int auxGolpes = (game.getScore(column - 1 + offset).getTotal());
                    int auxPar = (game.getCourse().getHole(column-1 + offset).getPar());
                    if (auxGolpes > auxPar) {
                        return BOGEY_COLOR;
                    } else if (auxGolpes < auxPar) {
                        return BIRDIE_COLOR;
                    } else {
                        return PAR_COLOR;
                    }
                }
            } else if (row == 7) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    int auxGolpes = (game.getScore(column - 1 + offset).getPlayer2());
                    int auxPar = (game.getCourse().getHole(column-1 + offset).getPar());
                    if (auxGolpes > auxPar) {
                        return BOGEY_COLOR;
                    } else if (auxGolpes < auxPar) {
                        return BIRDIE_COLOR;
                    } else {
                        return PAR_COLOR;
                    }
                }
            } else if (row == 8) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    int auxGolpes = (game.getScore(column - 1 + offset).getPlayer3());
                    int auxPar = (game.getCourse().getHole(column-1 + offset).getPar());
                    if (auxGolpes > auxPar) {
                        return BOGEY_COLOR;
                    } else if (auxGolpes < auxPar) {
                        return BIRDIE_COLOR;
                    } else {
                        return PAR_COLOR;
                    }                }
            } else if (row == 9) {
                if (column == 0) {
                    return 0x000000;
                } else if (column >= columns - 1) {
                    return 0x000000;
                } else {
                    int auxGolpes = (game.getScore(column - 1 + offset).getPlayer4());
                    int auxPar = (game.getCourse().getHole(column-1 + offset).getPar());
                    if (auxGolpes > auxPar) {
                        return BOGEY_COLOR;
                    } else if (auxGolpes < auxPar) {
                        return BIRDIE_COLOR;
                    } else {
                        return PAR_COLOR;
                    }                }
            } else {
                return 0x000000;
            }
        } else {
            return 0x000000;
        }
    }

    public void notifyCellChange(int row, int column, String value) {

        if (isReadOnly() == true) {
            return;
        }

        try {
            if (game != null) {
                if (row == 0) {
                    if (column == 0) {
                        return;
                    } else if (column == columns - 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (row == 1) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (row == 2) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setLongs(Integer.parseInt(value));
                    }
                } else if (row == 3) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setShorts(Integer.parseInt(value));
                    }
                } else if (row == 4) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setPutts(Integer.parseInt(value));
                    }
                } else if (row == 5) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setPenalties(Integer.parseInt(value));
                    }
                } else if (row == 6) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setTotal(Integer.parseInt(value));
                    }
                } else if (row == 7) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setPlayer2(Integer.parseInt(value));
                    }
                } else if (row == 8) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setPlayer3(Integer.parseInt(value));
                    }
                } else if (row == 9) {
                    if (column == 0) {
                        return;
                    } else if (column >= columns - 1) {
                        return;
                    } else {
                        game.getScore(column - 1 + offset).setPlayer4(Integer.parseInt(value));
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCellBackgroud(int row, int column) {
        return 0xffffff;
    }

    public boolean isCellEditable(int row, int column) {
        return (isReadOnly()==false);
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

}
