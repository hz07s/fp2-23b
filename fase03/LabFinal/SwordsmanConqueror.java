/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Swordman
public class SwordsmanConqueror extends Swordsman{
    private Hatchets hatchets;
    private int levelEvolution;
  
    //Metodos constructores
    public SwordsmanConqueror(String n, int lL, int ack, int def, int t, int ta, int sl){
        super(n, lL, ack, def, t, ta, sl);
        setLevelEvolution(1);
        hatchets = new Hatchets();
        setImage("src/swordsman_conqueror_");
    }
    public SwordsmanConqueror(String n, int lL, int ack, int def, int t, char c, int r, int sl){
        super(n, lL, ack, def, t, c, r, sl);
        setLevelEvolution(1);
        hatchets = new Hatchets();
        setImage("src/swordsman_conqueror_");
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
            if (hatchets.getNum() < Hatchets.NUM_MAX)
                hatchets.increaseNum();
  
            if (hatchets.getSize() < Hatchets.SIZE_MAX)
                hatchets.increaseSize(); 
        
            levelEvolution++;
        }
    }

    //Habilidad - lanzar hachas
    public void throwingHatchets() {
        if (hatchets.getNum() > 0) 
            hatchets.setNum(hatchets.getNum() - 3);
    }
    
    //Metodo para obtener los datos del espadachin conquistador
    public String dataFile() {
        return super.dataFile()+"\t Nivel de evolucion: "+this.levelEvolution;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\nNivel de evolucion: "+this.levelEvolution;
    }
}
