package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Object.Boid;

public class MainPanel extends JPanel implements Runnable {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    private boolean running = true;

    private static java.util.List<Boid> boids = new ArrayList<>();

    MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        // Initialize boids
        for(int i = 0; i < 100; i++){
            boids.add(new Boid(Math.random() * WIDTH, Math.random() * HEIGHT));
        }
    }

    @Override
    public void run() {
        while (running) {
            update();  // Update boids
            repaint(); // Repaint the panel

            try {
                Thread.sleep(16); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        for (Boid boid : boids) {
            g.fillOval((int) boid.getX(), (int) boid.getY(), 10, 10); // Draw boid as a circle
        }
    }

    public void update() {
        for (Boid boid : boids) {

            boid.flock(boids);

            boid.updateShape();

            boid.checkWindowCollision();

            boid.update();

            System.out.println("Program loop: running...");

        }
    }

}