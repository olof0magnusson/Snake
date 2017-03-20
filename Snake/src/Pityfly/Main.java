package Pityfly;

import javax.swing.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main{

    public static void main(String[] args) {
        // Creating objects

        Model model = new Model();
        Controller controller = new Controller();
        DrawGame canvas = new DrawGame();
        Key key = new Key(model);

        // Creating the Snake
        model.create();


        // setting Objects
        canvas.setModel(model);
        controller.setModel(model);
        controller.setDrawGame(canvas);

        // Important to make it listen to keys
        canvas.add(key);
        canvas.getFrame().add(canvas);
        canvas.frame.setSize(600,600);
        canvas.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.frame.setLocationRelativeTo(null);
        canvas.frame.setVisible(true);
        controller.getTimer().start();
    }
}