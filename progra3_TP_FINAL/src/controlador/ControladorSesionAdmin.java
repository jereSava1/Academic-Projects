package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Agencia;
import negocio.RondaDeContrataciones;
import negocio.RondaDeEncuentro;
import vista.IVistaSesionAdmin;
import vista.VistaSesionAdmin;

public class ControladorSesionAdmin implements ActionListener {

	private IVistaSesionAdmin vista;
	private static ControladorSesionAdmin controladorSesionAdmin=null;
	private Agencia agencia;
	
	private ControladorSesionAdmin() {
		this.vista = new VistaSesionAdmin();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorSesionAdmin get(){
		if(controladorSesionAdmin==null)
			controladorSesionAdmin = new ControladorSesionAdmin();
		controladorSesionAdmin.vista.mostrar();
		return controladorSesionAdmin;
	}
	
	public void setVista(IVistaSesionAdmin vista) {
		this.vista=vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("Ver Empleadores")){
			this.vista.esconder();
			ControladorMuestraEmpleadoresAdmin controladorMuestraEmpleadoresAdmin = ControladorMuestraEmpleadoresAdmin.getControladorMuestraEmpleadoresAdmin();
		}else if(comando.equalsIgnoreCase("Ver Empleados")){
			this.vista.esconder();
			ControladorMuestraEmpleadosAdmin controladorMuestraEmpleadosAdmin = ControladorMuestraEmpleadosAdmin.getControladorMuestraEmpleadosAdmin();
			
		}else if(comando.equalsIgnoreCase("Ver Comisones")) {
			this.vista.esconder();
			ControladorComisionesAdmin controladorComisionesAdmin = ControladorComisionesAdmin.getControladorComisionesAdmin();
			
		}else if(comando.equalsIgnoreCase("Activar Encuentros")) {
			
			if( RondaDeEncuentro.isActivada() == false ) {
				RondaDeEncuentro.ejecutarRondaDeEncuentros(Agencia.getAgencia());
				this.vista.success("Ronda de encuentros activada con exito", "Ronda de encuentros");
			}else
				this.vista.error("Todavia no se efectuaron las contrataciones", "Ronda de encuentros");
			
		}else if(comando.equalsIgnoreCase("Activar Contrataciones")) {
			
			if( !RondaDeContrataciones.isActivada() ) {
				RondaDeContrataciones.ejecutarRondaDeContrataciones(Agencia.getAgencia());
				this.vista.success("Ronda de contrataciones activada con exito", "Ronda de contrataciones");
			}else
				this.vista.error("Todavia no se efectuo la Ronda de encuentros", "Ronda de contrataciones");			
			
		}else if(comando.equalsIgnoreCase("Actualiza Sueldos")){
			float min=controladorSesionAdmin.vista.getMinimo();
			float max=controladorSesionAdmin.vista.getMaximo();
			if(min!=-1 && max!=-1) {
			  agencia.setRemuneracionV1(min);
			  agencia.setRemuneracionV2(max);
			  this.vista.limpiaCampos();
			  this.vista.success("Sueldos actualizados con exito", "Actualizacion de sueldos");
			}
			else {
				controladorSesionAdmin.vista.setMaximo(-1);
				controladorSesionAdmin.vista.setMinimo(-1);
				get();
			}
		}else if(comando.equalsIgnoreCase("Cerrar Sesion")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
		}
	}
	
	

}
