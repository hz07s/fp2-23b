/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Interfaz util para guardar los datos de los objetos hijos de Military en bytes
import java.io.Serializable;

//Clase abstracta para el uso de polimorfismo
public abstract class Military implements Serializable{
    public abstract boolean getLive(); //Obtener si está vivo o no
    public abstract int getTeam(); //Obtener el equipo al que pertenece
    public abstract void setRow(int r); //Establecer fila
    public abstract void setColumn(int c); //Establecer columna
    public abstract int getRow(); //Obtener fila
    public abstract int getColumnInt(); //Obtener columna
    public abstract String getColor(); //Obtener color
}