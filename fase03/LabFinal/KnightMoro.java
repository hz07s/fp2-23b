/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/
//Hereda de la clase Knight
public class KnightMoro extends Knight{
    private Arrows arrows;
    private int levelEvolution;
  
    //Metodos constructores
    public KnightMoro(String n, int lL, int ack, int def, int t, int ta){
        super(n, lL, ack, def, t, ta);
        setLevelEvolution(1);
        arrows = new Arrows();
        setImage("src/knight_moro_");
    }
    public KnightMoro(String n, int lL, int ack, int def, int t, char c, int r){
        super(n, lL, ack, def, t, c, r);
        setLevelEvolution(1);
        arrows = new Arrows();
        setImage("src/knight_moro_");
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
            if (arrows.getNum() < Arrows.NUM_MAX)
                arrows.increaseNum();
  
            if (arrows.getSize() < Arrows.SIZE_MAX)
                arrows.increaseSize(); 
        
            levelEvolution++;
        }
    }

    //Habilidad - lanzar flechas
    public void shootArrows() {
        if (arrows.getNum() > 0) 
            arrows.setNum(arrows.getNum() - 10);
    }

    //Enviste con mayor poder
    public void charge(){
        if (this.isMounting()) {
            for (int i = 0; i < 4; i++)
                this.attack();
        } else {
            for (int i = 0; i < 3; i++)
                this.attack();
        }
    }

    //Metodo para obtener los datos del caballero moro
    public String dataFile() {
        return super.dataFile()+"\t Nivel de evolucion: "+this.levelEvolution;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\nNivel de evolucion: "+this.levelEvolution;
    }
}
