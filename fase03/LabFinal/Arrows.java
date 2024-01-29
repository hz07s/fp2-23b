/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de Weapons ya que es una arma
public class Arrows extends Weapons{
    public static final int NUM_MAX = 60;
    public static final int SIZE_MAX = 90;

    public Arrows() {
        setNum(20);
        setSize(60);
    }
    
    //Incremente el numero de unidades
    public void increaseNum(){
        setNum(getNum() + 10);
    }

    //Incrementa el numero del tamanio
    public void increaseSize(){
        setSize(getSize() + 10);
    }
}
