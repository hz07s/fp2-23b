public class Soldado {
  private String name;
  private int row;
  private char column;
  private char team;

  private int attackLevel;
  private int attackDefense;
  private int lifeLevel;
  private int actualLife;
  private int speed;
  private String attitude;
  private boolean lives;
  
  public Soldado(String name, int row, char column, boolean status, int health, char team) {
    this.name = name;
    this.row = row;
    this.column = column;
    this.team = team;
  }

  //Setters
  public void setName(String n){
    name = n;
  }
  public void setRow(int r){
    row = r;
  }
  public void setColumn(char c){
    column = c;
  }
  public void setTeam(char t){
    team = t;
  }

  public void setAttackLevel(int al){
    attackLevel = al;
  }
  public void setAttackDefense(int ad){
    attackDefense = ad;
  }
  public void setLifeLevel(int af){
    lifeLevel = af;
  }
  public void setActualLife(int al){
    actualLife = al;
  }
  public void setSpeed(int s){
    speed = s;
  }
  public void setAttitude(String a){
    attitude = a;
  }
  public void setLives(boolean l){
    lives = l;
  }

  //Getters
  public String getName(){
    return name;
  }
  public int getRow(){
    return row;
  }
  public char getColumn(){
    return column;
  }
  public char getTeam(){
    return team;
  }

  public int getAttackLevel(){
    return attackLevel;
  }
  public int getAttackDefense(){
    return attackDefense;
  }
  public int getLifeLevel(){
    return lifeLevel;
  }
  public int getActualLife(){
    return actualLife;
  }
  public int getSpeed(){
    return speed;
  }
  public String getAttitude(){
    return attitude;
  }
  public boolean getLives(){
    return lives;
  }
  
  @Override
  public String toString() {  
    return "Data { " + 
              "\n Name:   "        + name          + 
              "\n Row:    "        + row           + 
              "\n Column: "        + column        + 
              "\n Team: "          + team          + 
              "\n AttackLevel: "   + attackLevel   + 
              "\n AttackDefense: " + attackDefense + 
              "\n LifeLevel: "     + lifeLevel     + 
              "\n ActualLife: "    + actualLife    + 
              "\n Speed: "         + speed         + 
              "\n Attitude: "      + attitude      + 
              "\n Lives: "         + lives         + 
              "\n}\n";
              
  }

  public void attack(){

  }
  public void defend(){

  }
  public void advance(){

  }
  public void back(){

  }
  public void beAttacked(){

  }
  public void flee(){
    
  }
  public void die(){

  }
}