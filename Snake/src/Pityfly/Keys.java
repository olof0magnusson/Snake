package Pityfly;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Olof Magnusson on 2017-03-16.
 */
public class Keys extends KeyAdapter {
    Snake snake;
    public Keys(Snake snake){
        this.snake = snake;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (snake.getTheSnake().size() > 0) {
            if (keyCode == KeyEvent.VK_UP) {
                if (!snake.keyBugFixer(Direction.North)){
                if (snake.canIMove(Direction.South)) {
                    snake.getTheSnake().peekLast().setDir(Direction.North);
                }}
            }

            if (keyCode == KeyEvent.VK_DOWN) {
                if (!snake.keyBugFixer(Direction.South)){
                if (snake.canIMove(Direction.North)) {
                    snake.getTheSnake().peekLast().setDir(Direction.South);
                }}

            }
            if (keyCode == KeyEvent.VK_LEFT) {
                if (!snake.keyBugFixer(Direction.West)){
                if (snake.canIMove(Direction.East)) {
                    snake.getTheSnake().peekLast().setDir(Direction.West);
                }}
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                if (!snake.keyBugFixer(Direction.East)){
                if (snake.canIMove(Direction.West)) {
                    snake.getTheSnake().peekLast().setDir(Direction.East);
                }}
            }
        }
    }

}