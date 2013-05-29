/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.golfsine.module;

import com.cesine.ipm.golfsine.GolfController;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


/**
 * @author USUARIO
 */
public class Reglas implements CommandListener, ItemCommandListener {

    private boolean midletPaused = false;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form PantallaInicio;
    private ImageItem imageItem1;
    private ImageItem imageItem;
    private List Menu;
    private Form Juego;
    private StringItem stringItem3;
    private StringItem stringItem1;
    private StringItem stringItem5;
    private StringItem stringItem4;
    private Form Palos;
    private StringItem stringItem8;
    private StringItem stringItem9;
    private StringItem stringItem;
    private StringItem stringItem2;
    private StringItem stringItem6;
    private StringItem stringItem7;
    private List LosPalosylaBola;
    private Form LaBola;
    private StringItem stringItem12;
    private StringItem stringItem11;
    private StringItem stringItem10;
    private Form ResponsabilidadesdelJugador;
    private StringItem stringItem13;
    private StringItem stringItem17;
    private StringItem stringItem15;
    private StringItem stringItem16;
    private StringItem stringItem14;
    private Form OrdendelJuego;
    private StringItem stringItem20;
    private StringItem stringItem19;
    private StringItem stringItem18;
    private Form Situaciones;
    private StringItem stringItem24;
    private StringItem stringItem23;
    private StringItem stringItem22;
    private StringItem stringItem21;
    private StringItem stringItem25;
    private Form Admin;
    private StringItem stringItem50;
    private StringItem stringItem49;
    private StringItem stringItem48;
    private StringItem stringItem43;
    private StringItem stringItem42;
    private StringItem stringItem47;
    private StringItem stringItem46;
    private StringItem stringItem45;
    private StringItem stringItem44;
    private Form Modalidades;
    private StringItem stringItem36;
    private StringItem stringItem37;
    private StringItem stringItem38;
    private StringItem stringItem39;
    private StringItem stringItem40;
    private StringItem stringItem41;
    private StringItem stringItem34;
    private StringItem stringItem35;
    private Form Green;
    private StringItem stringItem29;
    private StringItem stringItem28;
    private StringItem stringItem31;
    private StringItem stringItem30;
    private StringItem stringItem33;
    private StringItem stringItem32;
    private StringItem stringItem27;
    private StringItem stringItem26;
    private Command SalirInicio;
    private Command okCommand;
    private Command itemCommand;
    private Command VerLista;
    private Command SalirLista;
    private Command Salir;
    private Command cancelCommand;
    private Image image1;
    private Image image2;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The Menu constructor.
     */
    public Reglas() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getPantallaInicio());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == Admin) {//GEN-BEGIN:|7-commandAction|1|145-preAction
            if (command == Salir) {//GEN-END:|7-commandAction|1|145-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|2|145-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|132-preAction
        } else if (displayable == Green) {
            if (command == Salir) {//GEN-END:|7-commandAction|3|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|4|132-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|41-preAction
        } else if (displayable == Juego) {
            if (command == Salir) {//GEN-END:|7-commandAction|5|41-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|6|41-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|7|42-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|42-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|97-preAction
        } else if (displayable == LaBola) {
            if (command == Salir) {//GEN-END:|7-commandAction|9|97-preAction
                // write pre-action user code here
                switchDisplayable(null, getLosPalosylaBola());//GEN-LINE:|7-commandAction|10|97-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|81-preAction
        } else if (displayable == LosPalosylaBola) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|81-preAction
                // write pre-action user code here
                LosPalosylaBolaAction();//GEN-LINE:|7-commandAction|12|81-postAction
                // write post-action user code here
            } else if (command == cancelCommand) {//GEN-LINE:|7-commandAction|13|87-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|14|87-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|33-preAction
        } else if (displayable == Menu) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|15|33-preAction
                // write pre-action user code here
                MenuAction();//GEN-LINE:|7-commandAction|16|33-postAction
                // write post-action user code here
            } else if (command == SalirLista) {//GEN-LINE:|7-commandAction|17|57-preAction
                // write pre-action user code here
                GolfController.getInstance().goMain(false);
                if (true) {
                    return;
                }
                switchDisplayable(null, getPantallaInicio());//GEN-LINE:|7-commandAction|18|57-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|144-preAction
        } else if (displayable == Modalidades) {
            if (command == Salir) {//GEN-END:|7-commandAction|19|144-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|20|144-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|112-preAction
        } else if (displayable == OrdendelJuego) {
            if (command == Salir) {//GEN-END:|7-commandAction|21|112-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|22|112-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|71-preAction
        } else if (displayable == Palos) {
            if (command == Salir) {//GEN-END:|7-commandAction|23|71-preAction
                // write pre-action user code here
                switchDisplayable(null, getLosPalosylaBola());//GEN-LINE:|7-commandAction|24|71-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|16-preAction
        } else if (displayable == PantallaInicio) {
            if (command == SalirInicio) {//GEN-END:|7-commandAction|25|16-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|26|16-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|102-preAction
        } else if (displayable == ResponsabilidadesdelJugador) {
            if (command == Salir) {//GEN-END:|7-commandAction|27|102-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|28|102-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|124-preAction
        } else if (displayable == Situaciones) {
            if (command == Salir) {//GEN-END:|7-commandAction|29|124-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|7-commandAction|30|124-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|7-postCommandAction
        }//GEN-END:|7-commandAction|31|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|32|
    //</editor-fold>//GEN-END:|7-commandAction|32|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PantallaInicio ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of PantallaInicio component.
     * @return the initialized component instance
     */
    public Form getPantallaInicio() {
        if (PantallaInicio == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            PantallaInicio = new Form("Bienvenidos al Manual de Reglas", new Item[] { getImageItem(), getImageItem1() });//GEN-BEGIN:|14-getter|1|14-postInit
            PantallaInicio.addCommand(getSalirInicio());
            PantallaInicio.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return PantallaInicio;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SalirInicio ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initiliazed instance of SalirInicio component.
     * @return the initialized component instance
     */
    public Command getSalirInicio() {
        if (SalirInicio == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
            SalirInicio = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|15-getter|1|15-postInit
            // write post-init user code here
        }//GEN-BEGIN:|15-getter|2|
        return SalirInicio;
    }
    //</editor-fold>//GEN-END:|15-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|19-getter|1|19-postInit
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            itemCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: VerLista ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of VerLista component.
     * @return the initialized component instance
     */
    public Command getVerLista() {
        if (VerLista == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            VerLista = new Command("VerLista", Command.OK, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return VerLista;
    }
    //</editor-fold>//GEN-END:|29-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Menu ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of Menu component.
     * @return the initialized component instance
     */
    public List getMenu() {
        if (Menu == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            Menu = new List("Menu del Juego", Choice.IMPLICIT);//GEN-BEGIN:|31-getter|1|31-postInit
            Menu.append("El Juego", null);
            Menu.append("Los Palos y la Bola", null);
            Menu.append("Responsabilidades del Jugador", null);
            Menu.append("Orden del Juego", null);
            Menu.append("Situaciones de la Bola", null);
            Menu.append("Modalidades de Juego", null);
            Menu.append("Administracion", null);
            Menu.append("El Green", null);
            Menu.addCommand(getSalirLista());
            Menu.setCommandListener(this);
            Menu.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false });//GEN-END:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return Menu;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: MenuAction ">//GEN-BEGIN:|31-action|0|31-preAction
    /**
     * Performs an action assigned to the selected list element in the Menu component.
     */
    public void MenuAction() {//GEN-END:|31-action|0|31-preAction
        // enter pre-action user code here
        String __selectedString = getMenu().getString(getMenu().getSelectedIndex());//GEN-BEGIN:|31-action|1|35-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("El Juego")) {//GEN-END:|31-action|1|35-preAction
                // write pre-action user code here
                switchDisplayable(null, getJuego());//GEN-LINE:|31-action|2|35-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Los Palos y la Bola")) {//GEN-LINE:|31-action|3|63-preAction
                // write pre-action user code here
                switchDisplayable(null, getLosPalosylaBola());//GEN-LINE:|31-action|4|63-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Responsabilidades del Jugador")) {//GEN-LINE:|31-action|5|64-preAction
                // write pre-action user code here
                switchDisplayable(null, getResponsabilidadesdelJugador());//GEN-LINE:|31-action|6|64-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Orden del Juego")) {//GEN-LINE:|31-action|7|65-preAction
                // write pre-action user code here
                switchDisplayable(null, getOrdendelJuego());//GEN-LINE:|31-action|8|65-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Situaciones de la Bola")) {//GEN-LINE:|31-action|9|66-preAction
                // write pre-action user code here
                switchDisplayable(null, getSituaciones());//GEN-LINE:|31-action|10|66-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Modalidades de Juego")) {//GEN-LINE:|31-action|11|67-preAction
                // write pre-action user code here
                switchDisplayable(null, getModalidades());//GEN-LINE:|31-action|12|67-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Administracion")) {//GEN-LINE:|31-action|13|68-preAction
                // write pre-action user code here
                switchDisplayable(null, getAdmin());//GEN-LINE:|31-action|14|68-postAction
                // write post-action user code here
            } else if (__selectedString.equals("El Green")) {//GEN-LINE:|31-action|15|129-preAction
                // write pre-action user code here
                switchDisplayable(null, getGreen());//GEN-LINE:|31-action|16|129-postAction
                // write post-action user code here
            }//GEN-BEGIN:|31-action|17|31-postAction
        }//GEN-END:|31-action|17|31-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|31-action|18|
    //</editor-fold>//GEN-END:|31-action|18|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Juego ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initiliazed instance of Juego component.
     * @return the initialized component instance
     */
    public Form getJuego() {
        if (Juego == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
            Juego = new Form("El Juego", new Item[] { getStringItem1(), getStringItem3(), getStringItem4(), getStringItem5() });//GEN-BEGIN:|37-getter|1|37-postInit
            Juego.addCommand(getSalir());
            Juego.addCommand(getOkCommand());
            Juego.setCommandListener(this);//GEN-END:|37-getter|1|37-postInit
            // write post-init user code here
        }//GEN-BEGIN:|37-getter|2|
        return Juego;
    }
    //</editor-fold>//GEN-END:|37-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SalirLista ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of SalirLista component.
     * @return the initialized component instance
     */
    public Command getSalirLista() {
        if (SalirLista == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            SalirLista = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return SalirLista;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("1.1 El Juego", "El Juego de Golf consiste en jugar una bola con un palo desde el lugar de salida hasta el interior del agujero, mediante un golpe o sucesivos golpes conforme a las Reglas");//GEN-LINE:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of stringItem3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("1.2 EjercerInfluencia Sobre una Bola", "Un jugador o caddie no deben hacer nada para influir en la posici\u00F3n o movimiento de una bola excepto cuando las Reglas lo permitan");//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return stringItem3;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of stringItem4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("1.3 Acuerdo Para Exigir Reglas", "Los jugadores no se pondr\u00E1n de acuerdo para excluir el cumplimiento de una Regla ni suprimir cualquier penalidad incurrida");//GEN-LINE:|48-getter|1|48-postInit
            // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return stringItem4;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of stringItem5 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem5() {
        if (stringItem5 == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            stringItem5 = new StringItem("1.4 Puntos No Previstos de las Reglas", null);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return stringItem5;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Salir ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of Salir component.
     * @return the initialized component instance
     */
    public Command getSalir() {
        if (Salir == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            Salir = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return Salir;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of image1 component.
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|52-getter|1|52-@java.io.IOException
                image1 = Image.createImage("/LogoApp.jpg");
            } catch (java.io.IOException e) {//GEN-END:|52-getter|1|52-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|52-getter|2|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|3|
        return image1;
    }
    //</editor-fold>//GEN-END:|52-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem1 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of imageItem1 component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem1() {
        if (imageItem1 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            imageItem1 = new ImageItem("", getImage2(), ImageItem.LAYOUT_DEFAULT, "<Missing Image>");//GEN-BEGIN:|59-getter|1|59-postInit
            imageItem1.addCommand(getOkCommand());
            imageItem1.setItemCommandListener(this);
            imageItem1.setDefaultCommand(getOkCommand());//GEN-END:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return imageItem1;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image2 ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of image2 component.
     * @return the initialized component instance
     */
    public Image getImage2() {
        if (image2 == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|60-getter|1|60-@java.io.IOException
                image2 = Image.createImage("/Manual.jpg");
            } catch (java.io.IOException e) {//GEN-END:|60-getter|1|60-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|60-getter|2|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|3|
        return image2;
    }
    //</editor-fold>//GEN-END:|60-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Items ">//GEN-BEGIN:|8-itemCommandAction|0|8-preItemCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular item.
     * @param command the Command that was invoked
     * @param displayable the Item where the command was invoked
     */
    public void commandAction(Command command, Item item) {//GEN-END:|8-itemCommandAction|0|8-preItemCommandAction
        // write pre-action user code here
        if (item == imageItem1) {//GEN-BEGIN:|8-itemCommandAction|1|61-preAction
            if (command == okCommand) {//GEN-END:|8-itemCommandAction|1|61-preAction
                // write pre-action user code here
                switchDisplayable(null, getMenu());//GEN-LINE:|8-itemCommandAction|2|61-postAction
                // write post-action user code here
            }//GEN-BEGIN:|8-itemCommandAction|3|8-postItemCommandAction
        }//GEN-END:|8-itemCommandAction|3|8-postItemCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|8-itemCommandAction|4|
    //</editor-fold>//GEN-END:|8-itemCommandAction|4|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Palos ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of Palos component.
     * @return the initialized component instance
     */
    public Form getPalos() {
        if (Palos == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            Palos = new Form("Los Palos y la Bola", new Item[] { getStringItem(), getStringItem2(), getStringItem6(), getStringItem7(), getStringItem8(), getStringItem9() });//GEN-BEGIN:|69-getter|1|69-postInit
            Palos.addCommand(getSalir());
            Palos.setCommandListener(this);//GEN-END:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return Palos;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            stringItem = new StringItem("4.Los Palos", "Un jugador que tenga alguna duda sobre la conformidad de un palo deber\u00EDa consultar con la Real Federaci\u00F3n Espa\u00F1ola de Golf. Un fabricante deber\u00EDa presentar a la Real Federaci\u00F3n Espa\u00F1ola de Golf dos muestras de un palo que se propone fabricar para que resuelva si dicho palo es conforme a las Reglas. Si el fabricante no presenta una muestra o espera por una decisi\u00F3n antes de fabricar y/o comercializar el palo, el fabricante asume el riesgo de una decisi\u00F3n en la que el palo no es conforme con las Reglas. Cualquier muestra presentada a la Real Federaci\u00F3n Espa\u00F1ola de Golf quedar\u00E1 en propiedad de la misma a efectos de referencia. La Real Federaci\u00F3n Espa\u00F1ola de Golf enviar\u00E1 una de las muestras al R & A.");//GEN-LINE:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("Definiciones", "Todos los t\u00E9rminos con definici\u00F3n aparecen escritos en It\u00E1lica (cursiva) y est\u00E1n ordenados alfab\u00E9ticamente en la secci\u00F3n Definiciones. Ver pagina\u2026");//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
        }//GEN-BEGIN:|73-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|73-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem6 ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of stringItem6 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem6() {
        if (stringItem6 == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            stringItem6 = new StringItem("4.1 Forma y Construccion de los Palos", "a. General Los palos de un jugador deben ser conformes con esta Regla y con las provisiones, especificaciones e interpretaciones establecidas en el Ap\u00E9ndice II. b. Desgaste y Alteraciones Un palo que es conforme con las Reglas cuando es nuevo, se considera que es conforme despu\u00E9s de un desgaste producido por su uso normal. Cualquier parte de un palo que ha sido alterada intencionadamente se considerar\u00E1 como nueva y debe, en su estado alterado, ser conforme con las Reglas.");//GEN-LINE:|74-getter|1|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|2|
        return stringItem6;
    }
    //</editor-fold>//GEN-END:|74-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem7 ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of stringItem7 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem7() {
        if (stringItem7 == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            stringItem7 = new StringItem("4.2  Caracter\u00EDsticas de Juego Cambiadas y Materiales Extra\u00F1os", "a. Caracter\u00EDsticas de Juego Cambiadas Durante una vuelta estipulada, las caracter\u00EDsticas de juego de un palo no deben ser cambiadas intencionadamente por ajuste o por cualquier otro medio. b. Materiales Extra\u00F1os No deben aplicarse materiales extra\u00F1os a la cara del palo con el prop\u00F3sito de influir en el movimiento de la bola");//GEN-LINE:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return stringItem7;
    }
    //</editor-fold>//GEN-END:|75-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem8 ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of stringItem8 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem8() {
        if (stringItem8 == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            stringItem8 = new StringItem("4.3 Palos Da\u00F1ados; Reparaci\u00F3n y Sustituci\u00F3n", "a. Da\u00F1o en el Curso Normal del Juego Si, durante una vuelta estipulada, el palo de un jugador se da\u00F1a en el curso normal del juego, \u00E9ste puede: (i) usar el palo en su estado da\u00F1ado por lo que falta de la vuelta estipulada; o (ii) repararlo o mandarlo reparar sin demorar indebidamente el juego; o (iii) como opci\u00F3n adicional, s\u00F3lo si el palo est\u00E1 inservible para el juego, sustituir el palo con cualquier otro palo. La sustituci\u00F3n del palo no debe demorar indebidamente el juego, y no debe hacerse tomando prestado un palo seleccionado para el juego por cualquier otra persona que est\u00E9 jugando en el campo.b. Da\u00F1ado Fuera del Curso Normal del Juego Si, durante una vuelta estipulada, el palo de un jugador se da\u00F1a sin que ocurra en el curso normal del juego y como consecuencia no cumple con las normas o se cambian sus caracter\u00EDsticas de juego, el palo no podr\u00E1 posteriormente ser utilizado o sustituido durante la vuelta. c. Da\u00F1ado Antes de la Vuelta Un jugador puede utilizar un palo que se ha da\u00F1ado antes de una vuelta con tal de que el palo se ajuste a las Reglas en su estado da\u00F1ado. Los da\u00F1os producidos en un palo antes de una vuelta pueden ser reparados durante la vuelta, siempre que no se cambien las caracter\u00EDsticas de juego del palo y no se demore indebidamente el juego.");//GEN-LINE:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return stringItem8;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem9 ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initiliazed instance of stringItem9 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem9() {
        if (stringItem9 == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            stringItem9 = new StringItem("4.4. M\u00E1ximo de Catorce Palos", "a. Selecci\u00F3n y Adici\u00F3n de Palos El jugador no debe iniciar una vuelta estipulada con m\u00E1s de catorce palos. Queda limitado a los palos as\u00ED seleccionados para esa vuelta excepto que, si comenz\u00F3 con menos de catorce palos, puede a\u00F1adir otros siempre que el n\u00FAmero total no exceda de catorce. La adici\u00F3n de un(os) palo(s) no debe demorar indebidamente el juego (Regla 6-7) y el jugador no a\u00F1adir\u00E1 o pedir\u00E1 prestado ning\u00FAn palo elegido para el juego por cualquier otra persona que est\u00E9 jugando en el campo. b. Los Compa\u00F1eros Pueden Compartir Palos Los compa\u00F1eros pueden compartir palos, siempre que el n\u00FAmero total de palos llevados por los compa\u00F1eros para compartir no exceda de catorce.c. Palos en Exceso Declarados Fuera de Juego Cualquier palo o palos llevados o usados infringiendo la Regla 4-3a (iii) o la 4-4 deben ser declarados fuera de juego por el jugador a su contrario en el juego por hoyos o a su marcador o a un compa\u00F1ero competidor en el juego por golpes, inmediatamente despu\u00E9s de que se descubra que ha habido una infracci\u00F3n. El jugador no usara el palo o palos por lo que reste de la vuelta estipulada");//GEN-LINE:|77-getter|1|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|2|
        return stringItem9;
    }
    //</editor-fold>//GEN-END:|77-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LosPalosylaBola ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initiliazed instance of LosPalosylaBola component.
     * @return the initialized component instance
     */
    public List getLosPalosylaBola() {
        if (LosPalosylaBola == null) {//GEN-END:|80-getter|0|80-preInit
            // write pre-init user code here
            LosPalosylaBola = new List("Seleccione una Categoria", Choice.IMPLICIT);//GEN-BEGIN:|80-getter|1|80-postInit
            LosPalosylaBola.append("Los Palos", null);
            LosPalosylaBola.append("La Bola", null);
            LosPalosylaBola.addCommand(getCancelCommand());
            LosPalosylaBola.setCommandListener(this);
            LosPalosylaBola.setSelectedFlags(new boolean[] { false, false });//GEN-END:|80-getter|1|80-postInit
            // write post-init user code here
        }//GEN-BEGIN:|80-getter|2|
        return LosPalosylaBola;
    }
    //</editor-fold>//GEN-END:|80-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: LosPalosylaBolaAction ">//GEN-BEGIN:|80-action|0|80-preAction
    /**
     * Performs an action assigned to the selected list element in the LosPalosylaBola component.
     */
    public void LosPalosylaBolaAction() {//GEN-END:|80-action|0|80-preAction
        // enter pre-action user code here
        String __selectedString = getLosPalosylaBola().getString(getLosPalosylaBola().getSelectedIndex());//GEN-BEGIN:|80-action|1|83-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Los Palos")) {//GEN-END:|80-action|1|83-preAction
                // write pre-action user code here
                switchDisplayable(null, getPalos());//GEN-LINE:|80-action|2|83-postAction
                // write post-action user code here
            } else if (__selectedString.equals("La Bola")) {//GEN-LINE:|80-action|3|84-preAction
                // write pre-action user code here
                switchDisplayable(null, getLaBola());//GEN-LINE:|80-action|4|84-postAction
                // write post-action user code here
            }//GEN-BEGIN:|80-action|5|80-postAction
        }//GEN-END:|80-action|5|80-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|80-action|6|
    //</editor-fold>//GEN-END:|80-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LaBola ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of LaBola component.
     * @return the initialized component instance
     */
    public Form getLaBola() {
        if (LaBola == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            LaBola = new Form("La Bola", new Item[] { getStringItem10(), getStringItem11(), getStringItem12() });//GEN-BEGIN:|89-getter|1|89-postInit
            LaBola.addCommand(getSalir());
            LaBola.setCommandListener(this);//GEN-END:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return LaBola;
    }
    //</editor-fold>//GEN-END:|89-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem10 ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initiliazed instance of stringItem10 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem10() {
        if (stringItem10 == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            stringItem10 = new StringItem("5.1 La bola", "Definiciones: Todos los t\u00E9rminos con definici\u00F3n aparecen escritos en It\u00E1lica (cursiva) y est\u00E1n ordenados alfab\u00E9ticamente en la secci\u00F3n Definiciones. Ver pagina\u2026 5-1. General La bola que el jugador juegue deber\u00E1 cumplir los requisitos especificados en el Ap\u00E9ndice III.");//GEN-LINE:|91-getter|1|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|2|
        return stringItem10;
    }
    //</editor-fold>//GEN-END:|91-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem11 ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initiliazed instance of stringItem11 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem11() {
        if (stringItem11 == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            stringItem11 = new StringItem("5.2 Materiales Extra\u00F1os", "No deben aplicarse a la bola materiales extra\u00F1os con el prop\u00F3sito de cambiar sus caracter\u00EDsticas de juego.");//GEN-LINE:|92-getter|1|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return stringItem11;
    }
    //</editor-fold>//GEN-END:|92-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem12 ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of stringItem12 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem12() {
        if (stringItem12 == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            stringItem12 = new StringItem("5.3 Bola inservible", "Una bola est\u00E1 inservible para el juego si est\u00E1 visiblemente cortada, rajada o deformada. Una bola no est\u00E1 inservible para el juego solamente porque tenga adherido barro u otros materiales, su superficie este rayada o ara\u00F1ada o su pintura este da\u00F1ada o descolorida. Si un jugador tiene razones para creer que su bola ha quedado inservible para el juego durante el juego del hoyo que se est\u00E1 jugando, puede levantar la bola, sin penalidad, para determinar si est\u00E1 inservible. Antes de levantar la bola, el jugador debe anunciar su intenci\u00F3n a su contrario en el juego por hoyos, o a su marcador o a un compa\u00F1ero-competidor en el juego por golpes, y marcar la posici\u00F3n de la bola. Entonces puede levantarla y examinarla siempre que d\u00E9 a su contrario, marcador o compa\u00F1ero- competidor la oportunidad de examinar la bola y observar el proceso de levantar y reponer la bola. La bola no debe ser limpiada cuando es levantada bajo la Regla 5-3. Si el jugador no cumple con todo o parte de este procedimiento, incurre en la penalidad de un golpe. Si se determina que la bola ha quedado inservible para el juego durante el juego del hoyo que se est\u00E1 jugando, el jugador puede sustituirla por otra bola, coloc\u00E1ndola en el punto donde reposaba la bola original. De otra manera, la bola original ser\u00E1 repuesta. Si un jugador sustituye una bola cuando no esta permitido y efect\u00FAa un golpe a la bola sustituida equivocadamente, incurre en la penalidad general por infracci\u00F3n de la Regla 5-3, pero no hay penalidad adicional bajo esta Regla o la Regla 15-1. Si una bola se rompe en pedazos como resultado de un golpe, el golpe se cancela y el jugador jugar\u00E1 una bola, sin penalidad, tan cerca como sea posible del punto desde el cual fue jugada la bola original (ver Regla 20-5)");//GEN-LINE:|93-getter|1|93-postInit
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|2|
        return stringItem12;
    }
    //</editor-fold>//GEN-END:|93-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|86-getter|1|86-postInit
            // write post-init user code here
        }//GEN-BEGIN:|86-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|86-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            imageItem = new ImageItem("", getImage1(), ImageItem.LAYOUT_DEFAULT, "<Missing Image>");//GEN-LINE:|100-getter|1|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|100-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ResponsabilidadesdelJugador ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of ResponsabilidadesdelJugador component.
     * @return the initialized component instance
     */
    public Form getResponsabilidadesdelJugador() {
        if (ResponsabilidadesdelJugador == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            ResponsabilidadesdelJugador = new Form("LOS JUGADORES", new Item[] { getStringItem13(), getStringItem14(), getStringItem15(), getStringItem16(), getStringItem17() });//GEN-BEGIN:|101-getter|1|101-postInit
            ResponsabilidadesdelJugador.addCommand(getSalir());
            ResponsabilidadesdelJugador.setCommandListener(this);//GEN-END:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return ResponsabilidadesdelJugador;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem13 ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of stringItem13 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem13() {
        if (stringItem13 == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            stringItem13 = new StringItem("Handicas JUego por Hoyos", "Antes de empezar un partido en una competici\u00F3n handicap, los jugadores deber\u00EDan determinar mutuamente sus respectivos handicaps. Si un jugador comienza un partido habiendo declarado un handicap m\u00E1s alto al que tiene derecho y eso afecta al n\u00FAmero de golpes dados o recibidos, est\u00E1 descalificado; de otra manera el jugador debe jugar con el handicap declarado.");//GEN-LINE:|103-getter|1|103-postInit
            // write post-init user code here
        }//GEN-BEGIN:|103-getter|2|
        return stringItem13;
    }
    //</editor-fold>//GEN-END:|103-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem14 ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of stringItem14 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem14() {
        if (stringItem14 == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            stringItem14 = new StringItem("Juego por Golpes", "Juego por Golpes En cualquier vuelta de una competici\u00F3n handicap, el competidor debe asegurarse que su handicap figura en su tarjeta antes de que sea devuelta al Comit\u00E9. Si no figura ning\u00FAn handicap en su tarjeta antes de que sea devuelta (Regla 6-6b), o si el handicap que figura en ella es m\u00E1s alto al que tiene derecho y esto afecta al n\u00FAmero de golpes recibidos, est\u00E1 descalificado de la competici\u00F3n handicap; de otra manera, el resultado es v\u00E1lido.");//GEN-LINE:|104-getter|1|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return stringItem14;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem15 ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of stringItem15 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem15() {
        if (stringItem15 == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            stringItem15 = new StringItem("Firmar y devolver la targeta", "Despu\u00E9s de terminada la vuelta, el competidor deber\u00EDa comprobar su resultado de cada hoyo y aclarar con el Comit\u00E9 cualquier punto dudoso. Debe asegurarse de que el marcador o marcadores han firmado la tarjeta, firmarla \u00E9l mismo la tarjeta y devolverla al Comit\u00E9 tan pronto como sea posible.");//GEN-LINE:|106-getter|1|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return stringItem15;
    }
    //</editor-fold>//GEN-END:|106-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem16 ">//GEN-BEGIN:|107-getter|0|107-preInit
    /**
     * Returns an initiliazed instance of stringItem16 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem16() {
        if (stringItem16 == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            stringItem16 = new StringItem("Alteraci\u00F3n de la Tarjeta", "No puede hacerse ninguna modificaci\u00F3n de una tarjeta despu\u00E9s de que el competidor la ha devuelto al Comit\u00E9");//GEN-LINE:|107-getter|1|107-postInit
            // write post-init user code here
        }//GEN-BEGIN:|107-getter|2|
        return stringItem16;
    }
    //</editor-fold>//GEN-END:|107-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem17 ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of stringItem17 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem17() {
        if (stringItem17 == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            stringItem17 = new StringItem("Finalizacion de juego por golpes", "a. Anotaci\u00F3n de Resultados Despu\u00E9s de cada hoyo el marcador deber\u00EDa comprobar el resultado con el competidor y anotarlo. Al termino de la vuelta el marcador debe firmar la tarjeta y entregarla al competidor. Si los resultados han sido anotados por m\u00E1s de un marcador, cada uno de ellos debe firmar la parte de la que es responsable. b. Firmar y Devolver la Tarjeta Despu\u00E9s de terminada la vuelta, el competidor deber\u00EDa comprobar su resultado de cada hoyo y aclarar con el Comit\u00E9 cualquier punto dudoso. Debe asegurarse de que el marcador o marcadores han firmado la tarjeta, firmarla \u00E9l mismo la tarjeta y devolverla al Comit\u00E9 tan pronto como sea posible.");//GEN-LINE:|110-getter|1|110-postInit
            // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return stringItem17;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OrdendelJuego ">//GEN-BEGIN:|111-getter|0|111-preInit
    /**
     * Returns an initiliazed instance of OrdendelJuego component.
     * @return the initialized component instance
     */
    public Form getOrdendelJuego() {
        if (OrdendelJuego == null) {//GEN-END:|111-getter|0|111-preInit
            // write pre-init user code here
            OrdendelJuego = new Form("Orden del Juego", new Item[] { getStringItem18(), getStringItem19(), getStringItem20() });//GEN-BEGIN:|111-getter|1|111-postInit
            OrdendelJuego.addCommand(getSalir());
            OrdendelJuego.setCommandListener(this);//GEN-END:|111-getter|1|111-postInit
            // write post-init user code here
        }//GEN-BEGIN:|111-getter|2|
        return OrdendelJuego;
    }
    //</editor-fold>//GEN-END:|111-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem18 ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of stringItem18 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem18() {
        if (stringItem18 == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            stringItem18 = new StringItem("a. Iniciando el Juego del Hoyo", " El bando que ha de tener el honor en el primer lugar de salida est\u00E1 determinado por el orden de salidas. En ausencia del orden de salidas, el honor deber\u00EDa decidirse por sorteo. El bando que gana un hoyo obtendr\u00E1 el honor en el siguiente lugar de salida. Si un hoyo ha quedado empatado, el bando que ten\u00EDa el honor en el anterior lugar de salida lo conserva.");//GEN-LINE:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return stringItem18;
    }
    //</editor-fold>//GEN-END:|115-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem19 ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of stringItem19 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem19() {
        if (stringItem19 == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            stringItem19 = new StringItem("b. Durante el Juego de un Hoyo", "Despu\u00E9s de que ambos jugadores han iniciado el juego del hoyo, se jugar\u00E1 primero la bola m\u00E1s alejada del agujero. Si las bolas est\u00E1n equidistantes del agujero o si sus posiciones relativas respecto del agujero no son determinables, la bola que se juega primero deber\u00EDa decidirse por sorteo.");//GEN-LINE:|116-getter|1|116-postInit
            // write post-init user code here
        }//GEN-BEGIN:|116-getter|2|
        return stringItem19;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem20 ">//GEN-BEGIN:|117-getter|0|117-preInit
    /**
     * Returns an initiliazed instance of stringItem20 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem20() {
        if (stringItem20 == null) {//GEN-END:|117-getter|0|117-preInit
            // write pre-init user code here
            stringItem20 = new StringItem("c. Jugar Fuera de Turno", "Si un jugador juega cuando deber\u00EDa haber jugado su contrario, no hay penalidad, pero el contrario puede inmediatamente requerir al jugador que cancele el golpe efectuado y, en el orden correcto, jugar una bola tan cerca como sea posible del punto desde el que la bola original fue jugada por \u00FAltima vez");//GEN-LINE:|117-getter|1|117-postInit
            // write post-init user code here
        }//GEN-BEGIN:|117-getter|2|
        return stringItem20;
    }
    //</editor-fold>//GEN-END:|117-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Situaciones ">//GEN-BEGIN:|120-getter|0|120-preInit
    /**
     * Returns an initiliazed instance of Situaciones component.
     * @return the initialized component instance
     */
    public Form getSituaciones() {
        if (Situaciones == null) {//GEN-END:|120-getter|0|120-preInit
            // write pre-init user code here
            Situaciones = new Form("Situaciones de la Bola", new Item[] { getStringItem21(), getStringItem22(), getStringItem23(), getStringItem24(), getStringItem25() });//GEN-BEGIN:|120-getter|1|120-postInit
            Situaciones.addCommand(getSalir());
            Situaciones.setCommandListener(this);//GEN-END:|120-getter|1|120-postInit
            // write post-init user code here
        }//GEN-BEGIN:|120-getter|2|
        return Situaciones;
    }
    //</editor-fold>//GEN-END:|120-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem21 ">//GEN-BEGIN:|121-getter|0|121-preInit
    /**
     * Returns an initiliazed instance of stringItem21 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem21() {
        if (stringItem21 == null) {//GEN-END:|121-getter|0|121-preInit
            // write pre-init user code here
            stringItem21 = new StringItem("BOLA MOVIDA, DESVIADA O DETENIDA ", null);//GEN-LINE:|121-getter|1|121-postInit
            // write post-init user code here
        }//GEN-BEGIN:|121-getter|2|
        return stringItem21;
    }
    //</editor-fold>//GEN-END:|121-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem22 ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of stringItem22 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem22() {
        if (stringItem22 == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            stringItem22 = new StringItem("18-1. Por Causa Ajena", "Si una bola en reposo es movida por una causa ajena, no hay penalidad y la bola debe ser repuesta.");//GEN-LINE:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return stringItem22;
    }
    //</editor-fold>//GEN-END:|122-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem23 ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of stringItem23 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem23() {
        if (stringItem23 == null) {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            stringItem23 = new StringItem("18-2. Por el Jugador, Compa\u00F1ero, Caddie o Equipo", "Cuando la bola de un jugador est\u00E1 en juego, si: (i) el jugador, su compa\u00F1ero o cualquiera de sus caddies la levanta o la mueve, la toca intencionadamente (excepto con el palo al preparar el golpe), o causa que la bola se mueva excepto que una Regla lo permita, o (ii) el equipo del jugador o el de su compa\u00F1ero hace que la bola se mueva, \u00E9l jugador incurre en la penalidad de un golpe. Si la bola es movida, debe ser repuesta salvo que el movimiento de la bola ocurra despu\u00E9s de que el jugador haya iniciado el golpe o el movimiento hacia atr\u00E1s del palo para realizar el golpe y el golpe se ejecute. Bajo las Reglas, no hay penalidad si un jugador accidentalmente causa que su bola se mueva en las siguientes circunstancias: - En la b\u00FAsqueda de una bola en un obst\u00E1culo cubierta por impedimentos sueltos o arena, o de una bola en una condici\u00F3n anormal del terreno o de una bola que se cree que est\u00E1 en agua en un obst\u00E1culo de agua - Regla 12-1. - Al arreglar la tapa de un agujero o el impacto de una bola - Regla 16-1c. - Al medir - Regla 18-6. - Al levantar una bola bajo una Regla - Regla 20-1. - Al colocar o reponer una bola de acuerdo con una Regla - Regla 20-3a. - Al quitar un impedimento suelto en el green - Regla 23-1. - Al quitar obstrucciones movibles - Regla 24-1.");//GEN-LINE:|123-getter|1|123-postInit
            // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return stringItem23;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem24 ">//GEN-BEGIN:|127-getter|0|127-preInit
    /**
     * Returns an initiliazed instance of stringItem24 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem24() {
        if (stringItem24 == null) {//GEN-END:|127-getter|0|127-preInit
            // write pre-init user code here
            stringItem24 = new StringItem("b. Bola Movida Despu\u00E9s de Preparar el Golpe", "Si la bola en juego de un jugador se mueve despu\u00E9s de que ha preparado el golpe (por otra causa que no sea como resultado de un golpe), se considera que el jugador ha movido la bola e incurre en un golpe de penalidad. La bola debe ser repuesta, salvo que el movimiento de la bola ocurra despu\u00E9s de que el jugador ha iniciado el golpe o el movimiento hacia atr\u00E1s del palo para realizar el golpe y el golpe se haya ejecutado.");//GEN-LINE:|127-getter|1|127-postInit
            // write post-init user code here
        }//GEN-BEGIN:|127-getter|2|
        return stringItem24;
    }
    //</editor-fold>//GEN-END:|127-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem25 ">//GEN-BEGIN:|128-getter|0|128-preInit
    /**
     * Returns an initiliazed instance of stringItem25 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem25() {
        if (stringItem25 == null) {//GEN-END:|128-getter|0|128-preInit
            // write pre-init user code here
            stringItem25 = new StringItem("18-4. Por el Compa\u00F1ero-Competidor, su Caddie o Equipo en el Juego por Golpes", "Si un compa\u00F1ero-competidor, su caddie o su equipo mueven la bola del jugador, la tocan o causan que se mueva, no hay penalidad. Si la bola se ha movido debe ser repuesta");//GEN-LINE:|128-getter|1|128-postInit
            // write post-init user code here
        }//GEN-BEGIN:|128-getter|2|
        return stringItem25;
    }
    //</editor-fold>//GEN-END:|128-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Green ">//GEN-BEGIN:|131-getter|0|131-preInit
    /**
     * Returns an initiliazed instance of Green component.
     * @return the initialized component instance
     */
    public Form getGreen() {
        if (Green == null) {//GEN-END:|131-getter|0|131-preInit
            // write pre-init user code here
            Green = new Form("El Green", new Item[] { getStringItem26(), getStringItem27(), getStringItem28(), getStringItem29(), getStringItem30(), getStringItem31(), getStringItem32(), getStringItem33() });//GEN-BEGIN:|131-getter|1|131-postInit
            Green.addCommand(getSalir());
            Green.setCommandListener(this);//GEN-END:|131-getter|1|131-postInit
            // write post-init user code here
        }//GEN-BEGIN:|131-getter|2|
        return Green;
    }
    //</editor-fold>//GEN-END:|131-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem26 ">//GEN-BEGIN:|134-getter|0|134-preInit
    /**
     * Returns an initiliazed instance of stringItem26 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem26() {
        if (stringItem26 == null) {//GEN-END:|134-getter|0|134-preInit
            // write pre-init user code here
            stringItem26 = new StringItem("16-1. General", null);//GEN-LINE:|134-getter|1|134-postInit
            // write post-init user code here
        }//GEN-BEGIN:|134-getter|2|
        return stringItem26;
    }
    //</editor-fold>//GEN-END:|134-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem27 ">//GEN-BEGIN:|135-getter|0|135-preInit
    /**
     * Returns an initiliazed instance of stringItem27 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem27() {
        if (stringItem27 == null) {//GEN-END:|135-getter|0|135-preInit
            // write pre-init user code here
            stringItem27 = new StringItem("a. Tocar la L\u00EDnea de Putt", "La l\u00EDnea de putt no debe ser tocada, excepto: (i) el jugador puede quitar impedimentos sueltos, siempre que no presione nada hacia abajo; (ii) el jugador puede colocar el palo delante de la bola cuando prepara el golpe, siempre que no presione nada hacia abajo; (iii) al medir - Regla 18-6; (iv) al levantar la bola - Regla 16-1b; (v) al presionar hacia abajo un marcador de bola; (vi) al reparar viejas tapas de agujeros o marcas de bola en el green - Regla 16-1c; y (vii) al quitar obstrucciones movibles \u2013 Regla 24-1. (Indicaci\u00F3n de la l\u00EDnea de putt en el green - ver la Regla 8-2b).");//GEN-LINE:|135-getter|1|135-postInit
            // write post-init user code here
        }//GEN-BEGIN:|135-getter|2|
        return stringItem27;
    }
    //</editor-fold>//GEN-END:|135-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem28 ">//GEN-BEGIN:|136-getter|0|136-preInit
    /**
     * Returns an initiliazed instance of stringItem28 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem28() {
        if (stringItem28 == null) {//GEN-END:|136-getter|0|136-preInit
            // write pre-init user code here
            stringItem28 = new StringItem("b. Levantar y Limpiar la Bola", "Una bola en el green puede ser levantada y si se desea limpiada. La posici\u00F3n de la bola debe ser marcada antes de levantarla y la bola debe ser repuesta (ver Regla 20-1).");//GEN-LINE:|136-getter|1|136-postInit
            // write post-init user code here
        }//GEN-BEGIN:|136-getter|2|
        return stringItem28;
    }
    //</editor-fold>//GEN-END:|136-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem29 ">//GEN-BEGIN:|137-getter|0|137-preInit
    /**
     * Returns an initiliazed instance of stringItem29 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem29() {
        if (stringItem29 == null) {//GEN-END:|137-getter|0|137-preInit
            // write pre-init user code here
            stringItem29 = new StringItem("c. Reparaci\u00F3n de Tapas de Agujeros, Marcas de Bola y Otros Da\u00F1os", "El jugador puede reparar una vieja tapa de agujero o da\u00F1os en el green causados por el impacto de una bola, est\u00E9 o no la bola del jugador reposando en el green. Si una bola o un marcador de bola se mueve accidentalmente en el proceso de la reparaci\u00F3n, la bola o el marcador de bola deben ser repuestos. No hay penalidad siempre que el movimiento de la bola sea directamente atribuible al acto espec\u00EDfico de reparar una vieja tapa de agujero o da\u00F1os en el green causados por el impacto de una bola.");//GEN-LINE:|137-getter|1|137-postInit
            // write post-init user code here
        }//GEN-BEGIN:|137-getter|2|
        return stringItem29;
    }
    //</editor-fold>//GEN-END:|137-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem30 ">//GEN-BEGIN:|138-getter|0|138-preInit
    /**
     * Returns an initiliazed instance of stringItem30 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem30() {
        if (stringItem30 == null) {//GEN-END:|138-getter|0|138-preInit
            // write pre-init user code here
            stringItem30 = new StringItem("d. Probar la Superficie", "Durante el juego de un hoyo, un jugador no debe probar la superficie del green haciendo rodar una bola o rascando o raspando la superficie.");//GEN-LINE:|138-getter|1|138-postInit
            // write post-init user code here
        }//GEN-BEGIN:|138-getter|2|
        return stringItem30;
    }
    //</editor-fold>//GEN-END:|138-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem31 ">//GEN-BEGIN:|139-getter|0|139-preInit
    /**
     * Returns an initiliazed instance of stringItem31 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem31() {
        if (stringItem31 == null) {//GEN-END:|139-getter|0|139-preInit
            // write pre-init user code here
            stringItem31 = new StringItem("e. Colocarse a Horcajadas o Sobre la L\u00EDnea de Putt", "El jugador no debe jugar un golpe en el green coloc\u00E1ndose a horcajadas, o con cualquiera de sus pies tocando la l\u00EDnea de putt o una prolongaci\u00F3n de \u00E9sta l\u00EDnea detr\u00E1s de la bola.");//GEN-LINE:|139-getter|1|139-postInit
            // write post-init user code here
        }//GEN-BEGIN:|139-getter|2|
        return stringItem31;
    }
    //</editor-fold>//GEN-END:|139-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem32 ">//GEN-BEGIN:|140-getter|0|140-preInit
    /**
     * Returns an initiliazed instance of stringItem32 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem32() {
        if (stringItem32 == null) {//GEN-END:|140-getter|0|140-preInit
            // write pre-init user code here
            stringItem32 = new StringItem("f. Jugar un Golpe Mientras Otra Bola Est\u00E1 en Movimiento", "El jugador no debe jugar un golpe mientras otra bola est\u00E1 en movimiento despu\u00E9s de un golpe en el green, excepto que, si el jugador lo hace, no hay penalidad si era su turno de juego. (Levantar una bola que ayuda o interfiere al juego mientras otra bola est\u00E1 en movimiento");//GEN-LINE:|140-getter|1|140-postInit
            // write post-init user code here
        }//GEN-BEGIN:|140-getter|2|
        return stringItem32;
    }
    //</editor-fold>//GEN-END:|140-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem33 ">//GEN-BEGIN:|141-getter|0|141-preInit
    /**
     * Returns an initiliazed instance of stringItem33 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem33() {
        if (stringItem33 == null) {//GEN-END:|141-getter|0|141-preInit
            // write pre-init user code here
            stringItem33 = new StringItem("16-2. Bola Colgando Sobre el Agujero", "Cuando cualquier parte de la bola cuelga sobre el borde del agujero, le est\u00E1 permitido al jugador suficiente tiempo para llegar al agujero sin demora indebida y diez segundos adicionales para determinar si la bola est\u00E1 en reposo. Si para entonces la bola no ha ca\u00EDdo dentro del agujero, se considera que est\u00E1 en reposo. Si despu\u00E9s la bola cae dentro del agujero, se considera que el jugador ha embocado con su ultimo golpe, y debe a\u00F1adir un golpe de penalidad a su resultado del hoyo; de otra manera no hay penalidad bajo esta Regla");//GEN-LINE:|141-getter|1|141-postInit
            // write post-init user code here
        }//GEN-BEGIN:|141-getter|2|
        return stringItem33;
    }
    //</editor-fold>//GEN-END:|141-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Modalidades ">//GEN-BEGIN:|142-getter|0|142-preInit
    /**
     * Returns an initiliazed instance of Modalidades component.
     * @return the initialized component instance
     */
    public Form getModalidades() {
        if (Modalidades == null) {//GEN-END:|142-getter|0|142-preInit
            // write pre-init user code here
            Modalidades = new Form("Modalidades de Juego", new Item[] { getStringItem34(), getStringItem35(), getStringItem36(), getStringItem37(), getStringItem38(), getStringItem39(), getStringItem40(), getStringItem41() });//GEN-BEGIN:|142-getter|1|142-postInit
            Modalidades.addCommand(getSalir());
            Modalidades.setCommandListener(this);//GEN-END:|142-getter|1|142-postInit
            // write post-init user code here
        }//GEN-BEGIN:|142-getter|2|
        return Modalidades;
    }
    //</editor-fold>//GEN-END:|142-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem34 ">//GEN-BEGIN:|150-getter|0|150-preInit
    /**
     * Returns an initiliazed instance of stringItem34 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem34() {
        if (stringItem34 == null) {//GEN-END:|150-getter|0|150-preInit
            // write pre-init user code here
            stringItem34 = new StringItem("OTRAS MODALIDADES DE JUEGO", null);//GEN-LINE:|150-getter|1|150-postInit
            // write post-init user code here
        }//GEN-BEGIN:|150-getter|2|
        return stringItem34;
    }
    //</editor-fold>//GEN-END:|150-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem35 ">//GEN-BEGIN:|151-getter|0|151-preInit
    /**
     * Returns an initiliazed instance of stringItem35 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem35() {
        if (stringItem35 == null) {//GEN-END:|151-getter|0|151-preInit
            // write pre-init user code here
            stringItem35 = new StringItem("Regla 29. Threesomes y Foursomes", null);//GEN-LINE:|151-getter|1|151-postInit
            // write post-init user code here
        }//GEN-BEGIN:|151-getter|2|
        return stringItem35;
    }
    //</editor-fold>//GEN-END:|151-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem36 ">//GEN-BEGIN:|152-getter|0|152-preInit
    /**
     * Returns an initiliazed instance of stringItem36 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem36() {
        if (stringItem36 == null) {//GEN-END:|152-getter|0|152-preInit
            // write pre-init user code here
            stringItem36 = new StringItem("29-1. General", "En un threesome o en un foursome, durante cualquier vuelta estipulada los compa\u00F1eros deben jugar alternativamente desde los lugares de salida y dar\u00E1n golpes alternos durante el juego de cada hoyo. Los golpes de penalidad no afectan al orden del juego.");//GEN-LINE:|152-getter|1|152-postInit
            // write post-init user code here
        }//GEN-BEGIN:|152-getter|2|
        return stringItem36;
    }
    //</editor-fold>//GEN-END:|152-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem37 ">//GEN-BEGIN:|153-getter|0|153-preInit
    /**
     * Returns an initiliazed instance of stringItem37 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem37() {
        if (stringItem37 == null) {//GEN-END:|153-getter|0|153-preInit
            // write pre-init user code here
            stringItem37 = new StringItem("29-2. Juego por Hoyos", "Si un jugador juega cuando deber\u00EDa haberlo hecho su compa\u00F1ero, su bando pierde el hoyo.");//GEN-LINE:|153-getter|1|153-postInit
            // write post-init user code here
        }//GEN-BEGIN:|153-getter|2|
        return stringItem37;
    }
    //</editor-fold>//GEN-END:|153-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem38 ">//GEN-BEGIN:|154-getter|0|154-preInit
    /**
     * Returns an initiliazed instance of stringItem38 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem38() {
        if (stringItem38 == null) {//GEN-END:|154-getter|0|154-preInit
            // write pre-init user code here
            stringItem38 = new StringItem("29-3. Juego por Golpes", "Si los compa\u00F1eros ejecutan un golpe o golpes en orden incorrecto, dicho golpe o golpes ser\u00E1n cancelados y el bando incurre en la penalidad de dos golpes. El bando debe corregir el error jugando una bola en el orden correcto tan cerca como sea posible del punto desde el que se jug\u00F3 por primera vez en orden incorrecto (ver la Regla 20-5). Si el bando juega un golpe desde el siguiente lugar de salida sin corregir primero el error o, en el caso del \u00FAltimo hoyo de la vuelta, abandona el green sin declarar su intenci\u00F3n de corregir el error, el bando est\u00E1 descalificado.");//GEN-LINE:|154-getter|1|154-postInit
            // write post-init user code here
        }//GEN-BEGIN:|154-getter|2|
        return stringItem38;
    }
    //</editor-fold>//GEN-END:|154-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem39 ">//GEN-BEGIN:|155-getter|0|155-preInit
    /**
     * Returns an initiliazed instance of stringItem39 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem39() {
        if (stringItem39 == null) {//GEN-END:|155-getter|0|155-preInit
            // write pre-init user code here
            stringItem39 = new StringItem("Regla 30. Competiciones Contra Bogey, Contra Par y Stableford", "");//GEN-LINE:|155-getter|1|155-postInit
            // write post-init user code here
        }//GEN-BEGIN:|155-getter|2|
        return stringItem39;
    }
    //</editor-fold>//GEN-END:|155-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem40 ">//GEN-BEGIN:|156-getter|0|156-preInit
    /**
     * Returns an initiliazed instance of stringItem40 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem40() {
        if (stringItem40 == null) {//GEN-END:|156-getter|0|156-preInit
            // write pre-init user code here
            stringItem40 = new StringItem("a. Competiciones Contra Bogey y Contra Par", "El recuento para las competiciones contra bogey y contra par se hace como en el juego por hoyos. Cualquier hoyo en el que un competidor no anota el resultado se considerar\u00E1 como perdido. El ganador es el competidor que tenga mejor resultado en la suma de los hoyos. El marcador es responsable de anotar solamente el n\u00FAmero bruto de golpes en cada hoyo en el que el competidor obtenga un resultado neto igual o inferior que el resultado fijado");//GEN-LINE:|156-getter|1|156-postInit
            // write post-init user code here
        }//GEN-BEGIN:|156-getter|2|
        return stringItem40;
    }
    //</editor-fold>//GEN-END:|156-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem41 ">//GEN-BEGIN:|157-getter|0|157-preInit
    /**
     * Returns an initiliazed instance of stringItem41 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem41() {
        if (stringItem41 == null) {//GEN-END:|157-getter|0|157-preInit
            // write pre-init user code here
            stringItem41 = new StringItem("b. Competiciones Stableford", "El recuento en las competiciones Stableford se hace por puntos obtenidos en relaci\u00F3n con un resultado fijado para cada hoyo, como sigue:");//GEN-LINE:|157-getter|1|157-postInit
            // write post-init user code here
        }//GEN-BEGIN:|157-getter|2|
        return stringItem41;
    }
    //</editor-fold>//GEN-END:|157-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Admin ">//GEN-BEGIN:|143-getter|0|143-preInit
    /**
     * Returns an initiliazed instance of Admin component.
     * @return the initialized component instance
     */
    public Form getAdmin() {
        if (Admin == null) {//GEN-END:|143-getter|0|143-preInit
            // write pre-init user code here
            Admin = new Form("Administracion", new Item[] { getStringItem42(), getStringItem43(), getStringItem44(), getStringItem45(), getStringItem46(), getStringItem47(), getStringItem48(), getStringItem49(), getStringItem50() });//GEN-BEGIN:|143-getter|1|143-postInit
            Admin.addCommand(getSalir());
            Admin.setCommandListener(this);//GEN-END:|143-getter|1|143-postInit
            // write post-init user code here
        }//GEN-BEGIN:|143-getter|2|
        return Admin;
    }
    //</editor-fold>//GEN-END:|143-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem42 ">//GEN-BEGIN:|162-getter|0|162-preInit
    /**
     * Returns an initiliazed instance of stringItem42 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem42() {
        if (stringItem42 == null) {//GEN-END:|162-getter|0|162-preInit
            // write pre-init user code here
            stringItem42 = new StringItem("El Comit\u00E9", null);//GEN-LINE:|162-getter|1|162-postInit
            // write post-init user code here
        }//GEN-BEGIN:|162-getter|2|
        return stringItem42;
    }
    //</editor-fold>//GEN-END:|162-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem43 ">//GEN-BEGIN:|163-getter|0|163-preInit
    /**
     * Returns an initiliazed instance of stringItem43 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem43() {
        if (stringItem43 == null) {//GEN-END:|163-getter|0|163-preInit
            // write pre-init user code here
            stringItem43 = new StringItem("Condiciones: Excluir una Regla", "El Comit\u00E9 debe establecer las condiciones bajo las cuales se ha de jugar una competici\u00F3n. El Comit\u00E9 no tiene autoridad para excluir una Regla de Golf. Ciertas Reglas espec\u00EDficas que rigen el juego por golpes son tan sustancialmente diferentes de aquellas que rigen el juego por hoyos que la combinaci\u00F3n de las dos modalidades de juego no es factible y no est\u00E1 permitida. Los resultados de los partidos y las tarjetas entregadas en estas circunstancias, no deben ser aceptadas. En el juego por golpes el Comit\u00E9 puede limitar las funciones de un \u00E1rbitro");//GEN-LINE:|163-getter|1|163-postInit
            // write post-init user code here
        }//GEN-BEGIN:|163-getter|2|
        return stringItem43;
    }
    //</editor-fold>//GEN-END:|163-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem44 ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of stringItem44 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem44() {
        if (stringItem44 == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            stringItem44 = new StringItem("El Campo", null);//GEN-LINE:|164-getter|1|164-postInit
            // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return stringItem44;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem45 ">//GEN-BEGIN:|165-getter|0|165-preInit
    /**
     * Returns an initiliazed instance of stringItem45 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem45() {
        if (stringItem45 == null) {//GEN-END:|165-getter|0|165-preInit
            // write pre-init user code here
            stringItem45 = new StringItem("a. Definici\u00F3n de L\u00EDmites y M\u00E1rgenes", "El Comit\u00E9 debe definir con precisi\u00F3n: (i) el campo y los fuera de l\u00EDmites, (ii) los m\u00E1rgenes de los obst\u00E1culos de agua y obst\u00E1culos de agua lateral, (iii) el terreno en reparaci\u00F3n, y (iv) las obstrucciones y partes integrantes del campo");//GEN-LINE:|165-getter|1|165-postInit
            // write post-init user code here
        }//GEN-BEGIN:|165-getter|2|
        return stringItem45;
    }
    //</editor-fold>//GEN-END:|165-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem46 ">//GEN-BEGIN:|166-getter|0|166-preInit
    /**
     * Returns an initiliazed instance of stringItem46 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem46() {
        if (stringItem46 == null) {//GEN-END:|166-getter|0|166-preInit
            // write pre-init user code here
            stringItem46 = new StringItem("b. Agujeros Nuevos", "Deber\u00EDan hacerse agujeros nuevos el d\u00EDa en el que comienza una competici\u00F3n por golpes, y en cualquier otra ocasi\u00F3n en que el Comit\u00E9 lo considere necesario, siempre que todos los competidores de una vuelta jueguen con cada uno de los agujeros situados en la misma posici\u00F3n");//GEN-LINE:|166-getter|1|166-postInit
            // write post-init user code here
        }//GEN-BEGIN:|166-getter|2|
        return stringItem46;
    }
    //</editor-fold>//GEN-END:|166-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem47 ">//GEN-BEGIN:|167-getter|0|167-preInit
    /**
     * Returns an initiliazed instance of stringItem47 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem47() {
        if (stringItem47 == null) {//GEN-END:|167-getter|0|167-preInit
            // write pre-init user code here
            stringItem47 = new StringItem("c. Campo de Pr\u00E1cticas", "Donde no haya un campo de pr\u00E1cticas disponible fuera del \u00E1rea de un campo de competici\u00F3n, el Comit\u00E9 deber\u00EDa establecer, si fuera factible, la zona en la que los jugadores puedan practicar en cualquier d\u00EDa de una competici\u00F3n. En cualquier d\u00EDa de una competici\u00F3n por golpes, el Comit\u00E9 no deber\u00EDa normalmente permitir practicar en o hacia un green o desde un obst\u00E1culo del campo de la competici\u00F3n.");//GEN-LINE:|167-getter|1|167-postInit
            // write post-init user code here
        }//GEN-BEGIN:|167-getter|2|
        return stringItem47;
    }
    //</editor-fold>//GEN-END:|167-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem48 ">//GEN-BEGIN:|168-getter|0|168-preInit
    /**
     * Returns an initiliazed instance of stringItem48 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem48() {
        if (stringItem48 == null) {//GEN-END:|168-getter|0|168-preInit
            // write pre-init user code here
            stringItem48 = new StringItem("d. Campo Impracticable", "Si el Comit\u00E9 o su representante autorizado considera que por alguna raz\u00F3n el campo no est\u00E1 en condiciones de juego o que hay circunstancias que hacen imposible la realizaci\u00F3n apropiada del juego, puede, en el juego por hoyos o en el juego por golpes, ordenar una suspensi\u00F3n temporal del juego o, en el juego por golpes, declarar nulo y no valido el juego y cancelar todos los resultados de la vuelta en cuesti\u00F3n. Cuando se cancela una vuelta, todas las penalidades incurridas en esa vuelta se cancelan.");//GEN-LINE:|168-getter|1|168-postInit
            // write post-init user code here
        }//GEN-BEGIN:|168-getter|2|
        return stringItem48;
    }
    //</editor-fold>//GEN-END:|168-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem49 ">//GEN-BEGIN:|169-getter|0|169-preInit
    /**
     * Returns an initiliazed instance of stringItem49 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem49() {
        if (stringItem49 == null) {//GEN-END:|169-getter|0|169-preInit
            // write pre-init user code here
            stringItem49 = new StringItem("e.Horario de Salida y Grupos", "El Comit\u00E9 debe establecer las horas de salida y, en el juego por golpes, organizar los grupos en los que deben jugar los competidores. Cuando una competici\u00F3n por hoyos se juega en un per\u00EDodo prolongado, el Comit\u00E9 establecer\u00E1 el l\u00EDmite de tiempo dentro del cual debe completarse cada vuelta. Cuando los jugadores est\u00E1n autorizados para fijar la fecha de su partido dentro de esos l\u00EDmites, el Comit\u00E9 deber\u00EDa anunciar que el partido debe jugarse a una hora determinada del \u00FAltimo d\u00EDa del per\u00EDodo, salvo que los jugadores acuerden hacerlo en una fecha anterior");//GEN-LINE:|169-getter|1|169-postInit
            // write post-init user code here
        }//GEN-BEGIN:|169-getter|2|
        return stringItem49;
    }
    //</editor-fold>//GEN-END:|169-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem50 ">//GEN-BEGIN:|170-getter|0|170-preInit
    /**
     * Returns an initiliazed instance of stringItem50 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem50() {
        if (stringItem50 == null) {//GEN-END:|170-getter|0|170-preInit
            // write pre-init user code here
            stringItem50 = new StringItem("f.Tarjeta de Resultados", "En el juego por golpes, el Comit\u00E9 debe proporcionar a cada competidor una tarjeta de resultados que contenga la fecha y el nombre del competidor o, en foursome o cuatro bolas (four ball) en el juego por golpes, los nombres de los competidores. En el juego por golpes, el Comit\u00E9 es responsable de la suma de los resultados y de la aplicaci\u00F3n del handicap que figura en la tarjeta. En cuatro bolas (four ball) en el juego por golpes, el Comit\u00E9 es el responsable de anotar el resultado de la mejor bola en cada hoyo y en el proceso aplicar los handicaps anotados en la tarjeta, y sumar los resultados de la mejor bola. En competiciones Contra Bogey, Contra Par y Stableford, el Comit\u00E9 es el responsable de aplicar el handicap anotado en la tarjeta y determinar el resultado en cada hoyo as\u00ED como el resultado global o puntos totales.");//GEN-LINE:|170-getter|1|170-postInit
            // write post-init user code here
        }//GEN-BEGIN:|170-getter|2|
        return stringItem50;
    }
    //</editor-fold>//GEN-END:|170-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return GolfController.getInstance().getDisplay();
        //return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
