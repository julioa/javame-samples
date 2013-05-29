/*
 */
package com.cesine.ipm.contactosgmail;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;

/**
 * Clase responsable de gestionar la lista de contactos.
 * Todos los accesos tanto de lectura como de escritura a los
 * contactos se realizarán a través de ella.
 *
 * @author julioa
 */
public class ContactFactory {

    // Se implementa como un singleton
    private static ContactFactory instance = null;
    private static final String STORE_NAME = "ContactPers"; // Nombre del recordStore
    private Vector lista = new Vector(); // Vector que guarda la lista de contactos
    // Array para facilitar la inserción inicial de datos
    private String[][] inicio = {{"Julio", "Arrebola", "julioa@computer.org", "600000000"}};

    private ContactFactory() {
        // En el constructor vemos si existe el recordstore y si no es asi lo creamos
        // y le añadimos algunos contactos de ejemplo.

        boolean rellena = false;

        if (rellena == true) {
            for (int i = 0; i < inicio.length; i++) {
                Contacto nuevo = new Contacto(inicio[i][0], inicio[i][1], inicio[i][2], inicio[i][3]);
                append(nuevo);
            }
        } 
    }

    /**
     *
     * Con este método y el atributo estático instance implementamos
     * el singleton
     *
     * @return instancia unica
     */
    public static ContactFactory getInstance() {
        if (instance == null) {
            instance = new ContactFactory();
        }

        return instance;
    }

    /**
     * Cierra la lista de contactos
     */
    public void close() {
        // En esta implementacion no es necesario hacer nada
    }

    /**
     *
     * @return lista de contactos
     */
    public Vector getList() {
        return lista;
    }

    /**
     *
     * Añada un contacto a la lista y lo guarda en persistencia
     *
     * @param contacto
     */
    public void append(Contacto contacto) {
        lista.addElement(contacto);
    }

    /**
     * Devulve el contacto con indice index de la lista
     * @param index
     * @return contacto en el indice index
     */
    public Contacto getItem(int index) {
        return (Contacto) lista.elementAt(index);
    }

    /**
     * Borra un contacto de la lista y de la persistencia
     * @param index
     */
    public void delete(int index) {

        lista.removeElementAt(index);
    }

    /**
     * Actualiza en la lista y persistencia en contacto indicado
     *
     * @param contacto
     * @param index
     */
    public void update(Contacto contacto, int index) {


        lista.setElementAt(contacto, index);
    }

    void init(ContactosMidlet midlet) {
        LoginForm login = new LoginForm(midlet);

        // Display.getDisplay(midlet).setCurrent(login);

        HttpConnection httpConn = null;
        String url = "https://www.google.com/accounts/ClientLogin";
        InputStream is = null;
        OutputStream os = null;

        try {
            // Open an HTTP Connection object
            httpConn = (HttpConnection) Connector.open(url);
            // Setup HTTP Request to POST
            httpConn.setRequestMethod(HttpConnection.POST);

            httpConn.setRequestProperty("User-Agent",
                    "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
            httpConn.setRequestProperty("Accept_Language", "en-US");
            //Content-Type is must to pass parameters in POST Request
            httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");



            os = httpConn.openOutputStream();

            String params;
            params = "accountType=HOSTED_OR_GOOGLE&";
            params += "Email=julio.arrebola@gmail.com&";
            params += "Passwd=XXXXXXXX&";
            params += "service=cp&";
            params += "source=exampleCo-exmapleApp-1";

            os.write(params.getBytes());

            /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/
            //os.flush();
            // Read Response from the Server
            StringBuffer sb = new StringBuffer();
            is = httpConn.openDataInputStream();
            int chr;
            while ((chr = is.read()) != -1) {
                sb.append((char) chr);
            }

            // This function retrieves the information of this connection
            getConnectionInformation(httpConn);

            String auxRespuesta = sb.toString();
            System.out.println("Output " + auxRespuesta);

            int code = httpConn.getResponseCode();

            System.out.println("Response code : " + code);

            String tokenAux = httpConn.getHeaderField("Authorization");

            System.out.println("Authorization:" + tokenAux);

            if (code == 200) {

                int pos = auxRespuesta.indexOf("Auth=");

                String authToken = auxRespuesta.substring(pos + 5);

                System.out.println("AuthToken=##" + authToken.trim() + "##");


                // Ahora recuperamos los contactos
                HttpConnection httpConn2 = null;
                String url2 = "http://www.google.com/m8/feeds/contacts/julio.arrebola%40gmail.com/full";
                InputStream is2 = null;
                OutputStream os2 = null;

                try {
                    // Open an HTTP Connection object
                    httpConn2 = (HttpConnection) Connector.open(url2);
                    // Setup HTTP Request to POST
                    httpConn2.setRequestMethod(HttpConnection.GET);
                    httpConn2.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);

                    StringBuffer sb2 = new StringBuffer();

                    is2 = httpConn2.openDataInputStream();
                    int chr2;
                    while ((chr2 = is2.read()) != -1) {
                        sb2.append((char) chr2);
                    }

                    System.out.println("Salida2 :"+sb2.toString());

                    String fullContacts = (sb2.toString());

                     System.out.println("Salida2 :"+fullContacts);


                    int initPos = 0;
                    int pos2 = 0;
                    while ((pos2 = fullContacts.indexOf("<title", initPos)) != -1) {
                     int auxPos = fullContacts.indexOf(">", pos2) +1 ;
                     int finPos = fullContacts.indexOf("</",auxPos);
                     String name = fullContacts.substring(auxPos, finPos);
                     initPos = finPos;

                     Contacto nuevo = new Contacto();
                     nuevo.setNombre(name);

                     this.append(nuevo);

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    if (is2 != null) {
                        try {
                            is2.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (os2 != null) {
                        try {
                            os2.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (httpConn2 != null) {
                        try {
                            httpConn2.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }


            } else {
                System.out.println("No ha habido exito");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (httpConn != null) {
                try {
                    httpConn.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    void getConnectionInformation(HttpConnection hc) {

        System.out.println("Request Method for this connection is " + hc.getRequestMethod());
        System.out.println("URL in this connection is " + hc.getURL());
        System.out.println("Protocol for this connection is " + hc.getProtocol()); // It better be HTTP:)
        System.out.println("This object is connected to " + hc.getHost() + " host");
        System.out.println("HTTP Port in use is " + hc.getPort());
        System.out.println("Query parameter in this request are  " + hc.getQuery());
        System.out.println("HEADERS");
        String aux;
        int i = 0;
        try {
            while ((aux = hc.getHeaderField(i++)) != null) {
                System.out.println(hc.getHeaderFieldKey(i) + "=" + hc.getHeaderField(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

