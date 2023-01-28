package dto;

import model.usuario.Empleado;

import java.io.StringReader;

public class EmpleadoDTO {
  private String nombre;
  private String email;
  private String telefono;
  private int puntaje;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String empleado) {
    this.telefono = empleado;
  }

  public int getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(int puntaje) {
    this.puntaje = puntaje;
  }

  public static EmpleadoDTO of(Empleado empleado) {
    EmpleadoDTO dto = new EmpleadoDTO();
    dto.nombre = empleado.getNombre();
    dto.email = empleado.getEmail();
    dto.telefono = empleado.getTelefono();
    dto.puntaje = empleado.getPuntaje();
    return dto;
  }
}
