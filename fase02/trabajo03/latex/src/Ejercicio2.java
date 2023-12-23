public class Ejercicio2 {
  public static void main(String[] args) {
    Cilindro cilindro = new Cilindro();
    Punto centro = new Punto();
    centro.setX(3.0);
    centro.setY(0.0);

    cilindro.setCentro(centro);
    cilindro.setRadio(2.5);
    cilindro.setLongitud(4.0);

    double superficieCilindro = cilindro.superficie();
    System.out.println("La superficie del cilindro es: " + superficieCilindro);
  }
}
class Cilindro extends Circulo{
  protected double longitud;

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