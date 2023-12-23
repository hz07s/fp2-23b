class Ejercicio1 {
  public static void main(String[] args){
    // Crear instancias de puntos p1 y p2
    Punto p1 = new Punto();
    Punto p2 = new Punto();
    // Establecer las coordenadas para p1
    p1.setX(1.0);
    p1.setY(4.5);
    // Establecer las coordenadas para p2
    p2.setX(2.0);
    p2.setY(6.0);
    // Calcular y mostrar la distancia entre los puntos p1 y p2
    double distancia = p1.distancia(p2);
    System.out.println("La distancia entre el punto 1 y el punto 2 es: " + distancia);    
  }
}
// Clase que representa un punto en el plano
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
// Clase que representa un círculo con centro y radio
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