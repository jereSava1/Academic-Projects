package dto;

import model.usuario.Empleador;
import types.Rubro;
import types.TipoPersona;

public class EmpleadorDTO {
  private String nombre;
  private Rubro rubro;
  private TipoPersona tipoPersona;
  private int puntaje;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Rubro getRubro() {
    return rubro;
  }

  public void setRubro(Rubro rubro) {
    this.rubro = rubro;
  }

  public TipoPersona getTipoPersona() {
    return tipoPersona;
  }

  public void setTipoPersona(TipoPersona tipoPersona) {
    this.tipoPersona = tipoPersona;
  }

  public int getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(int puntaje) {
    this.puntaje = puntaje;
  }

  public static EmpleadorDTO of(Empleador empleador) {
    EmpleadorDTO dto = new EmpleadorDTO();
    dto.nombre = empleador.getNombre();
    dto.rubro = empleador.getRubro();
    dto.tipoPersona = empleador.getTipoPersona();
    dto.puntaje = empleador.getPuntaje();
    return dto;
  }
}
