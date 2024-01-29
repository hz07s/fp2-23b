/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Soldier
public class Archer extends Soldier{
    private int arrows;

    //Metodos constructores
    public Archer(String n, int lL, int ack, int def, int t, int ta, int arr){
        super(n, lL, ack, def, t, ta);
        setArrows(arr);
        setImage("src/archer_");
    }
    public Archer(String n, int lL, int ack, int def, int t, char c, int r, int arr){
        super(n, lL, ack, def, t, c, r);
        setArrows(arr);
        setImage("src/archer_");
    }

    //Metodos mutadores
    public void setArrows(int arr){
        this.arrows = arr;
    }

    //Metodos accesores
    public int getArrows(){
        return this.arrows;
    }

    //Metodo de instancia
    public void shoot(){
        if (this.arrows > 0){
            this.arrows--;
        }
    }
    //Metodo para obtener los datos del arquero
    public String dataFile() {
        return super.dataFile()+"\t Numero de flechas: "+this.arrows;
    }
    
    //Metodo toString
    public String toString(){
        return super.toString()+"\n\nNumero de flechas: "+this.arrows;
    }
}
