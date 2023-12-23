public class Ejercicio2 {
  public static void main(String[] args) {
    // Crear una instancia de Cilindro
    Cilindro cilindro = new Cilindro();
    // Crear un punto para establecer el centro del cilindro
    Punto centro = new Punto();
    centro.setX(3.0);
    centro.setY(0.0);
    // Configurar el cilindro con el centro, radio y longitud
    cilindro.setCentro(centro);
    cilindro.setRadio(2.5);
    cilindro.setLongitud(4.0);
    // Calcular y mostrar la superficie del cilindro
    double superficieCilindro = cilindro.superficie();
    System.out.println("La superficie del cilindro es: " + superficieCilindro);
  }
}
// Clase Cilindro que hereda de Circulo
class Cilindro extends Circulo{
  protected double longitud;
  // Métodos getter y setter para la longitud
  public void setLongitud(double longitud) {
    this.longitud = longitud;
  }

  public double getLongitud() {
    return longitud;
  }
  // Método para calcular la superficie del cilindro
  public double superficie() {
    return 2 * radio * (longitud + radio);
  }
}
// Clase Circulo con atributos y métodos relacionados con un círculo
class Circulo {
  protected Punto centro;
  protected double radio;
  // Métodos getter y setter para el centro y radio
  public void setCentro(Punto centro) {
    this.centro = centro;
  }

  public Punto getCentro() {
    return centro;
  }

  public void setRadio(double radio) {
    this.radio = radio;
  }

  public double getRadio() {
    return radio;
  }
}
// Clase Punto con atributos y métodos relacionados con un punto en un plano
class Punto {
  protected double x;
  protected double y;
  // Métodos getter y setter para las coordenadas x e y
  public void setX(double x) {
    this.x = x;
  }

  public double getX(){
    return x;
  }
  
  public void setY(double y) {
    this.y = y;
  }

  public double getY(){
    return y;
  }
  // Método para calcular la distancia entre dos puntos
  public double distancia(Punto p) {
    return Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2));
  }
}