import java.util.ArrayList;

import controlador.ControladorLogin;
import controlador.ControladorRegistro;
import controlador.ControladorRegistroAdmin;
import dto.RegistroRequestAdmin;
import factory.CargaHorariaFactory;
import factory.EstudiosFactory;
import factory.ExperienciaFactory;
import factory.LocacionFactory;
import factory.PretensionSalarialFactory;
import factory.RangoEtarioFactory;
import factory.TipoDePuestoFactory;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.*;
import model.usuario.Administrador;
import model.usuario.Empleado;
import model.usuario.Empleador;
import negocio.RondaDeEncuentro;

public class main {

	public static void main(String[] args) {

		Agencia agencia = Agencia.getAgencia();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		Agencia.getAgencia().setRemuneracionV1(1500F);
		Agencia.getAgencia().setRemuneracionV2(3000F);
	
		ControladorLogin controlador = ControladorLogin.getControladorLogin(true);
	
	}

}
