package state;

import types.EstadoTicket;

public interface IState {

    //Acciones que puede realizar el usuario sobre el ticket
    void activar();
    void suspender();
    void cancelar();
    EstadoTicket getNombre();

}
