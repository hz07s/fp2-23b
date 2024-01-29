/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Interfaz util para guardar los datos de los objetos hijos de Weapons en bytes
import java.io.Serializable;

//Clase abstracta que hereda de Serializable
public abstract class Weapons implements Serializable{
  private int size;
  private int num;

  //Controlar el tamaño
  public void setSize(int size) {
    this.size = size;
  }
  public int getSize() {
    return size;
  }
  //Controlar la cantidad
  public void setNum(int num) {
    this.num = num;
  }
  public int getNum() {
    return num;
  }

  //Metodos para incrementar los atributos
  public abstract void increaseSize();
  public abstract void increaseNum();
}
