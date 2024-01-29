/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.util.ArrayList;
import java.util.Arrays;
//Interfaz util para guardar los datos de los objetos hijos de Player en bytes
import java.io.Serializable;

//Hereda de Serializable
public class Player implements Serializable{
    public static final String[] COLORS = {"blue", "red", "green", "yellow", "purple", "cyan", "orange", "grey"};
    public static ArrayList<String> freeColors;
    private String nickName, kingdom, color;
    private Kingdom myKingdom;
    
    //Metodo constructor
    public Player(Map map, String nm, String km, String cl){
        setNickName(nm);
        setKingdom(km);
        setColor(cl);
        this.myKingdom = new Kingdom(map, km, color);
    }

    //Metodo de clase
    public static void resetColors(){
        freeColors = new ArrayList<>();
        freeColors.addAll(Arrays.asList(COLORS));
    }

    //Metodos mutadores
    public void setNickName(String nm){
        this.nickName = nm;
    }
    public void setKingdom(String km){
        this.kingdom = km;
    }
    public void setColor(String cl){
        this.color = cl;
    }
    public void setMyKingdom(Kingdom mk){
        this.myKingdom = mk;
    }

    //Metodos accesores
    public String getNickName(){
        return this.nickName;
    }
    public String getKingdom(){
        return this.kingdom;
    }
    public String getColor(){
        return this.color;
    }
    public Kingdom getMyKingdom(){
        return this.myKingdom;
    }

    //Metodo toString
    public String toString() {
        return "NickName: " + nickName + "\t Reino: " + kingdom + "\t Color: " + color;
    }
}
