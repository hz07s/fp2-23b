/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de Weapons ya que es un arma
public class Knives extends Weapons{
    public static final int NUM_MAX = 6;
    public static final int SIZE_MAX = 20;

    public Knives() {
        setNum(3);
        setSize(5);
    }

    //Incrementa el numero de unidades
    public void increaseNum(){
        setNum(getNum() + 3);
    }

    //Incrementa el numero de tamanio
    public void increaseSize(){
        setSize(getSize() + 5);
    }
}
