/*
 */
package com.cesine.ipm.contactosgmail;

import javax.microedition.lcdui.*;

/**
 *
 * Este form es utilizado por la aplicacion allí donde se precise una ficha
 * con los detalles de un contacto
 *
 * @author julioa
 */
public class LoginForm extends Form implements CommandListener {


    // Comandos para todos los modos
    Command exit = new Command("Salir", Command.EXIT, 1);
    Command accept = new Command("Aceptar", Command.OK, 3);


    private TextField nombre = null;
    private TextField clave = null;
    private ContactosMidlet midlet = null;

    private String user = null;
    private String password = null;
    /**
     *
     * Crea el formulario a partir del contacto con indice index de la 
     * lista de contacto en el modo de edicion determinado por mode
     *
     * @param midlet
     * @param index
     * @param mode
     */
    public LoginForm(ContactosMidlet midlet) {
        super("Login");

        this.midlet = midlet;

            this.addCommand(exit);
          this.addCommand(accept);

        nombre = new TextField("Usuario", null, 128, TextField.ANY );
        this.append(nombre);
        clave = new TextField("Clave", null, 128, TextField.ANY );
        this.append(clave);

        this.setCommandListener(this);
    }

 

    /**
     *
     * Procesamiento de comandos
     *
     * @param c
     * @param d
     */
    public void commandAction(Command c, Displayable d) {
        // En funcion del modo procesamos el comando y volvemos a
        // refrescar el formulario.
        if (c == exit) {
            midlet.salir();
        } else if (c == accept) {
            setUser(nombre.getString());
            setPassword(clave.getString());
        } 
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }



}
