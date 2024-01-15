public class Soldado {
  private String name; //this
  private int row; //this
  private int col; //this
  private char columnC; //this
  private char team; //this
  private int position; //this

  private int attackLevel;
  private int defenseLevel;
  private int lifeLevel;
  private int actualLife;
  //private int speed; //~quitar
  //private String attitude;//~quitar
  private boolean lives; //this
  private String type;
  private String kingdom; //this
  
  public Soldado() {

  }

  //Setters
  public void setName(String n){
    name = n;
  }
  public void setRow(int r){
    row = r;
  }
  public void setCol(int c){
    col = c;
  }
  public void setColumnC(char c){
    columnC = c;
  }
  public void setTeam(char t){
    team = t;
  }
  public void setPosition(int p){
    position = p;
  }
  public void setAttackLevel(int al){
    attackLevel = al;
  }
  public void setDefenseLevel(int ad){
    defenseLevel = ad;
  }
  public void setLifeLevel(int ll){
    lifeLevel = ll;
  }
  public void setActualLife(int al){
    actualLife = al;
  }
  //public void setSpeed(int s){
  //  speed = s;
  //}
  //public void setAttitude(String a){
  //  attitude = a;
  //}
  public void setLives(boolean l){
    lives = l;
  }
  public void setType(String ty){
    type = ty;
  }
  public void setkingdom(String re){
    type = re;
  }

  //Getters
  public String getName(){
    return name;
  }
  public int getRow(){
    return row;
  }
  public int getCol(){
    return col;
  }
  public char getColumnC(){
    return columnC;
  }
  public char getTeam(){
    return team;
  }
  public int getPosition(){
    return position;
  }
  public int getAttackLevel(){
    return attackLevel;
  }
  public int getDefenseLevel(){
    return defenseLevel;
  }
  public int getLifeLevel(){
    return lifeLevel;
  }
  public int getActualLife(){
    return actualLife;
  }
  //public int getSpeed(){
  //  return speed;
  //}
  //public String getAttitude(){
  //  return attitude;
  //}
  public boolean getLives(){
    return lives;
  }
  public String getType(){
    return type;
  }
  public String getkingdom(){
    return kingdom;
  }
  
  @Override
  public String toString() {  
    return "Data { " + 
              "\n Name:   "        + name          + 
              "\n Row:    "        + row           + 
              "\n Column: "        + columnC       + 
              "\n Team: "          + team          + 
              "\n AttackLevel: "   + attackLevel   + 
              "\n defenseLevel: "  + defenseLevel  + 
              "\n lifeLevel: "     + lifeLevel     + 
              "\n ActualLife: "    + actualLife    + 
            //"\n Speed: "         + speed         + 
            //"\n Attitude: "      + attitude      + 
              "\n Lives: "         + lives         + 
              "\n Type: "          + type          +               
              "\n}\n";    
  }

  public void attack(){
    
  }
}