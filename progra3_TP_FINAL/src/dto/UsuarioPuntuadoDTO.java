package dto;

import model.usuario.UsuarioPuntuado;

import java.util.Date;

public class UsuarioPuntuadoDTO {
  private Date fechaDeGeneracion;
  private String username;
  private Float puntaje;
  private boolean seleccionado;
  private boolean contratado;

  public boolean isContratado() {
    return contratado;
  }

  public void setContratado(boolean contratado) {
    this.contratado = contratado;
  }


  public static UsuarioPuntuadoDTO of(UsuarioPuntuado usuarioPuntuado) {
    UsuarioPuntuadoDTO dto = new UsuarioPuntuadoDTO();
    dto.setFechaDeGeneracion(usuarioPuntuado.getFechaDeGeneracion());
    dto.setUsername(usuarioPuntuado.getUsuario().getNombreUsuario());
    dto.setPuntaje(usuarioPuntuado.getPuntaje());
    dto.setSeleccionado(usuarioPuntuado.isSeleccionado());
    dto.setContratado(usuarioPuntuado.isContratado());
    return dto;
  }

  public Date getFechaDeGeneracion() {
    return fechaDeGeneracion;
  }

  public void setFechaDeGeneracion(Date fechaDeGeneracion) {
    this.fechaDeGeneracion = fechaDeGeneracion;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Float getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(Float puntaje) {
    this.puntaje = puntaje;
  }

  public boolean isSeleccionado() {
    return seleccionado;
  }

  public void setSeleccionado(boolean seleccionado) {
    this.seleccionado = seleccionado;
  }

  @Override
  public String toString() {
    return "| Usuario=" + username + " | Puntaje=" + puntaje +" | Seleccionado=" + seleccionado + " | Contratado=" + contratado + "|";
  }
}
