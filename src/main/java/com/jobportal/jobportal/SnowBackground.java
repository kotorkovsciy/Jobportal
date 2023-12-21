/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jobportal.jobportal;

/**
 *
 * @author kotorkovsciy
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnowBackground extends JPanel {

    private static final int NUM_SNOWFLAKES = 50;
    private Snowflake[] snowflakes;
    private Timer timer;

    public SnowBackground() {
        initializeSnowflakes();
        initializeTimer();
    }

    private void initializeSnowflakes() {
        snowflakes = new Snowflake[NUM_SNOWFLAKES];
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            snowflakes[i] = new Snowflake();
        }
    }

    private void initializeTimer() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSnowflakes();
                repaint();
            }
        });
        timer.start();
    }

    private void moveSnowflakes() {
        for (Snowflake snowflake : snowflakes) {
            snowflake.move();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Отрисовка темного фона
        g2d.setColor(new Color(30, 30, 30));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Отрисовка снежинок
        g2d.setColor(Color.WHITE);
        for (Snowflake snowflake : snowflakes) {
            g2d.fillOval(snowflake.getX(), snowflake.getY(), 5, 5);
        }
    }

    private class Snowflake {
        private int x;
        private int y;
        private int speed;
        private int angle; // Направление движения

        public Snowflake() {
            x = (int) (Math.random() * getWidth());
            y = (int) (Math.random() * getHeight());
            speed = (int) (Math.random() * 5) + 1;
            angle = (int) (Math.random() * 360); // Случайное начальное направление
        }

        public void move() {
            // Добавим случайное изменение направления
            int angleChange = (int) (Math.random() * 20) - 10; // Случайное изменение угла [-10, 10]
            angle += angleChange;

            // Пересчитаем координаты на основе нового направления
            x += (int) (speed * Math.cos(Math.toRadians(angle)));
            y += (int) (speed * Math.sin(Math.toRadians(angle)));

            // Зациклим снежинку, если она выходит за пределы окна
            if (x < 0 || x > getWidth() || y < 0 || y > getHeight()) {
                x = (int) (Math.random() * getWidth());
                y = 0;
            }
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


