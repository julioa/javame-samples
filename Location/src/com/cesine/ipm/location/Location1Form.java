package com.cesine.ipm.location;

import javax.microedition.lcdui.*;
import javax.microedition.location.*;
import javax.microedition.midlet.MIDlet;

/**
 * Ventana principal de la aplicación
 * @author Carlos García. Autentia.
 */
public class Location1Form extends Form implements CommandListener,  LocationListener {

    // Distancia total recorrida actualmente
    private double totalCurrentDistance;
    private MIDlet midlet;

    // Coordenadas de la última posición consultada
    private QualifiedCoordinates lastCoord;

    // Controles del interfaz gráfico
    private Command   cmdStartClick;
    private Command   cmdExitClick;

    private TextField txtEstadoProveedor;
    private TextField txtLongitud;
    private TextField txtLatitud;
    private TextField txtDistanciaRecorrida;
    private TextField txtVelocidad;
    private TextField txtCalle;


    public Location1Form(MIDlet    midlet){
        super("Location API Ejemplo");

        this.totalCurrentDistance = 0;
        this.midlet               = midlet;

        this.createUI();
    }

    /**
     *  Contruimos y configuramos el interfaz gráfico
     */
    private void createUI(){
        this.cmdStartClick = new Command("Empezar", Command.OK,   1);
        this.cmdExitClick  = new Command("Salir",   Command.EXIT, 1);

        this.txtCalle      = new TextField("Calle:",           null, 50,  TextField.ANY);
        this.txtEstadoProveedor     = new TextField("Proveedor:",       null, 50,  TextField.ANY);
        this.txtDistanciaRecorrida  = new TextField("Metros recorridos:", null, 50,   TextField.ANY);
        this.txtVelocidad  = new TextField("Velocidad:", null, 20,   TextField.ANY);
        this.txtLongitud   = new TextField("Longitud:",        null, 50,   TextField.ANY);
        this.txtLatitud    = new TextField("Latitud:",         null, 50,   TextField.ANY);

        this.append(txtEstadoProveedor);
        this.append(txtDistanciaRecorrida);
        this.append(txtVelocidad);
        this.append(txtCalle);
        this.append(txtLongitud);
        this.append(txtLatitud);

        this.addCommand(cmdStartClick);
        this.addCommand(cmdExitClick);
        this.setCommandListener(this);
    }

    /**
     * Configuramos e iniciamos el proveedor de localización
     */
    private void cmdStartClick_click() throws LocationException   {
        // Establecemos los criterios del proveedor de localizacion deseado.
        Criteria criteria = new Criteria();

        // No queremos usar un proveedor de pago
        criteria.setCostAllowed(false);

        // Nos gustaría que el proveedor además de longitud y latitud nos diera
        // información sobre la calle, país, ciudad, etc. en la que me encuentro.
        criteria.setAddressInfoRequired(true);

        // Quiero datos de velocidad
        criteria.setSpeedAndCourseRequired(true);

        // Solicitamos el proveedor de localización
        LocationProvider provider = LocationProvider.getInstance(criteria);

        // ¿La implementación nos ha proporcionado un proveedor con esas características?
        if (provider  == null){
            // Lo intentamos de nuevo sin requerir datos textuales de localización
            criteria.setAddressInfoRequired(false);

            // Solicitamos el proveedor de localización
            provider = LocationProvider.getInstance(criteria);
        }

        // si tenemos proveedor inicializamos
        if (provider  != null){
            try {
                // Método bloqueante
                Location location = provider.getLocation(-1);

                // Si hay datos de localización continuamos ponemos un timer
                // que nos de los datos de localizacion cada 5 segundos (llamará
                // al método locationUpdated)
                if (location != null){
                    this.lastCoord    = location.getQualifiedCoordinates();

                    // LocationListener, interval, timeout, maxAge)
                    provider.setLocationListener(this, 5, -1, -1);
                }

                // Inicializamos el UI con los datos del estado del proveedor.
                this.providerStateChanged(provider, provider.getState());
            } catch (java.lang.InterruptedException ex){
                this.append(ex.getMessage());
            }
        }
    }

    /**
     * Finalizamos la aplicación
     */
    private void cmdExitClick(){
        this.midlet.notifyDestroyed();
    }

    /**
     * javax.microedition.lcdui.CommandListener
     */
    public void commandAction(Command c, Displayable d) {
        try {
            if (c == this.cmdStartClick){
                this.cmdStartClick_click();
            } else if (c == this.cmdExitClick){
                this.cmdExitClick();
            }
        } catch (Exception ex){
            this.append(ex.getMessage());
        }
    }

    /**
     * javax.microedition.location.LocationListener
     * Recalculamos la posición (Este método se llama cada X segundos)
     */
    public void locationUpdated(LocationProvider provider, Location location)  {
        try {
            QualifiedCoordinates coord     = location.getQualifiedCoordinates();
            AddressInfo          addr      = null;

            if (coord != null){
                this.txtLongitud.setString(String.valueOf(coord.getLongitude()));
                this.txtLatitud.setString(String.valueOf(coord.getLatitude()));

                addr = location.getAddressInfo();
            }

            if (addr != null){
                this.txtCalle.setString(addr.getField(AddressInfo.STREET));
            } else {
                this.txtCalle.setString("INFO NO DISPONIBLE");
            }

            // Hacemos el valor absoluto por que podemos ir para adelante y para detrás.
            totalCurrentDistance += Math.abs(coord.distance(lastCoord));

            // Actualizamos el interfaz gráfico
            this.txtDistanciaRecorrida.setString(String.valueOf(totalCurrentDistance));

            this.txtVelocidad.setString(String.valueOf(location.getSpeed()));
            this.lastCoord = coord;
        } catch (Exception ex){
            this.append(ex.getMessage());
            // Nada
        }
    }

    /**
     * javax.microedition.location.LocationListener
     * El estado del proveedor ha sido actualizado
     */
    public void providerStateChanged(LocationProvider provider, int newState) {
        String stateDesc = null;

        if (newState == LocationProvider.AVAILABLE){
            stateDesc = "DISPONIBLE";
        } else if (newState == LocationProvider.OUT_OF_SERVICE){
            stateDesc = "FUERA DE SERVICIO";
        } else if (newState == LocationProvider.TEMPORARILY_UNAVAILABLE){
            stateDesc = "TEMPORALMENTE FUERA DE SERVICIO";
        } else {
            stateDesc = "DESCONOCIDO";
        }

        this.txtEstadoProveedor.setString(stateDesc);
    }
}
    