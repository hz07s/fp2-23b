import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VideoJuego {
  static boolean turnA = true;
  public static JButton buttonSel = null;
  public static void main(String[] args) {
    startGame();
  }

  // Iniciar programa
  public static void startGame() {

    // Window menu settings
    JFrame window1 = new JFrame("Medieval War Game");
    window1.setSize(600, 720);
    window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window1.setLocationRelativeTo(null);
    window1.setResizable(false);

    // Window menu content

      // Top
    JLabel w1Label01 = new JLabel("Bienvenido al Juego");
    w1Label01.setFont(new Font ("Courier New", Font.BOLD, 24));
    w1Label01.setHorizontalAlignment(SwingConstants.CENTER);
    w1Label01.setBorder(new EmptyBorder(30, 10, 10, 10));
    window1.add(w1Label01, BorderLayout.NORTH);
    
      //Image
    ImageIcon w1Icon01 = new ImageIcon("fase03\\lab22\\src\\01game.png");
    JLabel w1JLabel02 = new JLabel(w1Icon01);
    w1JLabel02.setSize(400,400);
    window1.add(w1JLabel02, BorderLayout.CENTER);
    
      //Buttons
    JPanel w1JPanel01 = new JPanel();
    w1JPanel01.setLayout(new BoxLayout(w1JPanel01, BoxLayout.Y_AXIS));
    w1JPanel01.setBorder(new EmptyBorder(20, 10, 20, 10));
    JButton w1Button01 = new JButton("   Juego 1 vs 1    ");
    //JButton w1Button02 = new JButton("Juego Personalizado");
    JButton w1Button03 = new JButton("       Salir       ");
    Font w1Font01 = new Font("Courier New", Font.BOLD, 14);
    w1Button01.setFont(w1Font01);
    //w1Button02.setFont(w1Font01);
    w1Button03.setFont(w1Font01);
    Dimension w1Dimension01 = new Dimension(200, 50);
    w1Button01.setPreferredSize(w1Dimension01);
    //w1Button02.setPreferredSize(w1Dimension01);
    w1Button03.setPreferredSize(w1Dimension01);
    w1Button01.setHorizontalAlignment(SwingConstants.CENTER);
    //w1Button02.setHorizontalAlignment(SwingConstants.CENTER);
    w1Button03.setHorizontalAlignment(SwingConstants.CENTER);
    w1Button01.addActionListener(e -> game1vs1(window1));
    //w1Button02.addActionListener(e -> gameCustom(window1));
    w1Button03.addActionListener(e -> System.exit(0));
    w1JPanel01.add(Box.createRigidArea(new Dimension(0, 10)));
    w1JPanel01.add(w1Button01);
    w1JPanel01.add(Box.createRigidArea(new Dimension(0, 10)));
    //w1JPanel01.add(w1Button02);
    w1JPanel01.add(Box.createRigidArea(new Dimension(0, 10)));
    w1JPanel01.add(w1Button03);
    w1JPanel01.add(Box.createRigidArea(new Dimension(0, 10)));
    JPanel w1JPanel02 = new JPanel();
    w1JPanel02.setLayout(new BoxLayout(w1JPanel02, BoxLayout.X_AXIS));
    w1JPanel02.add(Box.createHorizontalGlue());
    w1JPanel02.add(w1JPanel01);
    w1JPanel02.add(Box.createHorizontalGlue());
    window1.add(w1JPanel02, BorderLayout.SOUTH);

    // Visible
    window1.setVisible(true);
  }

  // Game 1vs1
  public static void game1vs1(JFrame w1) {
    // Window 1 dispose
    w1.dispose();

    // Window 1vs1 settings
    JFrame window2 = new JFrame("Medieval War Game 1 vs 1");
    window2.setSize(1280, 800);
    window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window2.setLocationRelativeTo(null);
    window2.setResizable(false);
    
    //Create objects
    Mapa map = Mapa.getInstance();
    map.setRandomMapa();
    Team tA = new Team(map, 'A');
    Team tB= new Team(map, 'B');

    //Window North
    JPanel w2JPanel01 = new JPanel(new FlowLayout());
    w2JPanel01.setPreferredSize(new Dimension(1280,50));
    JLabel w2JLabel01 = new JLabel("Turno: A");
    w2JLabel01.setFont(new Font("Courier New", Font.BOLD, 30));
    JButton w2Button01 = new JButton("Cambiar Turno");
    w2Button01.setBackground(Color.WHITE);
    w2Button01.addActionListener(e -> {
      turnA = changeTurn(turnA);
      // Add Threads 
      w2JLabel01.setText(turnA ? "Turno: A" : "Turno: B");
    });
    w2JPanel01.add(w2JLabel01);
    w2JPanel01.add(Box.createHorizontalStrut(20)); 
    w2JPanel01.add(w2Button01);
    window2.add(w2JPanel01, BorderLayout.NORTH);
  
    // Window Center (board)
    JPanel w2JPanel02 = createJPanelC(map.getBoard(), tA, tB, map);
    window2.add(w2JPanel02, BorderLayout.CENTER);

    // Window West
    JPanel w2JPanel03 = creatPanelWE(tA.getTeams());
    w2JPanel03.setPreferredSize(new Dimension(265,800));
    window2.add(w2JPanel03, BorderLayout.WEST);

    // Window East
    JPanel w2JPanel04 = creatPanelWE(tB.getTeams());
    w2JPanel04.setPreferredSize(new Dimension(265,800));
    window2.add(w2JPanel04, BorderLayout.EAST);

    // Window South
    JPanel w2JPanel05 = new JPanel();
    w2JPanel05.setPreferredSize(new Dimension(1280,50));
    window2.add(w2JPanel05, BorderLayout.SOUTH);

    // Show Window2
    window2.setVisible(true);
  }

  public static JPanel createJPanelC(Ejercito[][] ejS, Team a, Team b, Mapa map){
    JPanel xxJPanel01 = new JPanel(new GridLayout(10, 10, 5, 5));
    for (int r = 0; r < 10; r++) {
      for (int c = 0; c < 10; c++) {
        Ejercito sP = ejS[r][c];
        JButton xxButton01 = new JButton();
        xxButton01.setPreferredSize(new Dimension(5, 5));
        if (sP != null) {
          xxButton01.putClientProperty("s", sP.getSumLifeLevel());
          xxButton01.putClientProperty("p", sP.getPosition());
          xxButton01.setText(sP.getId());
          xxButton01.addActionListener(e -> armyClick(xxButton01, xxJPanel01,a , b, map));
          if (sP.getName() == 'A'){
            xxButton01.setBackground(new Color(173, 216, 230));
          }
          else if (sP.getName() == 'B'){
            xxButton01.setBackground(new Color(255, 182, 193));
          }
        } else 
          xxButton01.setBackground(Color.WHITE);
        xxJPanel01.add(xxButton01);
      }
    }
    return xxJPanel01;
  }

  public static JPanel creatPanelWE(ArrayList<Ejercito> ej) {
    JPanel panelWE = new JPanel();
    panelWE.setLayout(new BoxLayout(panelWE, BoxLayout.Y_AXIS));

    for (Ejercito s : ej) {
      JButton soldierButton = new JButton();
      soldierButton.setLayout(new BorderLayout());
      soldierButton.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.BLACK),
        BorderFactory.createEmptyBorder(10, 20, 10, 20)
      ));
      soldierButton.setBackground(Color.WHITE);
      JLabel soldierLabel = new JLabel(s.getKingdom() + " - HP: " + s.getSumLifeLevel());
      soldierLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
      soldierButton.add(soldierLabel, BorderLayout.CENTER);
      panelWE.add(soldierButton);
      panelWE.add(Box.createRigidArea(new Dimension(0, 10)));
    }
    return panelWE;
  }

  public static void armyClick(JButton buttonClicked, JPanel bo, Team a, Team b, Mapa map){
    if(buttonSel == null)
      buttonSel = buttonClicked;
    else {
      JButton attacker = buttonSel;
      JButton attacked = buttonClicked;

      fight(bo, attacker, attacked, a, b, map);
      buttonSel = null;
    }
  }

  public static boolean changeTurn(boolean turnA){
    return !turnA;
  }

  public static void fight(JPanel game, JButton attacker, JButton attacked, Team a, Team b, Mapa m){
    int kerH = (int)attacker.getClientProperty("s");
    int kedH = (int)attacked.getClientProperty("s");
    
    //metrica especial
    Random random = new Random();
    double rand = random.nextDouble() * (kerH + kedH);
    
    double probA = ((double) kerH / (kerH + kedH)) * 100;
    double probB = ((double) kedH / (kerH + kedH)) * 100;

    if (rand < probA){
      //attacker.setVisible(false);
      attacker.setBackground(Color.WHITE);
      attacker.setText(null);
      int coords = (int)attacker.getClientProperty("p");
      attacker.putClientProperty("s", null);
      attacker.putClientProperty("p", null);
      m.editDeleteBoard(coords / 10, coords % 10);
      JOptionPane.showMessageDialog(null,
      "Gano el Ejercito atacante  ("+ (turnA ? "A" : "B")  + ")          \n\n Ejercito atacante:\n\t\t" + probA + 
      "% victoria\n Ejercito atacado:\n\t\t" + probB + "% de victoria\n\n El resultado aleatorio generado fue:\n\t\t" + 
      rand,
      "Batalla", 
      JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      //attacker.setVisible(false);
      attacked.setBackground(Color.WHITE);
      attacked.setText(null);
      int coords = (int)attacked.getClientProperty("p");
      attacked.putClientProperty("s", null);
      attacked.putClientProperty("p", null);
      m.editDeleteBoard(coords / 10, coords % 10);
      JOptionPane.showMessageDialog(null,
      "Gano el Ejercito atacado  ("+ (turnA ? "A" : "B")  + ")          \n\n Ejercito atacante:\n\t\t" + probA + 
      "% victoria\n Ejercito atacado:\n\t\t" + probB + "% de victoria\n\n El resultado aleatorio generado fue:\n\t\t" + 
      rand,
      "Batalla", 
      JOptionPane.INFORMATION_MESSAGE);
    }

    if (endWar(m.getBoard())){
      showWinner(m.getBoard());
    }
  }

  public static boolean checkBonusHealth(){
    return true;
  }

  public static boolean endWar(Ejercito[][] bo){
    int a = 0;
    int b = 0;
    for (Ejercito so[] : bo){
      for (Ejercito s: so) {
        if (s != null){
          a += s.getName() == ('A') ? 1 : 0;
          b += s.getName() == ('B') ? 1 : 0;
        }
      }
    }
    return a == 0 || b == 0;
  }

  public static void showWinner(Ejercito [][] bo){
    int a = 0;
    int b = 0;
    for (Ejercito so[] : bo){
      for (Ejercito s: so) {
        if (s != null){
          a += s.getName() == ('A') ? 1 : 0;
          b += s.getName() == ('B') ? 1 : 0;
        }
      }
    }
    String ejWin = a > b ? "A" : "B";
    JOptionPane.showMessageDialog(null, "Gano el Equipo " + ejWin, "Ganador", 
    JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }

  // Game custom
  public static void gameCustom(JFrame w1) {
    //Empty for now
  }
}
