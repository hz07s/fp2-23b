public class Ejercicio3 {
  public static void main(String[] args) {
    // Crear una instancia de Hidroavion
    Hidroavion hidroavion = new Hidroavion();

    // Configurar el modelo y la velocidad del hidroavión
    hidroavion.setModelo("Hidro-3000");
    hidroavion.setVelocidad(3000);

    // Invocar métodos relacionados con la navegación y vuelo
    hidroavion.navegar();
    hidroavion.detenerse();
    hidroavion.sonarSirena();
    hidroavion.volar();
    hidroavion.aterrizar();
    hidroavion.hacerAnuncio();
    hidroavion.mostrarInformacion();

    // Invocar métodos específicos de la interfaz Barco
    hidroavion.gestionarTripulacion();
    hidroavion.tirarAncla();
    hidroavion.comunicarTorreControlMaritima();

    // Invocar métodos específicos de la interfaz Avion
    hidroavion.gestionarPasajeros();
    hidroavion.desplegarTrenAterrizaje();
    hidroavion.comunicarTorreControlAerea();
  }
}
// Definir la interfaz Barco con métodos relacionados con la navegación marítima
interface Barco {
  void navegar();
  void detenerse();
  void sonarSirena();
  void gestionarTripulacion();
  void tirarAncla();
  void comunicarTorreControlMaritima();
}
// Definir la interfaz Avion con métodos relacionados con la aviación
interface Avion {
  void volar();
  void aterrizar();
  void hacerAnuncio();
  void gestionarPasajeros();
  void desplegarTrenAterrizaje();
  void comunicarTorreControlAerea();
}
// Definir la clase Hidroavion que implementa ambas interfaces
class Hidroavion implements Barco, Avion {
  private String modelo;
  private int velocidad;
  private int pasajeros;
  private String ubicacion;
  private boolean estado;
  // Métodos getter y setter para los atributos de la clase
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getModelo() {
    return modelo;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setPasajeros(int pasajeros) {
    this.pasajeros = pasajeros;
  }

  public int getPasajeros() {
    return pasajeros;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getUbicacion() {
    return ubicacion;
  }
  //Métodos de la interfaces barco y avion
  @Override
  public void navegar() {
    System.out.println("El hidroavión está navegando en " + ubicacion);
  }

  @Override
  public void detenerse() {
    System.out.println("El hidroavión está " + (estado ? "en movimiento":"detenido"));
  }

  @Override
  public void sonarSirena() {
    System.out.println("El hidroavión está sonando la sirena.");
  }

  @Override
  public void volar() {
    System.out.println("El hidroavión está volando en el aire.");
  }

  @Override
  public void aterrizar() {
    System.out.println("El hidroavión está aterrizando.");
  }

  @Override
  public void hacerAnuncio() {
    System.out.println("Anuncio desde el hidroavión a los "+ pasajeros +" pasajeros: Bienvenidos a bordo.");
  }

  public void mostrarInformacion() {
    System.out.println("Modelo: " + getModelo() + ", Velocidad: " + getVelocidad());
  }

  @Override
  public void gestionarTripulacion() {
    System.out.println("Gestionando la tripulación del hidroavión.");
  }

  @Override
  public void tirarAncla() {
    System.out.println("Tirando el ancla del hidroavión.");
  }

  @Override
  public void comunicarTorreControlMaritima() {
    System.out.println("Comunicándose con la torre de control marítima.");
  }

  @Override
  public void gestionarPasajeros() {
    System.out.println("Gestionando a los pasajeros del hidroavión.");
  }

  @Override
  public void desplegarTrenAterrizaje() {
    System.out.println("Desplegando el tren de aterrizaje del hidroavión.");
  }

  @Override
  public void comunicarTorreControlAerea() {
    System.out.println("Comunicándose con la torre de control aérea.");
  }
}