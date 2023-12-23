public class Ejercicio2 {
  public static void main(String[] args) {
    Cilindro cilindro = new Cilindro();

    cilindro.setCentro(3.0);
    cilindro.setRadio(2.5);
    cilindro.setLongitud(4.0);

    double superficieCilindro = cilindro.superficie();
    System.out.println("La superficie del cilindro es: " + superficieCilindro);
  }
}
class Cilindro extends Circulo{
  private double longitud;

  public void setLongitud(double longitud) {
    this.longitud = longitud;
  }

  public double getLongitud() {
    return longitud;
  }

  public double superficie() {
    return 2 * radio * (longitud + radio);
  }
}