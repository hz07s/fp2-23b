public class Soldado {
  private VideoJuego6 videoJuego6;
  private String name;
  private int row;
  private char column;
  private char team;
  private int position;

  private int attackLevel;
  private int levelDefense;
  private int levelLife;
  private int actualLife;
  private int speed;
  private String attitude;
  private boolean lives;
  
  public Soldado(VideoJuego6 videoJuego6,String name, int row, char column, char team, 
                int attackLevel, int levelDefense, int levelLife, int speed, 
                String attitude, boolean lives){
    this.name = name;
    this.row = row;
    this.column = column;
    this.team = team;
    this.attackLevel = attackLevel;
    this.levelDefense = levelDefense;
    this.levelLife = levelLife;
    this.actualLife = levelLife;
    this.speed = speed;
    this.attitude = attitude;
    this.lives = lives;
    this.videoJuego6 = videoJuego6;
  }
  //Soldado s = new Soldado(VideoJuego6.this,name, row + 1, column, t, attackLevel, levelDefense, levelLife, speed);
  public Soldado(VideoJuego6 videoJuego6,String name, int row, char column, char team, 
                int attackLevel, int levelDefense, int levelLife, int speed){
    this.name = name;
    this.row = row;
    this.column = column;
    this.team = team;
    this.attackLevel = attackLevel;
    this.levelDefense = levelDefense;
    this.levelLife = levelLife;
    this.actualLife = levelLife;
    this.speed = speed;
    this.lives = true;
    this.videoJuego6 = videoJuego6;
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
  public void setPosition(char p){
    position = p;
  }

  public void setAttackLevel(int al){
    attackLevel = al;
  }
  public void setLevelDefense(int ad){
    levelDefense = ad;
  }
  public void setLevelLife(int ll){
    levelLife = ll;
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
  public int getPosition(){
    return position;
  }

  public int getAttackLevel(){
    return attackLevel;
  }
  public int getLevelDefense(){
    return levelDefense;
  }
  public int getLevelLife(){
    return levelLife;
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
  public VideoJuego6 getVideoJuego6() {
    return videoJuego6;
  }
  
  @Override
  public String toString() {  
    return "Data { " + 
              "\n Name:   "        + name          + 
              "\n Row:    "        + row           + 
              "\n Column: "        + column        + 
              "\n Team: "          + team          + 
              "\n AttackLevel: "   + attackLevel   + 
              "\n LevelDefense: "  + levelDefense  + 
              "\n LevelLife: "     + levelLife     + 
              "\n ActualLife: "    + actualLife    + 
              "\n Speed: "         + speed         + 
              "\n Attitude: "      + attitude      + 
              "\n Lives: "         + lives         + 
              "\n}\n";
              
  }

  public void attack(){
    advance();
  }
  public void defend(){
    speed = 0;
  }
  public void advance(){
    speed++;
  }
  public void back(){
    if (speed > 0)
      defend();
    else
      speed--;
  }
  public void beAttacked(){
    actualLife--;
    if (actualLife == 0)
      die();
  }
  public void flee(){
    speed += 2;
  }
  public void die(){
    videoJuego6.removeSoldier(this);
    this.lives = false;
  }
}