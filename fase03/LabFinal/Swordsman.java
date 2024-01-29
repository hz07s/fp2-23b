/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Soldier
public class Swordsman extends Soldier{
    private int swordLength;

    //Metodo constructores
    public Swordsman(String n, int lL, int ack, int def, int t, int ta, int sl){
        super(n, lL, ack, def, t, ta);
        setSwordLength(sl);
        setImage("src/swordsman_");
    }
    public Swordsman(String n, int lL, int ack, int def, int t, char c, int r, int sl){
        super(n, lL, ack, def, t, c, r);
        setSwordLength(sl);
        setImage("src/swordsman_");
    }

    //Metodos mutadores
    public void setSwordLength(int sl){
        this.swordLength = sl;
    }

    //Metodos accesores
    public int getSwordLength(){
        return this.swordLength;
    }

    //Metodo de instancia
    public void createAShieldWall(){
        this.setDefenseLevel(this.getDefenseLevel() + 1);
    }
    //Metodo para obtener los datos del espadachin
    public String dataFile() {
        return super.dataFile()+"\t Longitud de Espada: "+this.swordLength;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\n\nLongitud de Espada: "+this.swordLength;
    }
}
