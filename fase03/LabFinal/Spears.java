/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de Weapons ya que es un arma
public class Spears extends Weapons{
    public static final int NUM_MAX = 9;
    public static final int SIZE_MAX = 400;

    public Spears() {
        setNum(3);
        setSize(250);
    }

    //Incrementa el numero de unidades
    public void increaseNum(){
        setNum(getNum() + 3);
    }

    //Incrementa el numero de tamanio
    public void increaseSize(){
        setSize(getSize() + 50);
    }
}
