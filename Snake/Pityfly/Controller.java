package Pityfly;

import javafx.scene.input.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Olof Magnusson on 2017-03-15.
 */
public class Controller
{
    private int delay = 60;
    private Model model;
    private DrawGame drawGame;

        private Timer timer = new Timer(delay,new TimerListener());

    public class TimerListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            model.snake.snakeKilledItself();
                if (model.checkCollision()) {
                    model.collision();
                    drawGame.setModel(model);
                }
                model.boundaries();
                model.snake.move();

                drawGame.repaint();



        }}


    void setDrawGame(DrawGame drawGame) {
    this.drawGame = drawGame;
}
    public Timer getTimer() {
        return timer;
    }

    public void setModel(Model model) {
        this.model = model;
    }}
