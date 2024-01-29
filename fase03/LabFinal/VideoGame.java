/*
Laboratorio Final - VideoGame
Autores: 
    - Eduardo Sebastian Stephan Portugal Portugal
    - Hernan Andy Choquehuanca Zapana
*/

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.net.URL;

public class VideoGame {
    static ArrayList<Player> players;
    static ArrayList<JButton> armysInWar;
    static JLabel turnPlayer;
    static int player = 1;
    static JButton then = null;
    static JFrame window0;
    static JFrame window1;
    static JFrame window2;
    static JPanel mapSpace;
    static JPanel mapArmys;
    static JPanel mapSoldiers;
    static JTextArea description;
    static JTextArea resultSoldierWar;
    static Map map;
    static Color colorButtons = new Color(166 ,39, 39);
    static Color colorText = Color.WHITE;

    //Muestra la ventana del inicio de sesion y/o crear cuenta.
    public static void main(String[] args) {
        
        //Inicio de sesion
        window0 = new JFrame("War of Kingdoms I");
        window0.setSize(520, 600);
        window0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window0.setLocationRelativeTo(null);
        window0.setResizable(false);
        window0.setLayout(new BoxLayout(window0.getContentPane(), BoxLayout.Y_AXIS));
        //window0.setLayout(new BoxLayout(window0.getContentPane(), BoxLayout.Y_AXIS));

        //Image de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_sesionWindow.jpg");
        window0.setContentPane(backgroundImage);

        
        //Titulo
        JLabel loginTitle = new JLabel("BIENVENIDO");
        loginTitle.setFont(new Font("Trajan Pro Bold", Font.BOLD, 30));
        loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTitle.setBorder(new EmptyBorder(15, 10, 15, 10));
        loginTitle.setForeground(Color.WHITE);
        window0.setLayout(new BoxLayout(window0.getContentPane(), BoxLayout.Y_AXIS));
        window0.add(loginTitle);
        
        //Imagen de login
        ImageIcon icon = new ImageIcon("src/logo.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(newImage);
        JLabel loginImage = new JLabel(scaledIcon);
        loginImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        window0.add(loginImage);
        
        //Botones (opciones) del inicio de sesion
        JPanel login = new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        login.setBorder(new EmptyBorder(20, 10, 20, 10));
        login.setOpaque(false);
        
        JButton button1 = new JButton("Iniciar sesion");
        JButton button2 = new JButton(" Registrarse ");

        Font buttonFont = new Font("Courier New", Font.BOLD, 12);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);

        Dimension buttonDimension = new Dimension(135, 25);
        button1.setPreferredSize(buttonDimension);
        button2.setPreferredSize(buttonDimension);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel loginDate11 = new JLabel("       Usuario");
        JLabel loginDate12 = new JLabel("Contraseña");
        JLabel loginDate21 = new JLabel("       Usuario");
        JLabel loginDate22 = new JLabel("Contraseña");
        JPanel loginData = new JPanel();
        loginData.setOpaque(false);

        JTextField textLoginName = new JTextField();
        JTextField textLoginPassword = new JTextField();
        textLoginName.addActionListener(e -> button1.doClick());
        textLoginPassword.addActionListener(e -> button1.doClick());

        JLabel loginL = new JLabel("                INICIE SESION                ");

        loginL.setFont(new Font("Courier New", Font.BOLD, 14));

        textLoginName.setPreferredSize(new Dimension(250, 25));
        textLoginPassword.setPreferredSize(new Dimension(250, 25));
        loginData.setPreferredSize(new Dimension(250, 10));
        loginData.add(loginL);
        loginData.add(loginDate11);
        loginData.add(textLoginName);
        loginData.add(loginDate12);
        loginData.add(textLoginPassword);
        loginData.add(button1);
        login.add(loginData);
        loginData.add(button1);

        JPanel registerData = new JPanel();
        registerData.setOpaque(false);

        JTextField textRegisterName = new JTextField();
        JTextField textRegisterPassword = new JTextField();
        textRegisterName.addActionListener(e -> button1.doClick());
        textRegisterPassword.addActionListener(e -> button1.doClick());

        JLabel RegisterR = new JLabel("                O CREE UNA CUENTA                ");

        RegisterR.setFont(new Font("Courier New", Font.BOLD, 14));
        
        textRegisterName.setPreferredSize(new Dimension(250, 25));
        textRegisterPassword.setPreferredSize(new Dimension(250, 25));
        registerData.setPreferredSize(new Dimension(250, 10));
        registerData.add(RegisterR);
        registerData.add(loginDate21);
        registerData.add(textRegisterName);
        registerData.add(loginDate22);
        registerData.add(textRegisterPassword);
        registerData.add(button2);
        login.add(registerData);

        login.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setOpaque(false);
        buttonSpace.setLayout(new BoxLayout(buttonSpace, BoxLayout.X_AXIS));
        buttonSpace.add(Box.createHorizontalGlue());
        buttonSpace.add(login);
        buttonSpace.add(Box.createHorizontalGlue());
        window0.add(buttonSpace);

        button1.addActionListener(e -> {
            if (InteractionBD.authenticateUser(textLoginName.getText(), textLoginPassword.getText())) {
                mainWindow(window0);
            } else {
                JOptionPane.showMessageDialog(window0, "Usuario o contraseña incorrectos", "Error!", JOptionPane.INFORMATION_MESSAGE);
                textLoginName.setText(null);
                textLoginPassword.setText(null);
            }
        });
        button2.addActionListener(e -> {
            if (InteractionBD.registerUser(textRegisterName.getText(), textRegisterPassword.getText())) {
                mainWindow(window0);
            } else {
                JOptionPane.showMessageDialog(window0, "Usuario ya existente", "Error!", JOptionPane.INFORMATION_MESSAGE);
                textRegisterName.setText(null);
                textRegisterPassword.setText(null);
            }
        });
        window0.setVisible(true);
    }
    
