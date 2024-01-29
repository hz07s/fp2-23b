/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Imports para el manejo de archivos y conexion a la base de datos
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InteractionBD {
    private static String fileName = "saveGame.txt"; //Nombre fijo del archivo

    //Metodo para guardar la partida
    public static void saveGame(String gameName, Object[] game){
        //Escribe el arreglo de objetos
        try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fileOut.writeObject(game);
            System.out.println("Kingdom object saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Guarda el archivo en la base de datos
        saveFileToDatabase(gameName);
    }

    //Metodo para guardar el archivo en la base de datos
    private static void saveFileToDatabase(String gameName) {
        try {
            //Realiza la conexion a la base de datos e insersion del archivo
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();
            String insertQuery = "INSERT INTO savegame (game_name, file_game) VALUES (?, ?)";
            
            //Realiza la consulta
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, gameName);
    
                // Leer el contenido del archivo como un array de bytes
                byte[] fileContent = Files.readAllBytes(new File(fileName).toPath());
    
                // Almacenar el array de bytes en la base de datos
                preparedStatement.setBytes(2, fileContent);
                
                //Realiza la consulta para guardar el archivo
                preparedStatement.executeUpdate();
                System.out.println("File saved to database.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para obtener las partidas guardadas
    public static ArrayList<String> getAllSavedGames(){
        ArrayList<String> gameNames = new ArrayList<>();
        //Consulta a la base de datos acerca de los juegos que se encuentren guardados
        try {
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();

            String query = "SELECT game_name FROM savegame";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String gameName = resultSet.getString("game_name");
                    gameNames.add(gameName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gameNames;
    }

    //Metodo para cargar una partida
    //Devuelve un arreglo de objetos obtenidos de la base de datos
    public static Object[] loadGame(String gameName){
        Object[] game = null;
        //Realiza la conexion ala base de atos y la ocnsulta
        try {
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();
    
            String query = "SELECT file_game FROM savegame WHERE game_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, gameName);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Obtener el flujo de bytes desde la base de datos
                        InputStream fileContentStream = resultSet.getBinaryStream("file_game");
    
                        // Deserializar el objeto Kingdom desde el flujo de bytes
                        try (ObjectInputStream fileIn = new ObjectInputStream(fileContentStream)) {
                            game = (Object[]) fileIn.readObject();
                        }
                    }
                }
            }
    
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return game;
    }

    // Método para verificar si el usuario está registrado
    public static boolean authenticateUser(String nickName, String password) {
        // Definir la consulta SQL
        String query = "SELECT * FROM users WHERE nick_name = ? AND password = ?";
        try {
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Establecer los parámetros en la consulta
            preparedStatement.setString(1, nickName);
            preparedStatement.setString(2, password);

            // Ejecutar la consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Si hay al menos una fila en el resultado, el usuario está registrado
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // En caso de error o si no se encuentra el usuario, retornar false
        return false;
    }

    // Método para registrar un nuevo usuario
    public static boolean registerUser(String nickName, String password) {
        // Verificar si ya existe un usuario con el mismo nick_name
        if (userExists(nickName)) {
            System.out.println("Ya existe un usuario con el mismo nick_name.");
            return false;
        }

        // Si no existe, proceder con el registro
        String insertQuery = "INSERT INTO users (nick_name, password) VALUES (?, ?)";

        try {
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Establecer los parámetros en la consulta de inserción
            preparedStatement.setString(1, nickName);
            preparedStatement.setString(2, password);

            // Ejecutar la consulta de inserción
            int rowsAffected = preparedStatement.executeUpdate();

            // Si al menos una fila fue afectada, el registro fue exitoso
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // En caso de error, retornar false
        return false;
    }

    // Método auxiliar para verificar si ya existe un usuario con el mismo nick_name
    private static boolean userExists(String nickName) {
        String query = "SELECT * FROM users WHERE nick_name = ?";

        try {
            DataBase database = DataBase.getInstance();
            Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Establecer el parámetro en la consulta de selección
            preparedStatement.setString(1, nickName);

            // Ejecutar la consulta de selección
            return preparedStatement.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // En caso de error, asumir que el usuario existe
        return true;
    }
}
