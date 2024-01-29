/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Swordman
public class SwordsmanTeutonic extends Swordsman{
    private Javelins javelins;
    private int levelEvolution;
  
    //Metodos constructores
    public SwordsmanTeutonic(String n, int lL, int ack, int def, int t, int ta, int sl){
        super(n, lL, ack, def, t, ta, sl);
        setLevelEvolution(1);
        javelins = new Javelins();
        setImage("src/swordsman_teutonic_");
    }
    public SwordsmanTeutonic(String n, int lL, int ack, int def, int t, char c, int r, int sl){
        super(n, lL, ack, def, t, c, r, sl);
        setLevelEvolution(1);
        javelins = new Javelins();
        setImage("src/swordsman_teutonic_");
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
            if (javelins.getNum() < Javelins.NUM_MAX)
                javelins.increaseNum();
  
            if (javelins.getSize() < Javelins.SIZE_MAX)
                javelins.increaseSize(); 
        
            levelEvolution++;
        }
    }

    //Habilidad - lanzar jabalina
    public void throwingJavelin() {
        if (javelins.getNum() > 0) 
            javelins.setNum(javelins.getNum() - 1);
    }

    //Defensa especial - modo tortuga
    public void turtleMode() {
        this.setDefenseLevel(this.getDefenseLevel() + 1);
    }

    //Metodo para obtener los datos del espadachin tetonico
    public String dataFile() {
        return super.dataFile()+"\t Nivel de evolucion: "+this.levelEvolution;
    }

    //Metodo toString
    public String toString(){
        return super.toString()+"\nNivel de evolucion: "+this.levelEvolution;
    }
}
