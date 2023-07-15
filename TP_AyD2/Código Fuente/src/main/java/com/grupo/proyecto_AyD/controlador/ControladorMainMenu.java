package com.grupo.proyecto_AyD.controlador;

import com.grupo.proyecto_AyD.dtos.UsuarioDTO;
import com.grupo.proyecto_AyD.modelo.Usuario;
import com.grupo.proyecto_AyD.red.Conector;
import com.grupo.proyecto_AyD.red.InterfazConectorChat;
import com.grupo.proyecto_AyD.red.InterfazConectorCliente;
import com.grupo.proyecto_AyD.tipos.EstadoUsuario;
import com.grupo.proyecto_AyD.vistas.InterfazMenu;
import com.grupo.proyecto_AyD.vistas.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ControladorMainMenu implements ActionListener {
    private static ControladorMainMenu controladorMainMenu = null;
    private InterfazMenu vistaMenu;
    private Usuario usuario;
    private InterfazConectorCliente conectorCliente;
    private InterfazConectorChat conectorChat;


    private ControladorMainMenu() {
        vistaMenu = new MainMenu();
        vistaMenu.setActionListener(this);
        conectorCliente = Conector.getConector();
        conectorChat = Conector.getConector();
        usuario = Usuario.getUsuario();

        vistaMenu.setIp(usuario.getIp());
        vistaMenu.setPuerto(Integer.toString(usuario.getPuerto()));
        vistaMenu.setNombre(usuario.getNombre());
    }

    public static ControladorMainMenu getControlador(boolean mostrar) {
        if (controladorMainMenu == null) {
            controladorMainMenu = new ControladorMainMenu();
        }

        if (mostrar) {
            controladorMainMenu.vistaMenu.mostrar();
        }
        return controladorMainMenu;
    }

    public static ControladorMainMenu getControlador() {
        return getControlador(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "iniciarEscucha":
                manejarEscucha();
                break;
            case "configurar":
                ControladorConfiguracion.getControlador();
                vistaMenu.esconder();
                break;
            case "iniciarConversacion":
                manejarConversacion();
                break;
            case "salir":
                Conector.getConector().enviarMensaje("[CONTROL][DESCONEXION_CLIENTE]");
                System.exit(0);
                break;
        }

    }

    public void esconder() {
        vistaMenu.esconder();
    }

    public void setEstado(String estado) {
        vistaMenu.setEstado(estado);
    }

    public void setConectados(List<UsuarioDTO> usuarios) {
        vistaMenu.setConectados(usuarios);
    }

    private void manejarEscucha() {
        if (usuario.getEstado().equals(EstadoUsuario.INACTIVO)) {
            usuario.setEstado(EstadoUsuario.ESCUCHANDO);

            conectorChat.enviarMensaje("[CONTROL][ESCUCHANDO][INICIAR]");
            vistaMenu.setEstado("Escuchando");
            vistaMenu.cambiarBotonEscucha(true);
        } else {
            usuario.setEstado(EstadoUsuario.INACTIVO);

            conectorChat.enviarMensaje("[CONTROL][ESCUCHANDO][TERMINAR]");
            vistaMenu.setEstado("Escucha terminada, inactivo");
            vistaMenu.cambiarBotonEscucha(false);
        }
    }

    private void manejarConversacion() {
        UsuarioDTO usuarioDTO = vistaMenu.getUsuarioSeleccionado();

        if (usuarioDTO != null) {
            if (Objects.equals(usuarioDTO.getIp(), usuario.getIp()) && usuarioDTO.getPuerto() == usuario.getPuerto()) {
                vistaMenu.mostrarMensaje("No puede iniciar una conversación consigo mismo");
                return;
            }
            if (usuarioDTO.getEstado().equals(EstadoUsuario.ESCUCHANDO)) {
                conectorCliente.iniciarChat(usuarioDTO.getIp(), usuarioDTO.getPuerto());
                vistaMenu.setEstado("Intentando conectar...");
            } else {
                vistaMenu.mostrarMensaje("El usuario seleccionado no está escuchando");
            }
        } else {
            vistaMenu.mostrarMensaje("Seleccione un compañero para iniciar la conversación");
        }
    }
}
