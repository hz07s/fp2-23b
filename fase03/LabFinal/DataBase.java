/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

//Imports para la conexion a la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase instance;

    // La conexión a la base de datos
    private Connection connection;

    // Credenciales sobre la base de datos
    private static final String JDBC_URL = "jdbc:mysql://bzd2feukkimivqje2lb7-mysql.services.clever-cloud.com:3306/bzd2feukkimivqje2lb7";
    private static final String USER = "uf812gj0y6ob1akl";
    private static final String PASSWORD = "7nRZViLlzjURY9UTuZSd";

    // Constructor privado para evitar instanciación directa
    private DataBase() {
        try {
            // Cargar el driver de JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            this.connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la instance única
    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        return this.connection;
    }
}