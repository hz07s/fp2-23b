/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.util.*;

//Hereda de la clase abstarcta Military e implementa Coalition
public class Army extends Military implements Coalition{
    public static final int MAX_SOLDIERS = 10;
    private String name, nickName, kingdom;
    private char column;
    private int armyNumber, numSoldiers, swordsmans = 0, knights = 0, archers = 0, spearmans = 0, totalLife, team, row;
    private ArrayList<Soldier> mySoldiers = new ArrayList<Soldier>();
    private boolean live = true;
    private String color;

    //Metodo constructor
    public Army(String nam, int armyNum, int bonus, String kng, int tm, String color){
        Random random = new Random();
        setName(nam);
        setArmyNumber(armyNum);
        setKingdom(kng);
        setTeam(tm);
        setColor(color);
        //Arreglo de los tipos de soldados posibles
        String[] typeSoldier = {"Espadachin", "Caballero", "Arquero", "Lancero", "Especial"};
        int numSoldiers = random.nextInt(MAX_SOLDIERS) + 1;
        for (int j = 0; j < numSoldiers; j++) {
            int typeSold = random.nextInt(typeSoldier.length);
            String name = typeSoldier[typeSold] + j + "X" + (armyNumber);
            int lifeLevel = random.nextInt(3);
            Soldier sold = null;
            //Switch para evaluar y crear el soldado según lo elegido aleatoriamente
            switch (typeSold) {
                case 0:
                    //Crea un Espadachin
                    int swordLength = random.nextInt(5) + 1;
                    sold = new Swordsman(name, lifeLevel+8+bonus, 10, 8, tm, armyNumber, swordLength);
                    swordsmans++;
                    sold.setColor(color);
                    break;
                case 1:
                    //Crea un Caballero
                    sold = new Knight(name, lifeLevel+10+bonus, 13, 7, tm, armyNumber);
                    knights++;
                    sold.setColor(color);
                    break;
                case 2:
                    //Crea un Arquero
                    int arrows = random.nextInt(10) + 1;
                    sold = new Archer(name, lifeLevel+3+bonus, 7, 3, tm, armyNumber, arrows);
                    archers++;
                    sold.setColor(color);
                    break;
                case 3:
                    //Crea un Lancero
                    int spearLength = random.nextInt(5) + 1;
                    sold = new Spearman(name, random.nextInt(4)+5+bonus, 5, 10, tm, armyNumber, spearLength);
                    spearmans++;
                    sold.setColor(color);
                    break;
                case 4:
                    //Crea una unidad especial
                    int swordLengthSpecial = random.nextInt(5) + 1;
                    //Se evalua el reino y dependiendo creara unidades especiales
                    switch (getKingdom()) {
                        case "Inglaterra":
                            sold = new SwordsmanRoyal("Espadachin_Real", 12+bonus, 10, 8, tm, armyNumber, swordLengthSpecial);
                            swordsmans++;
                            sold.setColor(color);
                            break;
                        case "Francia":
                            sold = new KnightFranco("Caballero_Franco", 15+bonus, 13, 7, tm, armyNumber);
                            knights++;
                            sold.setColor(color);
                            break;
                        case "Castilla-Aragon":
                            sold = new SwordsmanConqueror("Espadachin_Conquistador", 14+bonus, 10, 8, tm, armyNumber, swordLengthSpecial);
                            swordsmans++;
                            sold.setColor(color);
                            break;
                        case "Moros":
                            sold = new KnightMoro("Caballero_Moro", 13+bonus, 13, 7, tm, armyNumber);
                            knights++;
                            sold.setColor(color);
                            break;
                        case "Sacro Imperio Romano Germanico":
                            sold = new SwordsmanTeutonic("Espadachin_Teutonico", 13+bonus, 10, 8, tm, armyNumber, swordLengthSpecial);
                            swordsmans++;
                            sold.setColor(color);
                            break;
                    }
            }
            //Agrega el soldado creado al ejercito
            mySoldiers.add(sold);
        }
    }

