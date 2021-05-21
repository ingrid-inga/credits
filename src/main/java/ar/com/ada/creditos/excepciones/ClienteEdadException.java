package ar.com.ada.creditos.excepciones;

import ar.com.ada.creditos.entities.Cliente;

/**
 * ClienteEdadException
 */
public class ClienteEdadException extends ClienteInfoException {

    public ClienteEdadException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
    }

}