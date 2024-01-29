/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Soldier
public class Spearman extends Soldier{
    private int spearLength;

    //Metodos constructores
    public Spearman(String n, int lL, int ack, int def, int t, int ta, int sl){
        super(n, lL, ack, def, t, ta);
        setSpearLength(sl);
        setImage("src/spearman_");
    }
    public Spearman(String n, int lL, int ack, int def, int t, char c, int r, int sl){
        super(n, lL, ack, def, t, c, r);
        setSpearLength(sl);
        setImage("src/spearman_");
    }

    //Metodos mutadores
    public void setSpearLength(int sl){
        this.spearLength = sl;
    }
    
    //Metodos accesores
    public int getSpearLength(){
        return this.spearLength;
    }

    //Metodo de instancia
    public void schiltrom(){
        this.setDefenseLevel(this.getDefenseLevel() + 1);
    }

    //Metodo para obtener los datos del lancero
    public String dataFile() {
        return super.dataFile()+"\t Longitud de Lanza: "+this.spearLength;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\n\nLongitud de Lanza: "+this.spearLength;
    }
}