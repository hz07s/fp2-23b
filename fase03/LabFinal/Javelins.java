/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Weapons ya que es un arma
public class Javelins extends Weapons{
    public static final int NUM_MAX = 6;
    public static final int SIZE_MAX = 250;

    public Javelins() {
        setNum(3);
        setSize(175);
    }

    //Incrementa el numero de unidades
    public void increaseNum(){
        setNum(getNum() + 1);
    }

    //Incrementa el numero de tamanio
    public void increaseSize(){
        setSize(getSize() + 25);
    }
}
