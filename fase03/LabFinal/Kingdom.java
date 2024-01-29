/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Implementa la interfaz Coalition
public class Kingdom implements Coalition{
    public static final int MAX_ARMYS = 10;
    //Posibles reinos
    public static final String[] KINGDOMS = {"Inglaterra", "Francia", "Castilla-Aragon", "Moros", "Sacro Imperio Romano Germanico"};
    public static ArrayList<String> freeKingdoms;
    public static int numKingdoms;
    private String kingdom;
    private ArrayList<Army> armys = new ArrayList<Army>();
    private int team, numArmys;

    //Metodo constructor
    public Kingdom(Map map, String km, String color){
        Random random = new Random();

        setKingdom(km);
        numKingdoms++;
        setTeam(numKingdoms);

        int numArmys = random.nextInt(MAX_ARMYS) + 1;
        int bonus = this.bonus(map);

        //Crea a los ejercitos que contendra el reino
        for (int j = 0; j < numArmys; j++) {
            String name = "Ejercito-" + (j+1);
            Army army = new Army(name, j+1, bonus, kingdom, numKingdoms, color);
            armys.add(army);
        }
    }
    
    //Metodo de clase 
    public static void resetKingdoms(){
        freeKingdoms = new ArrayList<>(Arrays.asList(
        "Inglaterra", "Francia", "Castilla-Aragon", "Moros", "Sacro Imperio Romano Germanico"));
        numKingdoms = 0;
    }

    //Metodos mutadores
    public void setArmys(ArrayList<Army> al){
        this.armys = al;
    }
    public void setNumArmys(int na){
        this.numArmys = na;
    }
    public void setKingdom(String kng){
        this.kingdom = kng;
    }
    public void setTeam(int t){
        this.team = t;
    }

    //Metodos accesores
    public ArrayList<Army> getArmys(){
        return this.armys;
    }
    public int getNumArmys(){
        return this.numArmys;
    }
    public String getKingdom(){
        return this.kingdom;
    }
    public int getTeam(){
        return this.team;
    }

    //Metodos de instancia
    public ArrayList<Military> getMyMilitaries(){
        return new ArrayList<Military>(armys);
    }

    //Evalua los reinos y retorna el bono en caso lo merezca
    public int bonus(Map map){
        switch (kingdom) {
            case "Inglaterra":
                return (map.getTerritory().equals("bosque"))? 1 : 0;
            case "Francia":
                return (map.getTerritory().equals("campo abierto") )? 1 : 0;
            case "Castilla-Aragon":
                return (map.getTerritory().equals("montana"))? 1 : 0;
            case "Moros":
                return (map.getTerritory().equals("desierto"))? 1 : 0;
            case "Sacro Imperio Romano Germanico":
                return (map.getTerritory().equals("bosque") || 
                map.getTerritory().equals("playa") || 
                map.getTerritory().equals("campo abierto"))? 1 : 0;
        }
        return 0;
    }

    //Obtiene los datos del reino como una cadena de string
    public String dataFile() {
        String data = "Reino: " + kingdom;
        for (Army army : armys) {
            data += "\n\n"+army.dataFile();
        }
        return data;
    }

    //Metodo toString
    public String toString() {
        return "Reino: " + kingdom;
    }
}
