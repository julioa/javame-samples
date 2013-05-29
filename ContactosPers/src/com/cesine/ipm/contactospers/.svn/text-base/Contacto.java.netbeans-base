/*
 */
package com.cesine.ipm.contactospers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * Clase encargada de contener los datos individuales de cada contacto.
 *
 * @author julioa
 */
public class Contacto {

    private int id = -1; // Id en el recordstore
    private String nombre = null;
    private String apellido = null;
    private String email = null;
    private String movil = null;

    /**
     * Constructor sin argumentos
     */
    public Contacto() {
    }

    /**
     *
     * Constructor usando cada uno de los campos
     *
     * @param nombre
     * @param apellido
     * @param email
     * @param movil
     */
    public Contacto(String nombre, String apellido, String email, String movil) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setMovil(movil);
    }

    /**
     *
     * Constructor usando un array de bytes (para crear el contacto a partir
     * de un record)
     *
     * @param bytes
     */
    public Contacto(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream inputStream = new DataInputStream(bais);
        try {
            String aux = null;

            aux = inputStream.readUTF();
            setNombre(aux);

            aux = inputStream.readUTF();
            setApellido(aux);

            aux = inputStream.readUTF();
            setEmail(aux);

            aux = inputStream.readUTF();
            setMovil(aux);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return movil
     */
    public String getMovil() {
        return movil;
    }

    /**
     *
     * @param movil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * Devuelve un array de bytes para ser guardado en un record.
     *
     * @return bytes
     */
    public byte[] getBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(baos);
        try {
            outputStream.writeUTF(getNombre());
            outputStream.writeUTF(getApellido());
            outputStream.writeUTF(getEmail());
            outputStream.writeUTF(getMovil());
        } catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }

        // Extract the byte array
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}
