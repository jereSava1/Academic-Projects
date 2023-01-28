package dto;

import java.io.Serializable;

public class PersistenciaContrataciones implements Serializable {
  private String nombreEmpleado;
  private String nombreEmpleador;
  private Float comisionEmpleado;
  private Float comisionEmpleador;
  private String idTicket;

  public PersistenciaContrataciones(){
  }

  public String getNombreEmpleado() {
    return nombreEmpleado;
  }

  public void setNombreEmpleado(String nombreEmpleado) {
    this.nombreEmpleado = nombreEmpleado;
  }

  public String getNombreEmpleador() {
    return nombreEmpleador;
  }

  public void setNombreEmpleador(String nombreEmpleador) {
    this.nombreEmpleador = nombreEmpleador;
  }

  public Float getComisionEmpleado() {
    return comisionEmpleado;
  }

  public void setComisionEmpleado(Float comisionEmpleado) {
    this.comisionEmpleado = comisionEmpleado;
  }

  public Float getComisionEmpleador() {
    return comisionEmpleador;
  }

  public void setComisionEmpleador(Float comisionEmpleador) {
    this.comisionEmpleador = comisionEmpleador;
  }

  public String getIdTicket() {
    return idTicket;
  }

  public void setIdTicket(String idTicket) {
    this.idTicket = idTicket;
  }
}
