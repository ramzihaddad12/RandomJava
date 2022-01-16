package dungeon;

import java.awt.*;
import javax.swing.*;

public class InputBox extends JFrame {

  public InputBox() {
    getContentPane().setBackground(Color.DARK_GRAY);
    setTitle("Input Dialog in Frame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setSize(400, 300);
    getContentPane().setLayout(null);
  }

  private void closeIt(){
    this.getContentPane().setVisible(false);
    this.dispose();
  }
}