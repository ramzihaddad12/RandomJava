package dungeon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */

public class DungeonGraphicView extends JFrame implements IView {
  private JButton quitButton;
  private DungeonPanel dungeonPanel;
  private JTextArea playerDescription;
  private JTextArea roomDescription;
  private DungeonSwingController controller;
  private JMenuItem m1;
  private JMenuItem m2;
  private JMenuItem m3;
  private JMenuItem m4;
  private JMenuItem m5;
  private JMenuItem m6;
  private InputBox frame;

  private int rows;
  private int columns;

  public DungeonGraphicView() {
    super();
    frame = new InputBox();


//    InputBox frame = new InputBox();
//
//    int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
//    int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
//    int inteconnectivity = getInput(frame,
//            "What is the interconnectivity desired for your dungeon? ");
//    int percentage = getInput(frame,
//            "What is the the percentage of caves with treasure desired for your dungeon? ");
//    int numOfMonsters = getInput(frame,
//            "What is the the number of monsters desired for your dungeon? ");
//    int input = JOptionPane.showConfirmDialog(null,
//            "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
//    this.controller.instantiateModel(rows, columns, inteconnectivity,
//            percentage, numOfMonsters, input);
//    m1.setText("Number of rows: " + rows);
//    m2.setText("Number of columns: " + columns);
//    m3.setText("Interconnectivity: " + inteconnectivity);
//    m4.setText("Wrapping: " + (input == 0));
//    m5.setText("Percentage of caves with treasure: " + percentage);
//    m6.setText("Number of monsters: " + numOfMonsters);

//    super();
//    this.setTitle("Dungeon!");
//    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    this.setLayout(new BorderLayout());
//    dungeonPanel = new DungeonPanel();
//
//    this.setLayout(new BorderLayout());
//    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    setPreferredSize(new Dimension(500, 500));
//    JScrollPane scrollPane = new JScrollPane(dungeonPanel);
//    scrollPane.setHorizontalScrollBarPolicy(
//            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//    scrollPane.setVerticalScrollBarPolicy(
//            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//    this.add(scrollPane);
//    JPanel area = new JPanel();
//    area.setPreferredSize(new Dimension(100, 100));
//
//    playerDescription = new JTextArea();
//    playerDescription.setEditable(false);
//    area.add(playerDescription, BorderLayout.SOUTH);
//    roomDescription = new JTextArea();
//    roomDescription.setEditable(false);
//    area.add(roomDescription, BorderLayout.NORTH);
//    area.isVisible();
//    this.add(area, BorderLayout.SOUTH);
//    quitButton = new JButton("Quit");
//    quitButton.addActionListener(e -> System.exit(0));
//
//
//    m1 = new JMenuItem("Number of rows: ");
//    m2 = new JMenuItem("Number of columns: ");
//    m3 = new JMenuItem("Interconnectivity: ");
//    m4 = new JMenuItem("Wrapping: ");
//    m5 = new JMenuItem("Percentage of caves with treasure: ");
//    m6 = new JMenuItem("Number of monsters: ");
//    JMenu x = new JMenu("Game settings");
//    x.add(m1);
//    x.add(m2);
//    x.add(m3);
//    x.add(m4);
//    x.add(m5);
//    x.add(m6);
//    JMenuBar mb = new JMenuBar();
//    mb.add(x);
//    mb.add(quitButton);
//
//    JButton newGame = new JButton("New Game");
//    newGame.addActionListener(e -> this.controller.playGame());
//    mb.add(newGame);
//
//    JButton restarting = new JButton("Restart");
//    restarting.addActionListener(e -> this.controller.restartingWithSameModel());
//    mb.add(restarting);
//
//    this.add(mb, BorderLayout.PAGE_START);
//    this.setFocusable(true);
//    this.requestFocus();
//    this.pack();
  }

  @Override
  public int getDistance() {
    InputBox frame = new InputBox();

    int distance = getInput(frame, "What is the distance of the shot desired?");
    return distance;
  }

  @Override
  public void initializeGameMode() {

    this.setTitle("Dungeon!");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    dungeonPanel = new DungeonPanel(this.rows, this.columns);

    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(500, 500));
    JScrollPane scrollPane = new JScrollPane(dungeonPanel);
    scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(scrollPane);
    JPanel area = new JPanel();
    area.setPreferredSize(new Dimension(100, 100));

