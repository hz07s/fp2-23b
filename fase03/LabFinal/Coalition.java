/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.util.ArrayList;
//Interfaz util para guardar los datos de los objetos hijos de Coalition en bytes
import java.io.Serializable;

//Ingerfaz que hereda de Serializable
public interface Coalition extends Serializable{
    //Obtener las unidades pertenecientes a la unidad que las engloba
    ArrayList<Military> getMyMilitaries();
    //Obtener el nombre del reino al que pertenece
    String getKingdom();
}