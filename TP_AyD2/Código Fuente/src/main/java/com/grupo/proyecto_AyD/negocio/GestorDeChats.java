package com.grupo.proyecto_AyD.negocio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.proyecto_AyD.controlador.ControladorChat;
import com.grupo.proyecto_AyD.controlador.ControladorConectarServidor;
import com.grupo.proyecto_AyD.controlador.ControladorLlamada;
import com.grupo.proyecto_AyD.controlador.ControladorMainMenu;
import com.grupo.proyecto_AyD.dtos.SolicitudLlamadaDTO;
import com.grupo.proyecto_AyD.dtos.UsuarioDTO;
import com.grupo.proyecto_AyD.modelo.Mensaje;
import com.grupo.proyecto_AyD.modelo.Sesion;
import com.grupo.proyecto_AyD.red.Conector;
import com.grupo.proyecto_AyD.red.InterfazConectorChat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class GestorDeChats implements InterfazGestorChats {
    private static GestorDeChats gestorDeChats = null;
    private final List<SolicitudLlamadaDTO> solicitudes = new ArrayList<>();
    private final ObjectMapper mapper;

    public static GestorDeChats getGestor() {
        if (gestorDeChats == null) {
            gestorDeChats = new GestorDeChats();
        }
        return gestorDeChats;
    }

    private GestorDeChats() {
        mapper = new ObjectMapper();
    }

    public void cerrarChat() {
        ControladorChat.getControlador().finalizarChat();
    }

    public void confirmarConexion() {
        ControladorConectarServidor.confirmarConexion();
    }
    public void actualizarListaConectados(String lista) {
        List<UsuarioDTO> conectados = new ArrayList<>();
        try {
           conectados = mapper.readValue(lista, new TypeReference<List<UsuarioDTO>>(){});
        } catch (Exception e) {
            System.out.println("[GESTOR DE CHATS] Error al actualizar la lista de conectados");
        }

        ControladorMainMenu.getControlador(false).setConectados(conectados);
    }

    public void enviarClaveDeEncriptacion(Mensaje mensaje) {
        InterfazConectorChat conector = Conector.getConector();
        conector.setClaveEncripcion(UUID.randomUUID().toString().replace("-","").substring(0, 8));
        conector.enviarMensaje("[CONTROL][CLAVE]" + conector.getClaveEncripcion());
        System.out.println("Clave encriptacion enviada: " + conector.getClaveEncripcion());

        ControladorMainMenu.getControlador().esconder();
        ControladorChat.getControlador(mensaje.getRemitente().getIp(), true);
    }

    public void manejarSolicitudLlamada(String solicitudCruda) {
        try {
            SolicitudLlamadaDTO solicitud = mapper.readValue(solicitudCruda, SolicitudLlamadaDTO.class);
            solicitudes.add(solicitud);

            ControladorLlamada.getControladorLlamada().setDatosSolicitud(solicitud);
        } catch (Exception e) {
            System.out.println("[GESTOR DE CHATS] Error al manejar la solicitud de llamada");
        }
    }

    public void manejarMensajeDeEstado(String estado) {
        ControladorMainMenu.getControlador().setEstado(estado);
    }

    public void mostrarNuevoMensaje(Mensaje mensaje) {
        Sesion sesion = Sesion.getSesion();
        sesion.getMensajes().add(mensaje);

        ControladorChat.getControlador()
                .getVistaChat()
                .setMensajes(
                        sesion
                                .getMensajes()
                                .stream()
                                .sorted(Comparator.comparing(Mensaje::getFecha))
                                .toList()
                );
    }

    public List<Mensaje> enviarMensaje(String mensaje) {
        InterfazConectorChat conector = Conector.getConector();
        return conector.enviarMensaje(mensaje);
    }
}
