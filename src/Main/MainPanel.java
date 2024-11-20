package Main;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Object.Boid;

public class MainPanel extends JPanel implements Runnable {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    private Thread game;
    private boolean running = true;

    private static java.util.List<Boid> boids = new ArrayList<>();

    MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Example boids for testing
        boids.add(new Boid(100, 100));
        boids.add(new Boid(200, 150));
        boids.add(new Boid(300, 300));
    }

    public void update() {
        for (Boid boid : boids) {
            boid.update(); // Update position
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerUpdate = 1000000000.0 / 60.0; // 60 FPS
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while (delta >= 1) {
                update();
                delta--;
            }

            repaint();

            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw each boid
        g.setColor(Color.WHITE);
        for (Boid boid : boids) {
            g.fillOval((int) boid.getX(), (int) boid.getY(), 10, 10); // Draw boid as a circle
        }
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Boids Simulation");
        MainPanel panel = new MainPanel();

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(panel).start();
    }

}
