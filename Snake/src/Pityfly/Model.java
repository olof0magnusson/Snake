package Pityfly;

import java.awt.*;
import java.util.Deque;

/**
 * Created by Olof Magnusson on 2017-03-15.
 */
public class Model{
    Snake snake = new Snake();
    Block block = new Block();

    public void grow(){
        snake.grow();
    }
    public void create(){
        snake.create();
    }
    public void boundaries(){
        if (snake.getTheSnake().size()>0){
        int x = (int) snake.getTheSnake().getLast().getPoint().getX();
        int y = (int) snake.getTheSnake().getLast().getPoint().getY();
        if ( x < 0){
            snake.getTheSnake().peekLast().setPoint(new Point(600,y));
        }
        else if (x > 599){
            snake.getTheSnake().peekLast().setPoint(new Point(0,y));
        }
        else if (y < 1){
            snake.getTheSnake().peekLast().setPoint(new Point(x,600));
        }
        else if (y> 599){
            snake.getTheSnake().peekLast().setPoint(new Point(x,0));
        }
    }}

    public boolean checkCollision(){
        if(snake.getTheSnake().size() > 0){


        if(snake.getTheSnake().peekLast().getPoint().equals(block.getPoint())){
            return true;
        }
        else {
            return false;
        }
        }
        return false;
    }
    public void collision(){
        block.move();
        snake.grow();
    }
}
