/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Hereda de la clase Military
public class Soldier extends Military{
    public static int cantSoldiersAlive = 0;
    private String name, nickName, attitude = "neutra";
    private char column;
    private int attackLevel = 0, defenseLevel = 0, lifeLevel, currentLife, speed = 0, team, teamArmy, row;
    private boolean live = true;
    private String image;
    private String color;

    //Metodos constructores
    public Soldier(String n, int lL, int ack, int def, int t, int ta){
        name = n;
        lifeLevel = lL;
        currentLife = lL;
        attackLevel = ack;
        defenseLevel = def;
        team = t;
        teamArmy = ta;
        cantSoldiersAlive++;
    }
    public Soldier(String n, int lL, int ack, int def, int t, char c, int r){
        name = n;
        lifeLevel = lL;
        currentLife = lL;
        attackLevel = ack;
        defenseLevel = def;
        team = t;
        column = c;
        row = r;
        cantSoldiersAlive++;
    }
    public Soldier(String n, int ack, int def, int lL, int cL, int spe, String att, boolean lv, int t, char c, int r){
        name = n;
        attackLevel = ack;
        defenseLevel = def;
        lifeLevel = lL;
        currentLife = cL;
        speed = spe;
        attitude = att;
        live = lv;
        team = t;
        column = c;
        row = r;
        cantSoldiersAlive++;
    }

    //Metodos mutadores
    public void setName(String nam){
        name = nam;
    }
    public void setAttackLevel(int ack){
        attackLevel = ack;
    }
    public void setDefenseLevel(int def){
        defenseLevel = def;
    }
    public void setLifeLevel(int lL){
        lifeLevel = lL;
    }
    public void setCurrentLife(int cl){
        currentLife = cl;
    }
    public void setSpeed(int spe){
        speed = spe;
    }
    public void setAttitude(String at){
        attitude = at;
    }
    public void setLive(boolean lv){
        live = lv;
    }
    public void setRow(int r){
        row = r+1;
    }
    public void setColumn(int c){
        column = (char)(65+c);
    }
    public void setTeam(int t){
        team = t;
    }
    public void setTeamArmy(int ta){
        teamArmy = ta;
    }
    public void setNickName(String nn){
        nickName = nn;
    }
    public void setColor(String cl){
        color = cl;
    }
    public void setImage(String img){
        image = img;
    }

    //Metodos accesores
    public String getName(){
        return name;
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
    public int getCurrentLife(){
        return currentLife;
    }
    public int getSpeed(){
        return speed;
    }
    public String getAttitude(){
        return attitude;
    }
    public boolean getLive(){
        return live;
    }
    public int getRow(){
        return row-1;
    }
    public int getRowReal(){
        return row;
    }
    public char getColumn(){
        return column;
    }
    public int getColumnInt(){
        return ((int) column) - 65;
    }
    public int getTeam(){
        return team;
    }
    public int getTeamArmy(){
        return teamArmy;
    }
    public String getColor(){
        return color;
    }
    public String getImage(){
        return image;
    }
    public String getNickName(){
        String typeSoldier;
        if (this instanceof Swordsman)
            typeSoldier = "E";
        else if (this instanceof Knight)
            typeSoldier = "C";
        else if (this instanceof Archer)
            typeSoldier = "A";
        else if (this instanceof Spearman)
            typeSoldier = "L";
        else if (this instanceof SwordsmanRoyal)
            typeSoldier = "ER";
        else if (this instanceof KnightFranco)
            typeSoldier = "CF";
        else if (this instanceof SwordsmanConqueror)
            typeSoldier = "EC";
        else if (this instanceof KnightMoro)
            typeSoldier = "CM";
        else if (this instanceof SwordsmanTeutonic)
            typeSoldier = "ET";
        else
            typeSoldier = "N";
        
        setNickName(typeSoldier + this.getCurrentLife());
        return nickName;
    }

    //Metodos de instancia
    public void attack(){
        attitude = "ofensiva";
        advance();
    }
    public void defend(){
        attitude = "defensiva";
        speed = 0;
    }
    public void advance(){
        speed++;
    }
    public void back(){
        if (speed > 0){
            defend();
        } else if (speed == 0){
            speed--;
        }
    }
    public void beAttacked(int ack){
        defend();
        currentLife -= ack;
        if (currentLife <= 0) die();
    }
    public void flee(){
        attitude = "fuga";
        speed += 2;
    }
    public void die(){
        live = false;
    }

    //Agrega valores de otro soldado a los atributos del actual
    public void toAdd(Soldier another){
        this.lifeLevel += another.getLifeLevel();
        this.attackLevel += another.getAttackLevel();
        this.defenseLevel += another.getDefenseLevel();
        this.speed += another.getSpeed();
    }
    
    //Clona el soldado a una nueva ubicacion
    public Soldier clone(char c, int r){
        return new Soldier(name, attackLevel, defenseLevel, lifeLevel, currentLife, speed, attitude, live, team, c, r);
    }

    //Obtiene los datos del Soldado como una cadena de String
    public String dataFile() {
        return "Soldado: "+name+"\t Nivel de ataque: "+attackLevel
        +"\t Nivel de defensa: "+defenseLevel+"\t Nivel de vida: "+lifeLevel
        +"\t Vida actual: "+currentLife+"\t Velocidad: "+speed
        +"\t Actitud: "+attitude+"\t Vivo: "+live
        +"\t Reino: "+team+"\t Ejercito: "+team
        +"\t Posicion: "+column+getRowReal();
    }

    //Metodo toString
    public String toString(){
        return "Nombre: "+name+"\n\nNivel de ataque: "+attackLevel
                +"\nNivel de defensa: "+defenseLevel+"\nNivel de vida: "+lifeLevel
                +"\n\nVida actual: "+currentLife+"\nVivo: "+live
                +"\n\nVelocidad: "+speed+"\nActitud: "+attitude
                +"\nReino: "+team+"\nEjercito: "+team
                +"\nPosicion: "+column+getRowReal();
    }
}