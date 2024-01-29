/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Knight
public class KnightFranco extends Knight{
    private Spears spears;
    private int levelEvolution;
  
    //Metodos constructores
    public KnightFranco(String n, int lL, int ack, int def, int t, int ta){
        super(n, lL, ack, def, t, ta);
        setLevelEvolution(1);
        spears = new Spears();
        setImage("src/knight_franco_");
    }
    public KnightFranco(String n, int lL, int ack, int def, int t, char c, int r){
        super(n, lL, ack, def, t, c, r);
        setLevelEvolution(1);
        spears = new Spears();
        setImage("src/knight_franco_");
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
            if (spears.getNum() < Spears.NUM_MAX)
                spears.increaseNum();
  
            if (spears.getSize() < Spears.SIZE_MAX)
                spears.increaseSize(); 
        
            levelEvolution++;
        }
    }

    //Habilidad - lanzar lanzas
    public void throwingSpears() {
        if (spears.getNum() > 0) 
            spears.setNum(spears.getNum() - 3);
    }  
    //Metodo para obtener los datos del caballero franco
    public String dataFile() {
        return super.dataFile()+"\t Nivel de evolucion: "+this.levelEvolution;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\nNivel de evolucion: "+this.levelEvolution;
    }
}