    playerDescription = new JTextArea();
    playerDescription.setEditable(false);
    area.add(playerDescription, BorderLayout.SOUTH);
    roomDescription = new JTextArea();
    roomDescription.setEditable(false);
    area.add(roomDescription, BorderLayout.NORTH);
    area.isVisible();
    this.add(area, BorderLayout.SOUTH);
    quitButton = new JButton("Quit");
    quitButton.addActionListener(e -> System.exit(0));


    m1 = new JMenuItem("Number of rows: ");
    m2 = new JMenuItem("Number of columns: ");
    m3 = new JMenuItem("Interconnectivity: ");
    m4 = new JMenuItem("Wrapping: ");
    m5 = new JMenuItem("Percentage of caves with treasure: ");
    m6 = new JMenuItem("Number of monsters: ");
    JMenu x = new JMenu("Game settings");
    x.add(m1);
    x.add(m2);
    x.add(m3);
    x.add(m4);
    x.add(m5);
    x.add(m6);
    JMenuBar mb = new JMenuBar();
    mb.add(x);
    mb.add(quitButton);

    JButton newGame = new JButton("New Game");
    newGame.addActionListener(e -> {
      this.initializeSetupMode();
      this.requestFocus();
    });
    mb.add(newGame);

    JButton restarting = new JButton("Restart");
    restarting.addActionListener(e -> {
      this.controller.restartingWithSameModel();
      this.requestFocus();
    });
    mb.add(restarting);

    this.add(mb, BorderLayout.PAGE_START);
    this.setFocusable(true);
    this.requestFocus();
    this.pack();

    this.addKeyBoardListener(this.controller);
    this.addClickListener(this.controller);
  }

  @Override
  public void addController(DungeonSwingController controller) {
    this.controller = controller;
    this.initializeGameMode();
  }

  public void initializeSetupMode() {
    int rows = getInput(frame, "What is the number of rows desired for your dungeon? ");
    int columns = getInput(frame, "What is the number of columns desired for your dungeon? ");
    int inteconnectivity = getInput(frame,
            "What is the interconnectivity desired for your dungeon? ");
    int percentage = getInput(frame,
            "What is the the percentage of caves with treasure desired for your dungeon? ");
    int numOfMonsters = getInput(frame,
            "What is the the number of monsters desired for your dungeon? ");
    int input = JOptionPane.showConfirmDialog(null,
            "Wrapping of the dungeon?", "Select an Option...",JOptionPane.YES_NO_OPTION);
    this.controller.instantiateModel(rows, columns, inteconnectivity,
            percentage, numOfMonsters, input);
    m1.setText("Number of rows: " + rows);
    m2.setText("Number of columns: " + columns);
    m3.setText("Interconnectivity: " + inteconnectivity);
    m4.setText("Wrapping: " + (input == 0));
    m5.setText("Percentage of caves with treasure: " + percentage);
    m6.setText("Number of monsters: " + numOfMonsters);

    this.rows = rows;
    this.columns = columns;
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setPlayerDescriptionText(String text) {
    this.playerDescription.setText(text);
  }

  @Override
  public void setRoomDescriptionText(String text) {
    this.roomDescription.setText(text);
  }

  @Override
  public void addKeyBoardListener(IDungeonController listener) {
    KeyAdapter keyListener = new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
          listener.handleKey(e);
      }
    };
    this.requestFocusInWindow();
    this.addKeyListener(keyListener);
    this.refresh();
  }

  @Override
  public void addClickListener(IDungeonController listener) {
    MouseAdapter clickHandler = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        listener.handleCellClick(e.getX(), e.getY());
      }
    };
    this.dungeonPanel.addMouseListener(clickHandler);
    this.refresh();
  }

  @Override
  public void setDungeonPanel(boolean[][] visited, IRoom[][] board, int[] playerLocation,
                              String playerDescription) {
    this.dungeonPanel.setNeededParameters(visited, board, playerLocation, playerDescription);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showInformationMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Information",JOptionPane.INFORMATION_MESSAGE);
  }

  private int getInput(InputBox frame, String displayMessage) {
    boolean gotValidRows = false;
    Integer rows = null;
    while (!gotValidRows) {
      String string = JOptionPane.showInputDialog(frame, displayMessage, 0);
      if (string == null) {
        System.exit(0);
      }
      try {
        rows = Integer.parseInt(string);
        gotValidRows = true;
      }
      catch (NumberFormatException e) {
        showErrorMessage("Please enter an integer");
        gotValidRows = false;
      }
    }
    return rows;
  }
}