    //Metodos mutadores
    public void setMySoldiers(ArrayList<Soldier> al){
        this.mySoldiers = al;
    }
    public void setTotalLife(int tl){
        this.totalLife = tl;
    }
    public void setArmyNumber(int armyNum){
        this.armyNumber = armyNum;
    }
    public void setNumSoldiers(int numSold){
        this.numSoldiers = numSold;
    }
    public void setName(String nam){
        this.name = nam;
    }
    public void setKingdom(String kng){
        this.kingdom = kng;
    }
    public void setTeam(int t){
        this.team = t;
    }
    public void setRow(int r){
        this.row = r+1;
    }
    public void setColumn(int c){
        this.column = (char)(65+c);
    }
    public void setLive(boolean lv){
        this.live = lv;
    }
    public void setNickName(String nn){
        this.nickName = nn;
    }
    public void setColor(String cl){
        this.color = cl;
    }
    

    //Metodos accesores
    public ArrayList<Soldier> getMySoldiers(){
        return this.mySoldiers;
    }
    public int getTotalLife(){
        this.totalLife = 0;
        for (Soldier sold : mySoldiers) if (sold.getLive()) this.totalLife += sold.getCurrentLife();
        return this.totalLife;
    }
    public int getArmyNumber(){
        return this.armyNumber;
    }
    public int getNumSoldiers(){
        this.numSoldiers = 0;
        for (Soldier sold : mySoldiers) if (sold.getLive()) this.numSoldiers++;
        return this.numSoldiers;
    }
    public String getName(){
        return this.name;
    }
    public String getKingdom(){
        return this.kingdom;
    }
    public int getTeam(){
        return this.team;
    }
    public int getRow(){
        return this.row-1;
    }
    public int getRowReal(){
        return row;
    }
    public char getColumn(){
        return this.column;
    }
    public int getColumnInt(){
        return ((int) column) - 65;
    }
    public boolean getLive(){
        for (Soldier sold : mySoldiers) if (sold.getLive()) return true;
        setLive(false);
        return this.live;
    }
    public String getNickname(){        
        setNickName(this.getNumSoldiers() + "-" + this.getTotalLife());
        return nickName;
    }
    public String getColor(){
        return color;
    }

    //Metodos de instancia
    public ArrayList<Military> getMyMilitaries(){
        return new ArrayList<Military>(mySoldiers);
    }
    public boolean isAlive(){
        for (Soldier sold : mySoldiers) if (sold.getLive()) return true;
        setLive(false);
        return this.live;
    }
    public void victoryBonus(){
        for (Soldier sold : mySoldiers) if (sold.getLive()) sold.setCurrentLife(sold.getCurrentLife()+1);
    }
    public void die(){
        for (Soldier sold : mySoldiers) sold.setLive(false);
    }

    //Obtiene los datos del ejercito como una cadena de string
    public String dataFile() {
        String data = "Ejercito: "+name+"\t Activo: "+getLive()+"\t Vida total: "+getTotalLife()
        +"\t Soldados creados: "+mySoldiers.size()+"\t Soldados vivos: "+getNumSoldiers()
        +"\t Espadachines: "+swordsmans+"\t Arqueros: "+archers
        +"\t Caballeros: "+knights+"\t Lanceros: "+spearmans
        +"\t Posicion: "+column+row+"\n\n";
        for (Soldier sold : mySoldiers) {
    data += "    "+sold.dataFile()+"\n";
        }

        return data;
    }

    //Metodo toString
    public String toString(){
    return name+"\n\nReino: "+kingdom+"\n\nEjercito activo: "+getLive()+"\n\nVida total: "+getTotalLife()
               +"\n\nSoldados creados: "+mySoldiers.size()+"\n\nSoldados vivos: "+getNumSoldiers()
               +"\nEspadachines: "+swordsmans+"\nArqueros: "+archers
               +"\nCaballeros: "+knights+"\nLanceros: "+spearmans
               +"\n\nPosicion: "+column+row;
    }
}