    //Muestra la ventana del menu principal
    public static void mainWindow(JFrame window){
        window.dispose();

        //Menu principal
        window1 = new JFrame("Menu Principal");
        window1.setSize(600, 720);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setLocationRelativeTo(null);
        window1.setResizable(false);
        window1.setLayout(new BoxLayout(window1.getContentPane(), BoxLayout.Y_AXIS));

        //Image de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_mainWindow.png");
        window1.setContentPane(backgroundImage);

        //Titulo
        JLabel videoGameTitle = new JLabel("Shadow of the kingdoms");
        videoGameTitle.setFont(new Font("Trajan Pro Bold", Font.BOLD, 35));
        videoGameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        videoGameTitle.setBorder(new EmptyBorder(15, 10, 15, 10));
        videoGameTitle.setForeground(colorButtons);
        window1.add(videoGameTitle);

        //Image de la portada
        ImageIcon icon = new ImageIcon("src/CoverImage.jpg");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(435, 435, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(newImage);
        JLabel coverImage = new JLabel(scaledIcon);
        coverImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        window1.add(coverImage);

        //Botones (opciones) del menu principal
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBorder(new EmptyBorder(0, 10, 20, 10));

        JButton button1 = new JButton("   Juego 1 vs 1    ");
        JButton button2 = new JButton("  Cargar Partida   ");
        JButton button3 = new JButton("       Salir       ");

        Font buttonFont = new Font("Courier New", Font.BOLD, 14);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);

        Dimension buttonDimension = new Dimension(250, 50);
        button1.setPreferredSize(buttonDimension);
        button2.setPreferredSize(buttonDimension);
        button3.setPreferredSize(buttonDimension);

        button1.setBackground(colorButtons);
        button2.setBackground(colorButtons);
        button3.setBackground(colorButtons);

        button1.setForeground(colorText);
        button2.setForeground(colorText);
        button3.setForeground(colorText);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        button1.addActionListener(e -> {
            playerSetupWindow(window1);
        });
        button2.addActionListener(e -> {
            map = new Map();
            players = new ArrayList<Player>();
            loadGame(window1);
        });
        button3.addActionListener(e -> System.exit(0));

        buttons.add(button1);
        buttons.add(Box.createRigidArea(new Dimension(0, 10)));
        buttons.add(button2);
        buttons.add(Box.createRigidArea(new Dimension(0, 10)));
        buttons.add(button3);
        buttons.setOpaque(false);

        JPanel buttonSpace = new JPanel();
        buttonSpace.setOpaque(false);
        buttonSpace.setLayout(new BoxLayout(buttonSpace, BoxLayout.X_AXIS));
        buttonSpace.add(Box.createHorizontalGlue());
        buttonSpace.add(buttons);
        buttonSpace.add(Box.createHorizontalGlue());
        window1.add(buttonSpace);
        
        window1.setVisible(true);
    }

    //Muestra la ventana de personalizacion
    public static void playerSetupWindow(JFrame window){
        window.dispose();

        // Se inicializa el mapa y arrayLis de los jugadores
        map = new Map();
        players = new ArrayList<Player>();
        Kingdom.resetKingdoms();
        Player.resetColors();

        // Inicializar arreglos para almacenar componentes
        List<JTextField> nickNameFields = new ArrayList<>();
        List<JComboBox<String>> kingdomComboBoxes = new ArrayList<>();
        List<JComboBox<String>> colorComboBoxes = new ArrayList<>();

        // Configuracion básica de la ventana
        JFrame playerSetup = new JFrame("Configuracion de Jugadores");
        playerSetup.setSize(700, 480);
        playerSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerSetup.setLocationRelativeTo(null);
        playerSetup.setResizable(false);
        playerSetup.setLayout(new BorderLayout());

        //Image de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        playerSetup.setContentPane(backgroundImage);

        // Panel vertical principal
        JPanel mainPanel = new JPanel();
        mainPanel.add(Box.createVerticalStrut(60));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(500, 400));
        playerSetup.add(mainPanel, BorderLayout.CENTER);

        // Configurar JTextField de nombres de jugadores
        for (int i = 0; i < 2; i++) {
            JTextField text = new JTextField();
            nickNameFields.add(text);
        }

        // Crear estructura de ingreso para Jugador 1
        JPanel player1Panel = createPlayerPanel(0, nickNameFields, kingdomComboBoxes, colorComboBoxes);
        player1Panel.setOpaque(false);
        mainPanel.add(player1Panel);

        //Espacio en medio
        mainPanel.add(Box.createVerticalStrut(20));

