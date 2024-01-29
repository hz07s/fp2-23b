/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.awt.Desktop; //Para interactuar con el escritorio del SO
import java.io.*; //Para manejar la entrada y salida de datos
import java.util.ArrayList; //Para almacenar los Player y Map

//Clase para el guardado de los datos de la partida
public class ExportFile {
    //Recibe el ArrayLust de Players y el Map donde se desarrollo el juego
    public static void fileWriter(ArrayList<Player> game, Map map){
        String fileName = "DataGame.txt"; //Nombre del archivo

        try {
            //Objeto par escribir en el archivo
            PrintWriter fileOut = new PrintWriter(fileName);
            
            //Informacion sobre el archivo
            fileOut.println("               Shadow of the kingdoms\n");
            fileOut.println("               "+game.get(0).getKingdom()+" VS "+game.get(1).getKingdom());
            fileOut.println("\n\nMapa: "+map);

            //Escribe la informacion sobre cada Player
            for(int i = 0; i < game.size(); i++){
                fileOut.println("\n\n"+"Player "+(i+1)+": "+game.get(0)+"\n\n");
                fileOut.println(game.get(i).getMyKingdom().dataFile());
            }
            
            fileOut.close();
            
            System.out.println("Se ha escrito en el archivo correctamente.");
            //Objeto File asociado al archivo que se acaba de crear
            File archivo = new File(fileName);

            //Primero se verifica que se pueda abrir archivos
            if (Desktop.isDesktopSupported()) {
                // Obtiene el objeto Desktop
                Desktop desktop = Desktop.getDesktop();
                // Abre el archivo con la aplicación predeterminada
                desktop.open(archivo);
            } else {
                System.out.println("El sistema no soporta la apertura de archivos.");
            }

        //En caso no se haya podido escreibir en el archivo
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
