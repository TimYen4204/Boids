package Main;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    static final int HEIGHT = 600;
    static final int WIDTH = 600;

    JFrame frame = new JFrame();

        Window(){
            setTitle("Boids");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(WIDTH, HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
            setResizable(false);

            getContentPane().setBackground(Color.BLACK);
        }


}