        // Crear estructura de ingreso para Jugador 2
        JPanel player2Panel = createPlayerPanel(1, nickNameFields, kingdomComboBoxes, colorComboBoxes);
        player2Panel.setOpaque(false);
        mainPanel.add(player2Panel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Boton "Jugar"
        JButton playButton = new JButton("Comenzar partida");
        playButton.setBackground(colorButtons);
        playButton.setForeground(Color.WHITE);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        playButton.setHorizontalAlignment(SwingConstants.CENTER);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear objetos Player con los valores ingresados
                players.add(new Player(map, nickNameFields.get(0).getText(), kingdomComboBoxes.get(0).getSelectedItem().toString(), colorComboBoxes.get(0).getSelectedItem().toString()));
                players.add(new Player(map, nickNameFields.get(1).getText(), kingdomComboBoxes.get(1).getSelectedItem().toString(), colorComboBoxes.get(1).getSelectedItem().toString()));
                startGame(playerSetup);
            }
        });
        mainPanel.add(playButton, BorderLayout.SOUTH);

        playerSetup.setLocationRelativeTo(null);
        playerSetup.setVisible(true);
    }

    // Método para crear un panel de ingreso para un jugador
    public static JPanel createPlayerPanel(int playerNumber, List<JTextField> nickNameFields, List<JComboBox<String>> kingdomComboBoxes, List<JComboBox<String>> colorComboBoxes) {
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));

        // Numero del jugador
        JLabel playerLabel = new JLabel("Jugador " + (playerNumber + 1));
        playerLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 20));
        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerPanel.add(playerLabel);
        playerPanel.add(Box.createVerticalStrut(6));

        // Campo de texto para el nick_name
        JTextField textField = new JTextField();
        textField.setBackground(new Color(238, 227, 207));
        textField.setColumns(20);
        textField.setPreferredSize(new Dimension(150, 5));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        nickNameFields.add(textField);
        playerPanel.add(textField);
        playerPanel.add(Box.createVerticalStrut(6));

        JPanel details = new JPanel();
        details.setOpaque(false);

        // ComboBox para elegir el reino
        JComboBox<String> kingdomComboBox = new JComboBox<>(new Vector<>(Kingdom.freeKingdoms));
        kingdomComboBox.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        kingdomComboBox.setBackground(new Color(238, 227, 207));
        kingdomComboBoxes.add(kingdomComboBox);
        
        details.add(kingdomComboBox);
        details.add(Box.createHorizontalStrut(10));

        // ComboBox para elegir el color
        JComboBox<String> colorComboBox = new JComboBox<>(new Vector<>(Player.freeColors));
        colorComboBox.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        colorComboBox.setBackground(new Color(238, 227, 207));
        colorComboBoxes.add(colorComboBox);
        
        details.add(colorComboBox);

        //Agregar details a el panel principal
        playerPanel.add(details);

        // Configurar el tamaño de altura máximo para el panel de cada jugador
        playerPanel.setMaximumSize(new Dimension(400, 100));

        return playerPanel;
    }

    //Muestra la ventana del VideoJuego
    public static void startGame(JFrame window) {
        window.dispose();
    
        //Ventana del VideoJuego
        window2 = new JFrame("Partida en curso");
        window2.setSize(1000, 800);
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setLocationRelativeTo(null);
        window2.setResizable(false);
        
        //Encabezado (Reinos en guerra)
        String kingdom1 = players.get(0).getKingdom();
        String kingdom2 = players.get(1).getKingdom();

        JPanel header = new ImagePanel("src/header_footer.jpg");
        header.setLayout(new FlowLayout(FlowLayout.CENTER));
        header.setBackground(new Color(238,227,207));
        header.setPreferredSize(new Dimension(1000,50));
        JLabel vskingdoms = new JLabel(kingdom1 + " VS " + kingdom2);
        vskingdoms.setFont(new Font("Courier New", Font.BOLD, 30));

        //Imagenes para mostrar los reinos en el header del juego
        ImageIcon img1 = new ImageIcon("src/" + players.get(0).getMyKingdom().getKingdom() + ".png");
        ImageIcon img2 = new ImageIcon("src/" + players.get(1).getMyKingdom().getKingdom() + ".png");

        Image im1 = img1.getImage();
        Image imx = im1.getScaledInstance(45,45 , Image.SCALE_SMOOTH);
        Image im2 = img2.getImage().getScaledInstance(45,45 , Image.SCALE_SMOOTH);
        
        ImageIcon i1 = new ImageIcon(imx);
        ImageIcon i2 = new ImageIcon(im2);

        JLabel imageLabel1 = new JLabel(i1);
        JLabel imageLabel2 = new JLabel(i2);

        //Agrega los elementos al header
        header.add(imageLabel1, BorderLayout.EAST);
        header.add(vskingdoms);
        header.add(imageLabel2); 

        window2.add(header, BorderLayout.NORTH);
      
        //Crear y mostrar Mapa
        createMap(map);
        mapSpace = new ImagePanel(Map.TERRITORYS_IMG.get(map.getTerritory()));
        mapSpace.setLayout(new BorderLayout());
        mapSpace.setPreferredSize(new Dimension(700, 700));
        mapSpace.add(mapArmys, BorderLayout.CENTER);
        window2.add(mapSpace, BorderLayout.CENTER);

        //Panel de informacion para ejercitos y soldados
        JPanel information = new ImagePanel("src/information.jpg");
        information.setPreferredSize(new Dimension(250, 90));
        information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
        information.setBackground(new Color(238,227,207));
        
        //JPanel para texto:
        JPanel panelText = new JPanel();
        JLabel labeltext = new JLabel("DATOS DEL LA UNIDAD");
        panelText.setFont(new Font("Old English Text MT", Font.PLAIN, 20));
        panelText.setMaximumSize(new Dimension(200, 20));
        panelText.setBackground(colorButtons);
        labeltext.setOpaque(false);
        labeltext.setForeground(Color.WHITE);
        panelText.add(labeltext);
        information.add(panelText);

        //Panel para datos de ejercitos y soldados
        description = new JTextArea();
        description.setEditable(false); 
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setFont(new Font("Courier New", Font.BOLD, 14));
        description.setMargin(new Insets(10, 15, 10, 15));
        description.setBackground(new Color(238,227,207));
        description.setForeground(Color.BLACK);
        description.setPreferredSize(new Dimension(200, 150));
        description.setOpaque(false);

        //Panel para caracteristicas de la batalla de soldados
        resultSoldierWar = new JTextArea();
        resultSoldierWar.setEditable(false);
        resultSoldierWar.setLineWrap(true);
        resultSoldierWar.setWrapStyleWord(true);
        resultSoldierWar.setFont(new Font("Courier New", Font.BOLD, 12));
        resultSoldierWar.setMargin(new Insets(10, 15, 10, 15));
        resultSoldierWar.setBackground(new Color(238,227,207));
        resultSoldierWar.setForeground(Color.BLACK);
        resultSoldierWar.setPreferredSize(new Dimension(200, 60));
        resultSoldierWar.setOpaque(false);

        JButton button = new JButton("Abrir Menu");
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setForeground(Color.WHITE);
        button.setBackground(colorButtons);
        button.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 20));
        button.addActionListener(e -> {
            gameMenu();
        });
        
        information.add(description);

        JPanel panelText2 = new JPanel();
        JLabel labeltext2 = new JLabel("ULTIMO ENFRENTAMIENTO");
        panelText2.setFont(new Font("Old English Text MT", Font.PLAIN, 20));
        panelText2.setMaximumSize(new Dimension(200, 20));
        panelText2.setBackground(colorButtons);
        labeltext2.setOpaque(false);
        labeltext2.setForeground(Color.WHITE);
        panelText2.add(labeltext2);
        information.add(panelText2);

        information.add(resultSoldierWar);
        information.add(button);
        window2.add(information, BorderLayout.EAST);
        
        //Parte baja donde se muestra el turno de los jugadores
        JPanel footer = new ImagePanel("src/header_footer.jpg");
        footer.setLayout(new FlowLayout(FlowLayout.CENTER));
        footer.setBackground(new Color(238,227,207));
        footer.setPreferredSize(new Dimension(1000,50));
        turnPlayer = new JLabel("Turno: Player 1");
        turnPlayer.setFont(new Font("Courier New", Font.BOLD, 30));
        footer.add(turnPlayer);
        window2.add(footer, BorderLayout.SOUTH);

        //Listener para la tecla Escape
        window2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Verificar si la tecla presionada es Escape
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gameMenu();
                }
            }
        });
        window2.setFocusable(true);
        window2.requestFocusInWindow(); // Solicitar enfoque para window2
        window2.setVisible(true);
    }

    // Clase para crear un JPanel con un fondo de imagen (mainWindow, playerSetup, TERRITORIOS)
    static class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String image) {
            // Cargar la imagen de fondo 
            URL imageURL = getClass().getResource(image);
            if (imageURL != null) {
                backgroundImage = new ImageIcon(imageURL).getImage();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo con las dimensiones del JPanel
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    //Crea el Mapa de ejercitos
    public static void createMap(Map map) {
        mapArmys = new JPanel(new GridLayout(Map.MAP_SIZE, Map.MAP_SIZE, 5, 5));
        mapArmys.setOpaque(false);
        //Llama al metodo createBoardArmys para crear el tablero
        map.createBoardArmys(players.get(0).getMyKingdom(), players.get(1).getMyKingdom());
        
        //Configura los botones y le asigna un ActionListener
        for (JButton[] row : map.getBoardArmys()) {
            for (JButton button : row) {
                button.setPreferredSize(new Dimension(5, 5));
                button.addActionListener(e -> interaction(button, map, "Army"));
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        infoMilitary(button, "Army");
                    }
                });
                mapArmys.add(button);
            }
        }
    }

    //Se encarga del movimiento de los ejercitos y soldados, con restriciones
    public static void interaction(JButton now, Map map, String type){
        //Solo permite elegir una unidad del reino del jugador
        if(then == null && (Military)now.getClientProperty(type) != null && ((Military)now.getClientProperty(type)).getTeam() == player){
            then = now;
            now.setBorder(new LineBorder(Color.WHITE, 2));
        //Permite deseleccionar la unidad
        }else if(then == now){
            then = null;
            now.setBorder(new LineBorder(Map.COLORS.get(((Military)now.getClientProperty(type)).getColor()), 2));
        }else if(then != null){
            //Permite cambiar la seleccion hacia otra unidad del mismo reino
            if ((Military)now.getClientProperty(type) != null && ((Military)now.getClientProperty(type)).getTeam() == player){
                then.setBorder(new LineBorder(Map.COLORS.get(((Military)then.getClientProperty(type)).getColor()), 2));
                now.setBorder(new LineBorder(Color.WHITE, 2));
                then = now;
            }
            int ra = (int)then.getClientProperty("r");
            int ca = (int)then.getClientProperty("c");
            int rn = (int)now.getClientProperty("r");
            int cn = (int)now.getClientProperty("c");
            if((Math.abs(ra-rn)==1 && Math.abs(ca-cn)==0) || (Math.abs(ra-rn)==0 && Math.abs(ca-cn)==1)){
                //Permite mover la unidad hacia una casilla vacia
                if((Military)now.getClientProperty(type) == null){
                    now.putClientProperty(type, then.getClientProperty(type));
                    now.setIcon(then.getIcon());
                    now.setHorizontalTextPosition(SwingConstants.CENTER);
                    now.setVerticalTextPosition(SwingConstants.CENTER);
                    now.setBorder(new LineBorder(Map.COLORS.get(((Military)then.getClientProperty(type)).getColor()), 2));
                    Military military = (Military)now.getClientProperty(type);
                    military.setRow(rn);
                    military.setColumn(cn);
        
                    then.setIcon(null);
                    then.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
                    then.putClientProperty(type, null);
                    then = null;
                    player = (player%2)+1;
                    changeTurn(player);
                //Accion al momento de enfretar unidades de diferentes reinos
                }else if (((Military)now.getClientProperty(type)).getTeam() != player){
                    //Ejercito vs ejercito
                    if(now.getClientProperty(type) instanceof Army){
                        armysInWar = new ArrayList<JButton>();
                        armysInWar.add(then);
                        armysInWar.add(now);
                        metricOrClassic(now, type);
                    //Soldado vs soldado
                    } else {
                        war(now, map);
                        player = (player%2)+1;
                        changeTurn(player);
                    }
                }
            }
        }
        window2.requestFocusInWindow(); // Solicitar enfoque para window2
    }

    //Cambia el turno del jugador en el panel
    public static void changeTurn(int player){
        turnPlayer.setText("Turno: Player " + player);
    }

    //Muestra una ventana emergente para escoger la modalidad de la guerra de ejercitos (metrica logica / juego clasico)
    public static void metricOrClassic(JButton now, String type){
        //Configuracion de la ventana
        JFrame metricOrClassic = new JFrame("Elegir Modalidad");
        metricOrClassic.setSize(300, 190);
        metricOrClassic.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        metricOrClassic.setLocationRelativeTo(null);
        metricOrClassic.setResizable(false);

        //Imagen de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        metricOrClassic.setContentPane(backgroundImage);
        
        // Crear un panel para organizar los botones en forma de columna
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        //CREACION DE BOTONES Y SUS ACCIONES

        //Boton para volver al menu principal
        JButton button1 = new JButton("Metrica Logica");
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setForeground(Color.WHITE);
        button1.setBackground(colorButtons);
        button1.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setMaximumSize(new Dimension(200, 30));
        button1.addActionListener(e -> {
            metricOrClassic.dispose();
            metricLogic((Army)then.getClientProperty(type), (Army)now.getClientProperty(type), map);
            then = null;
            player = (player%2)+1;
            changeTurn(player);
        });
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para crear un nuevo juego y desaparecer el actual
        JButton button2 = new JButton("Juego Clasico");
        button2.setForeground(Color.WHITE);
        button2.setBackground(colorButtons);
        button2.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setMaximumSize(new Dimension(200, 30));
        button2.addActionListener(e -> {
            metricOrClassic.dispose();
            confrontation((Army)then.getClientProperty(type), (Army)now.getClientProperty(type), map);
        });
        panel.add(button2);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Agregar espacio en los bordes del panel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Agregar el panel a la ventana
        metricOrClassic.add(panel, BorderLayout.CENTER);
        metricOrClassic.setVisible(true);
    }
    
    //Modalidad de guerra de ejercitos por metrica logica
    private static void metricLogic(Army ally, Army enemy, Map map) {
        Random random = new Random();
        //Crea valores que seran utilizados
        double total = ally.getTotalLife() + enemy.getTotalLife();
        double probAlly = Math.round(ally.getTotalLife()/total*10000)/100.0;
        double probEnemy = Math.round(enemy.getTotalLife()/total*10000)/100.0; 
        
        String metricLogic = "";
        metricLogic += "Ejercito "+ally.getArmyNumber()+": "+ally.getKingdom()+": "+ally.getTotalLife()+"   "+probAlly+"% de probabilidad de victoria";
        metricLogic += "\nEjercito "+enemy.getArmyNumber()+": "+enemy.getKingdom()+": "+enemy.getTotalLife()+"   "+probEnemy+"% de probabilidad de victoria";
        Army winner;
        double result = Math.round(random.nextDouble(10000))/100.0;
        if (result < probAlly) {
            winner = ally;
            enemy.die();
        } else {
            winner = enemy;
            ally.die();
        }
        metricLogic += "\n\nEl ganador es el ejercito " + winner.getArmyNumber() + " de: " + winner.getKingdom() + "."
                            +"\nYa que se sumo los niveles de vida, se repartio un porcentajes y eligio un numero aleatorio."
                            +"\nAleatorio generado: " + result;
        resultSoldierWar.setText(metricLogic);
        winningArmy();
    }

    //Crea el mapa de soldados - en caso de elegir modalidad de juego clasico
    public static void confrontation(Army ally, Army enemy, Map map){
        mapSoldiers = new JPanel(new GridLayout(Map.MAP_SIZE, Map.MAP_SIZE, 5, 5));
        mapSoldiers.setOpaque(false);
        map.createBoardSoldiers(ally, enemy);
        then = null;
        for (JButton[] row : map.getBoardSoldiers()){
            for (JButton button : row){
                button.setPreferredSize(new Dimension(5, 5));
                button.addActionListener(e -> interaction(button, map, "Soldier"));
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        infoMilitary(button, "Soldier");
                    }
                });
                mapSoldiers.add(button);
            }
        }
        mapSpace.removeAll();
        mapSpace.add(mapSoldiers, BorderLayout.CENTER);
        window2.revalidate();
        window2.repaint();
    }

    //Muestra los datos de los ejercitos y soldados en el panel
    private static void infoMilitary(JButton button, String type) {
        Military military = (Military) button.getClientProperty(type);
        if (military != null)
            description.setText(military.toString());
        else 
            description.setText("");
    }

    //Se encarga de simular el enfrentamiento de dos soldados
    public static void war(JButton now, Map map){
        Soldier ally = (Soldier)then.getClientProperty("Soldier");
        Soldier enemy = (Soldier)now.getClientProperty("Soldier");
        int liveAlly = 0, liveEnemy = 0;
        //Vida a considerar en caso de enfrentamiento entre tipos de unidades
        for(int i = 0; i < 2; i++){
            if(ally instanceof Knight && enemy instanceof Archer){
                if (ally instanceof KnightFranco || ally instanceof KnightMoro)
                    liveAlly++;
                liveAlly++;
            } else if(ally instanceof Knight && enemy instanceof Spearman){
                liveEnemy++;
            } else if(ally instanceof Archer && enemy instanceof Spearman){
                liveAlly++;
            } else if(ally instanceof Knight && enemy instanceof Swordsman){
                liveAlly++;
            } else if(ally instanceof Swordsman && enemy instanceof Spearman){
                if (ally instanceof SwordsmanRoyal || ally instanceof SwordsmanConqueror || ally instanceof SwordsmanTeutonic)
                    liveAlly++;
                liveAlly++;
            } else if(ally instanceof Swordsman && (enemy instanceof SwordsmanRoyal || enemy instanceof SwordsmanConqueror || enemy instanceof SwordsmanTeutonic)){
                liveEnemy++;
            } else if(ally instanceof Knight && (enemy instanceof KnightFranco || enemy instanceof KnightMoro)){
                liveEnemy++;
            }
            Soldier tempS = ally;
            ally = enemy;
            enemy = tempS;
            int tempL = liveAlly;
            liveAlly = liveEnemy;
            liveEnemy = tempL;
        }
        //Calculo de probabilidad de victoria
        Random random = new Random();
        double total = ally.getCurrentLife() + liveAlly + enemy.getCurrentLife() + liveEnemy;
        double probAlly = Math.round((ally.getCurrentLife() + liveAlly)/total*1000)/10.0;
        double probEnemy = Math.round((enemy.getCurrentLife() + liveEnemy)/total*1000)/10.0;
        
        String resultWar = "Ultimo enfrentamiento:\n";
        resultWar += "\nProbabilidad de victoria:\n\n"+ally.getName()+": "+probAlly+"%\n"+enemy.getName()+": "+probEnemy+"%";
        Soldier winner;
        
        //Cambios en el tablero segun el ganador
        double result = Math.round(random.nextDouble(10000))/100.0;
        if (result < probAlly) {
            winner = ally;
            ally.setCurrentLife(ally.getCurrentLife()+1);
            now.putClientProperty("Soldier", then.getClientProperty("Soldier"));
            now.setBorder(new LineBorder(Map.COLORS.get(((Soldier)then.getClientProperty("Soldier")).getColor()), 2));
            now.setIcon(then.getIcon());
            now.setHorizontalTextPosition(SwingConstants.CENTER);
            now.setVerticalTextPosition(SwingConstants.CENTER);

            ally.setRow(enemy.getRow());
            ally.setColumn(enemy.getColumnInt());
            enemy.die();
        } else {
            winner = enemy;
            enemy.setCurrentLife(enemy.getCurrentLife()+1);
            ally.die();
        }
        then.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        then.setIcon(null);
        then.putClientProperty("Soldier", null);
        then = null;

        //Resultado
        resultWar += "\n\nEl ganador es la unidad "+winner.getName()+"\n\nAleatorio generado: " + result;
        resultSoldierWar.setText(resultWar);
        winning(map, "Army");
    }

    //Se encarga de determinar si existe algun ganador para reinos y ejercitos
    public static void winning(Map map, String type){
        
        //Creacion de listas
        ArrayList<Coalition> coalitions = (type.equals("Kingdom"))? map.getKingdoms() : map.getArmys();
        ArrayList<Coalition> control = new ArrayList<Coalition>();
        
        //Verifica unidades vivas
        for (int i = 0; i < coalitions.size(); i++)
            for (int j = 0; j < coalitions.get(i).getMyMilitaries().size(); j++)
                if (coalitions.get(i).getMyMilitaries().get(j).getLive()){
                    control.add(coalitions.get(i));
                    break;
                }
        String result;

        //Determina el ganador y actualiza la interfaz
        if (control.size() == 1){
            if (type.equals("Kingdom")){
                result = "El ganador es el Reino de "+((Kingdom)control.get(0)).getKingdom();
                JOptionPane.showMessageDialog(window2, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                finishWindow();
            } else {
                //Ejecuta las acciones en caso gane un ejercito
                result = "El ganador es el "+((Army)control.get(0)).getName()+" de "+((Army)control.get(0)).getKingdom();
                ((Army)control.get(0)).victoryBonus();
                mapSpace.removeAll();
                mapSpace.add(mapArmys, BorderLayout.CENTER);
                window2.revalidate();
                window2.repaint();
                //Cambio de turno
                if (player == ((Army)map.getArmys().get(1)).getTeam()) {
                    player = (player%2)+1;
                    changeTurn(player);
                }
                winningArmy();
                resultSoldierWar.setText("\n"+((Army)map.getArmys().get(0)).getName()+" VS "+((Army)map.getArmys().get(1)).getName()+"\n\n"+result);
            }
        }
    }

    //Se encarga de hacer los cambios necesarios en el Mapa de ejercitos cuando un ejercito le gana a otro
    public static void winningArmy(){
        for (int i = 0; i < armysInWar.size(); i++){
            //Obtiene el ejercito actual
            Army army = (Army)armysInWar.get(i).getClientProperty("Army");
            //Verifica que este vivo
            if (army.getLive()){
                //Acciones 
                if (i == 0){
                    armysInWar.get(1).putClientProperty("Army", army);
                    armysInWar.get(1).setBorder(new LineBorder(Map.COLORS.get(((Army)armysInWar.get(0).getClientProperty("Army")).getColor()), 2));
                    armysInWar.get(1).setIcon(armysInWar.get(0).getIcon());
                    army.setRow((int)armysInWar.get(1).getClientProperty("r"));
                    army.setColumn((int)armysInWar.get(1).getClientProperty("c"));
                }
                //Configura a los ejercitos ganadores
                armysInWar.get(0).setText(null);
                armysInWar.get(0).setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
                armysInWar.get(0).putClientProperty("Army", null);
                armysInWar.get(0).setIcon(null);
            }
        }
        winning(map, "Kingdom"); 
    }

    //Muestra una ventana emergente para escoger entre (Regresar al menu principal, Menu del Juego y Obtener datos del Juego)
    public static void finishWindow(){
        //Configuracion de la ventana
        JFrame finishWindow = new JFrame("Partida finalizada");
        finishWindow.setSize(300, 240);
        finishWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        finishWindow.setLocationRelativeTo(null);
        finishWindow.setResizable(false);

        //Imagen de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        finishWindow.setContentPane(backgroundImage);
        
        // Crear un panel para organizar los botones en forma de columna
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(250, 350));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(20));

        //CREACION DE BOTONES Y SUS ACCIONES

        //Boton para volver al menu principal
        JButton button1 = new JButton("Menu Principal");
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setForeground(Color.WHITE);
        button1.setBackground(colorButtons);
        button1.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setMaximumSize(new Dimension(200, 30));
        button1.addActionListener(e -> {
            window2.dispose();
            mainWindow(finishWindow);
        });
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para crear un nuevo juego y desaparecer el actual
        JButton button2 = new JButton("Nuevo Juego");
        button2.setForeground(Color.WHITE);
        button2.setBackground(colorButtons);
        button2.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setMaximumSize(new Dimension(200, 30));
        button2.addActionListener(e -> {
            window2.dispose();
            playerSetupWindow(finishWindow);
        });
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para obtener los datos del juego mediante un txt
        JButton button3 = new JButton("Datos del Juego");
        button3.setForeground(Color.WHITE);
        button3.setBackground(colorButtons);
        button3.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setMaximumSize(new Dimension(200, 30));
        button3.addActionListener(e -> ExportFile.fileWriter(players, map));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Agregar espacio en los bordes del panel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Agregar el panel a la ventana
        finishWindow.add(panel, BorderLayout.CENTER);
        finishWindow.setVisible(true);
    }

    ////////////////////////////////////////////////////
    //Ventana de menu de pausa
    public static void gameMenu(){
        
        //Configuraciones de la ventana
        JFrame windowGameMenu = new JFrame("Opciones");
        windowGameMenu.setSize(300, 350);
        windowGameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windowGameMenu.setLocationRelativeTo(null);
        windowGameMenu.setResizable(false);

        //Colocar fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        windowGameMenu.setContentPane(backgroundImage);

        // Crear un panel para organizar los botones en forma de columna
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(250, 350));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout en eje Y

        panel.add(Box.createVerticalStrut(20));

        //CREACION DE BOTONES Y SUS ACCIONES
        //Boton para voler al menu principal 
        JButton button1 = new JButton("Menu Principal");
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setForeground(Color.WHITE);
        button1.setBackground(colorButtons);
        button1.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setMaximumSize(new Dimension(200, 30));
        button1.addActionListener(e -> {
            window2.dispose();
            mainWindow(windowGameMenu);
        });
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para abandonar la partida 
        JButton button3 = new JButton("Renunciar");
        button3.setForeground(Color.WHITE);
        button3.setBackground(colorButtons);
        button3.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setMaximumSize(new Dimension(200, 30));
        button3.addActionListener(e -> {
            windowGameMenu.dispose();
            finishWindow();
        });
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para guardar la partida actual
        JButton button4 = new JButton("Guardar partida");
        button4.setForeground(Color.WHITE);
        button4.setBackground(colorButtons);
        button4.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        button4.setMaximumSize(new Dimension(200, 30));
        button4.addActionListener(e -> saveGame(windowGameMenu));
        panel.add(button4);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para cargar una partida guardada
        JButton button5 = new JButton("Cargar partida");
        button5.setForeground(Color.WHITE);
        button5.setBackground(colorButtons);
        button5.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button5.setAlignmentX(Component.CENTER_ALIGNMENT);
        button5.setMaximumSize(new Dimension(200, 30));
        button5.addActionListener(e -> loadGame(windowGameMenu));
        panel.add(button5);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para ver los datos del juego
        JButton button6 = new JButton("Datos del Juego");
        button6.setForeground(Color.WHITE);
        button6.setBackground(colorButtons);
        button6.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button6.setAlignmentX(Component.CENTER_ALIGNMENT);
        button6.setMaximumSize(new Dimension(200, 30));
        button6.addActionListener(e -> ExportFile.fileWriter(players, map));
        panel.add(button6);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //Boton para cerrar la ventana emergente
        JButton button = new JButton("Cancelar");
        button.setForeground(Color.WHITE);
        button.setBackground(colorButtons);
        button.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 30));
        button.addActionListener(e -> windowGameMenu.dispose());
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Agregar espacio en los bordes del panel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Agregar el panel a la ventana
        windowGameMenu.add(panel, BorderLayout.CENTER);
        windowGameMenu.setVisible(true);
    }
    
    //Metodo para guardar la partida actual
    public static void saveGame(JFrame parent){
        //Configuracion de la ventana
        JFrame windowSaveGame = new JFrame("Guardar partida");
        windowSaveGame.setSize(250, 150);
        windowSaveGame.setLocationRelativeTo(parent);
        windowSaveGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windowSaveGame.setLayout(new FlowLayout());

        // Crear componentes
        JLabel lblNombre = new JLabel("Nombre de la partida:");
        JTextField txtNombre = new JTextField(15);
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBackground(colorButtons);
        txtNombre.setBackground(new Color(238,227,207));    

        //Imagen de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        windowSaveGame.setContentPane(backgroundImage);

        // Accion al presionar el boton de guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado y cerrar la ventana
                Object[] game = {players, map};
                InteractionBD.saveGame(txtNombre.getText(), game);
                System.out.println(txtNombre.getText());
                windowSaveGame.dispose();
            }
        });

        // Agregar componentes a la ventana
        windowSaveGame.add(lblNombre);
        windowSaveGame.add(txtNombre);
        windowSaveGame.add(btnGuardar);
        windowSaveGame.setVisible(true);
    }

    //Metodo para cargar una partida ya guardada en la base de datos
    public static void loadGame(JFrame parent){
        JFrame windowLoadGame = new JFrame("Ventana con Botones");
        windowLoadGame.setSize(300, 400);
        windowLoadGame.setLocationRelativeTo(parent);
        windowLoadGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window1.setLocationRelativeTo(null);
        
        // Imagen de fondo
        ImagePanel backgroundImage = new ImagePanel("src/image_setupPlayer.jpg");
        windowLoadGame.setContentPane(backgroundImage);

        // Crear botones con etiquetas dadas
        ArrayList<String> etiquetas = InteractionBD.getAllSavedGames();

        // Crear un panel para organizar los botones en forma de columna
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout en eje Y

        // Agregar botones al panel
        for (String etiqueta : etiquetas) {
            JButton boton = new JButton(etiqueta);
            boton.setBackground(colorButtons);
            boton.setForeground(Color.WHITE);
            boton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el boton en el eje X
            boton.setMaximumSize(new Dimension(200, 25)); // Establecer el tamaño máximo deseado
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica para cada boton
                    Object[] game = InteractionBD.loadGame(etiqueta);
                    // Verificar si el objeto es una instancia de ArrayList<Player>
                    if (game[0] instanceof ArrayList<?>) {
                        ArrayList<?> playersObject = (ArrayList<?>) game[0];
                    
                        // Verificar que los elementos sean instancias de Player
                        if (!playersObject.isEmpty() && playersObject.get(0) instanceof Player) {
                            @SuppressWarnings("unchecked") // Se suprime la advertencia debido a la verificación anterior
                            ArrayList<Player> castedPlayers = (ArrayList<Player>) playersObject;
                            players = castedPlayers;
                            map = (Map) game[1];
                            parent.dispose();
                            if (window2 != null) {
                                window2.dispose();
                            }
                            startGame(windowLoadGame);
                        } else {
                            // Manejar el caso donde los elementos no son instancias de Player
                            System.err.println("Error: Los elementos de la lista no son instancias de Player.");
                        }
                    } else {
                        // Manejar el caso donde el objeto no es una instancia de ArrayList<?>
                        System.err.println("Error: El objeto no es una instancia de ArrayList<?>");
                    }
                }
            });
            panel.add(boton);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Agregar espacio en los bordes del panel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Agregar el panel a la ventana
        windowLoadGame.add(panel, BorderLayout.CENTER);
        windowLoadGame.setVisible(true);
    }
}