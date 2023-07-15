package com.grupo.proyecto_AyD.red;

import com.grupo.proyecto_AyD.modelo.Mensaje;

import java.util.List;

public interface InterfazConectorChat {
    List<Mensaje> enviarMensaje(String contenido);
    void setClaveEncripcion(String clave);
    String getClaveEncripcion();
}
