public class Lanzas {
  private byte tamaño;
  private byte cantidad;

  public Lanzas() {
    tamaño = 1;
    cantidad = 1;
  }

  public void setTamaño(byte tamaño) {
    this.tamaño = tamaño;
  }

  public byte getTamaño() {
    return tamaño;
  }
  
  public void setCantidad(byte cantidad) {
    this.cantidad = cantidad;
  }

  public byte getCantidad() {
    return cantidad;
  }
}
