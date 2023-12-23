public class Ejercicio2 {
  
}
class Cilindro extends Circulo{
  private double longitud;
  public double superficie() {
    return 2 * radio * (longitud + radio);
  }
}