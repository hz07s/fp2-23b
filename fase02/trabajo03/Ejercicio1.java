class Ejercicio1 {
  public static void main(String[] args){
    Punto p1 = new Punto();
    Punto p2 = new Punto();
    
    p1.setX(1.0);
    p1.setY(4.5);

    p2.setX(2.0);
    p2.setY(6.0);

    double distancia = p1.distancia(p2);
    System.out.println("La distancia entre el punto 1 y el punto 2 es: " + distancia);    
  }
}

class Punto {
  private double x;
  private double y;
  
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

  public double distancia(Punto p) {
    return Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2));
  }
}

class Circulo {
  private double centro;
  private double radio;
}