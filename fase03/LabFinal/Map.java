/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.util.*;
import java.awt.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

//Hereda de Serializable
public class Map implements Serializable{
    public static final int MAP_SIZE = 10;
    public static final String[] TERRITORYS = {"bosque", "campo abierto", "montana", "desierto", "playa"};
    //HashMap con la ubicacion de imagenes segun el territorio
    public static final HashMap<String, String> TERRITORYS_IMG = new HashMap<String, String>() {{
        put("bosque", "src/bosque.jpeg");
        put("campo abierto", "src/campo_abierto.jpeg");
        put("montana", "src/montana.jpeg");
        put("desierto", "src/desierto.jpeg");
        put("playa", "src/playa.jpeg");
    }};
    //HashMap con colores segun el color en String elegido
    public static final HashMap<String, Color> COLORS = new HashMap<String, Color>() {{
        put("blue", Color.BLUE);
        put("red", Color.RED);
        put("green", Color.GREEN);
        put("yellow", Color.YELLOW);
        put("grey", Color.GRAY);
        put("orange", Color.ORANGE);
        put("purple", Color.MAGENTA);
        put("cyan", Color.CYAN);
    }};
    private ArrayList<Coalition> kingdoms;
    private ArrayList<Coalition> armys;
    private String territory;
    private JButton[][] boardArmys;
    private JButton[][] boardSoldiers;
    private int numArmys;
    private int numSoldiers;
    

    //Metodo constructor
    public Map(){
        Random random = new Random();
        setTerritory(TERRITORYS[random.nextInt(5)]);
        boardArmys = createButtons();
    }

    //Metodos mutadores
    public void setTerritory(String tr){
        this.territory = tr;
    }
    public void setBoardArmys(JButton[][] ba){
        this.boardArmys = ba;
    }
    public void setBoardSoldiers(JButton[][] bs){
        this.boardSoldiers = bs;
    }
    public void setArmys(ArrayList<Coalition> ar){
        this.armys = ar;
    }
    public void setKingdoms(ArrayList<Coalition> kn){
        this.kingdoms = kn;
    }
    
    //Metodos accesores
    public String getTerritory(){
        return this.territory;
    }
    public JButton[][] getBoardArmys(){
        return this.boardArmys;
    }
    public JButton[][] getBoardSoldiers(){
        return this.boardSoldiers;
    }
    public ArrayList<Coalition> getArmys(){
        return this.armys;
    }
    public ArrayList<Coalition> getKingdoms(){
        return this.kingdoms;
    }

    //Metodos de instancia
    public void createBoardArmys(Kingdom ally, Kingdom enemy){
        Random random = new Random();
        boardArmys = createButtons();
        kingdoms = new ArrayList<Coalition>();
        kingdoms.add(ally);
        kingdoms.add(enemy);
        for (Coalition kingdom : kingdoms){
            for (Army army : ((Kingdom)kingdom).getArmys()){
                if (army.getLive()){
                    if (army.getRowReal() == 0){
                        int row, column;
                        do {
                            row = random.nextInt(10);
                            column = random.nextInt(10);
                        } while (this.positionArmys(row, column) != null);
                        army.setRow(row);
                        army.setColumn(column);
                    }
                    this.modifyPositionArmys(army.getRow(), army.getColumnInt(), army);
                }
            }
        }
    }

    //Crea el tablero de soldados con ambos ejercitos dentro
    public void createBoardSoldiers(Army ally, Army enemy){
        Random random = new Random();
        boardSoldiers = createButtons();
        armys = new ArrayList<Coalition>();
        armys.add(ally);
        armys.add(enemy);
        for (Coalition army : armys){
            for (Soldier sold : ((Army)army).getMySoldiers()){
                if (sold.getLive()){
                    int row, column;
                    do {
                        row = random.nextInt(10);
                        column = random.nextInt(10);
                    } while (this.positionSoldiers(row, column) != null);
                    sold.setRow(row);
                    sold.setColumn(column);
                    this.modifyPositionSoldiers(row, column, sold, ((Army)army).getTeam());
                }
            }
        }
    }

    //Crea los botones para el tablero de soldados y lo retorna
    public JButton[][] createButtons(){
        JButton[][] board = new JButton[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++)
            for (int j = 0; j < MAP_SIZE; j++){
                board[i][j] = new JButton();
                //Le asigna propiedades
                board[i][j].putClientProperty("r", i);
                board[i][j].putClientProperty("c", j);
                //Le asigna estilos
                board[i][j].setContentAreaFilled(false);
                board[i][j].setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            }
        return board;
    }

    //Devuelve el ejercito que se encuentra en la ubicion del tablero dada
    public Army positionArmys(int row, int column){
        return (Army)boardArmys[row][column].getClientProperty("Army");
    }

    //Modifica la posicion de un ejercito en el tablero
    public void modifyPositionArmys(int row, int column, Army army){
        boardArmys[row][column].putClientProperty("Army", army);
        
        ImageIcon imgArmy = new ImageIcon("src/" + army.getKingdom() + "_"+ army.getColor() + ".png");
        Image img = imgArmy.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        ImageIcon iconImg = new ImageIcon(img);
        boardArmys[row][column].setIcon(iconImg);
        boardArmys[row][column].setHorizontalTextPosition(SwingConstants.CENTER);
        boardArmys[row][column].setVerticalTextPosition(SwingConstants.CENTER);
        boardArmys[row][column].setBorder(new LineBorder(COLORS.get(army.getColor()), 2));
    }

    //Cuenta la cantidad de ejercitos presentes en el tablero
    public int numArmys(){
        this.numArmys = 0;
        for (JButton[] row : boardArmys)
            for (JButton button : row)
                if (button.getClientProperty("Army") != null) this.numArmys++;
        return this.numArmys;
    }

    //Devuelve el soldado que se encuentra en la ubicacion del tablero dada
    public Soldier positionSoldiers(int row, int column){
        return (Soldier)boardSoldiers[row][column].getClientProperty("Soldier");
    }

    //Modifica la posicion de un soldado en el tablero
    public void modifyPositionSoldiers(int row, int column, Soldier sold, int team){
        boardSoldiers[row][column].putClientProperty("Soldier", sold);
        ImageIcon imgSold = new ImageIcon(sold.getImage() + sold.getColor() + ".png");
        Image img = imgSold.getImage();
        Image imgB = img.getScaledInstance(55,55, Image.SCALE_SMOOTH);
        ImageIcon iconImg =  new ImageIcon(imgB);
        boardSoldiers[row][column].setBackground(Color.WHITE);
        boardSoldiers[row][column].setIcon(iconImg);
        boardSoldiers[row][column].setContentAreaFilled(false);
        boardSoldiers[row][column].setHorizontalTextPosition(SwingConstants.CENTER);
        boardSoldiers[row][column].setVerticalTextPosition(SwingConstants.CENTER);
        boardSoldiers[row][column].setBorder(new LineBorder(COLORS.get(sold.getColor()), 2));
    }

    //Devuelve la cantidad de soldados presentes en el tablero
    public int numSoldiers(){
        this.numSoldiers = 0;
        for (JButton[] row : boardSoldiers)
            for (JButton button : row)
                if (button.getClientProperty("Soldier") != null) this.numSoldiers++;
        return this.numSoldiers;
    }

    //Metodo toString
    public String toString(){
        return "Territorio: " + getTerritory() + "\tCantidad de ejercitos: " + numArmys();
    }
}
