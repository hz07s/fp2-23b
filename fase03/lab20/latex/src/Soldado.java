public class Soldado {
  private VideoJuego7 VideoJuego7;
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
  private char type;
  private String reino;
  
  public Soldado(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
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
    this.VideoJuego7 = VideoJuego7;
  }
  //Soldado s = new Soldado(VideoJuego7.this,name, row + 1, column, t, attackLevel, levelDefense, levelLife, speed);
  public Soldado(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
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
    this.VideoJuego7 = VideoJuego7;
  }
  public Soldado(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
                int speed, String attitude, boolean lives, String reino){
    this.name = name;
    this.row = row;
    this.column = column;
    this.team = team;
    this.actualLife = levelLife;
    this.speed = speed;
    this.lives = true;
    this.VideoJuego7 = VideoJuego7;
    this.reino = reino;
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
  public void setType(char ty){
    type = ty;
  }
  public void setReino(char re){
    type = re;
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
  public VideoJuego7 getVideoJuego7() {
    return VideoJuego7;
  }
  public char getType(){
    return type;
  }
  public String getReino(){
    return reino;
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
              "\n Type: "          + type          +               
              "\n}\n";    
  }

  public void attack(int i){
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
    VideoJuego7.removeSoldier(this);
    this.lives = false;
  }
}