/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Swordman
public class SwordsmanRoyal extends Swordsman{
    private Knives knives;
    private int levelEvolution;
  
    //Metodos constructores
    public SwordsmanRoyal(String n, int lL, int ack, int def, int t, int ta, int sl){
        super(n, lL, ack, def, t, ta, sl);
        setLevelEvolution(1);
        knives = new Knives();
        setImage("src/swordsman_royal_");
    }
    public SwordsmanRoyal(String n, int lL, int ack, int def, int t, char c, int r, int sl){
        super(n, lL, ack, def, t, c, r, sl);
        setLevelEvolution(1);
        knives = new Knives();
        setImage("src/swordsman_royal_");
    }

    //Controlar el nivel de evolucion
    public void setLevelEvolution(int le){
        this.levelEvolution = le;
    }
    public int getLevelEvolution(){
        return this.levelEvolution;
    }
    public void evolution() {
        if (levelEvolution < 4){
            if (knives.getNum() < Knives.NUM_MAX)
                knives.increaseNum();
  
            if (knives.getSize() < Knives.SIZE_MAX)
                knives.increaseSize(); 
        
            levelEvolution++;
        }
    }

    //Habilidad - lanzar cuchillos
    public void throwingKnives() {
        if (knives.getNum() > 0) 
            knives.setNum(knives.getNum() - 3);
    }

    //Metodo para obtener los datos del espadachin real
    public String dataFile() {
        return super.dataFile()+"\t Nivel de evolucion: "+this.levelEvolution;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\nNivel de evolucion: "+this.levelEvolution;
    }
}
