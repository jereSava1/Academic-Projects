package com.grupo.proyecto_AyD.controlador;

import com.grupo.proyecto_AyD.modelo.Usuario;
import com.grupo.proyecto_AyD.red.Conector;
import com.grupo.proyecto_AyD.red.InterfazConectorCliente;
import com.grupo.proyecto_AyD.vistas.InterfazConectar;
import com.grupo.proyecto_AyD.vistas.VistaConectar;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorConectar implements ActionListener {
    private static ControladorConectar controladorConectar = null;
    @Getter
    @Setter
    private InterfazConectorCliente conector;
    private InterfazConectar vistaConectar;
    private Usuario usuario;

    private ControladorConectar() {
        vistaConectar = new VistaConectar();
        vistaConectar.setActionListener(this);
        usuario = Usuario.getUsuario();
    }

    public static ControladorConectar getControlador() {
        if (controladorConectar == null) {
            controladorConectar = new ControladorConectar();
        }

        controladorConectar.setConector(Conector.getConector());

        controladorConectar.vistaConectar.mostrar();
        return controladorConectar;
    }

    public void esconder() {
        vistaConectar.esconder();
    }

    public void setEstado(String estado) {
        vistaConectar.setEstado(estado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "volver":
                ControladorMainMenu.getControlador();
                vistaConectar.esconder();
                break;
            case "conectar":
                conector.iniciarChat(vistaConectar.getIp(), Integer.parseInt(vistaConectar.getPuerto()));
                vistaConectar.setEstado("Intentando conectar...");
                break;
        }
    }
}
