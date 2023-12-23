class Ejercicio1 {

  
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
  
  public double getY(){
    return y;
  }

  public double distancia(Punto p) {
    return Math.pow((p.getX() - x),2) + Math.pow(Math.pow((p.getY() - y),2),1/2);
  }
}

class Circulo extends Punto{
  private double centro;
  private double radio;
}