package Pityfly;

import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Olof Magnusson on 2017-03-15.
 */
public class Snake{

    private int speed = 10;
    private Deque <Block> theSnake = new LinkedList<>();

    public Deque<Block> create (){
        grow();
        return theSnake;
    }
    public int getSize() {
        return theSnake.size();
    }

    public boolean canIMove(Direction dir){
        if (theSnake.peekLast().getDir() != dir){
            return true;
        }
        return false;
    }

    public void move(){
        int size = theSnake.size();
        Deque <Block> temporary = new LinkedList<>();

    for (int i = 0; i < size; i++) {
        Block b = theSnake.pop();
        if (!theSnake.isEmpty()) {
            Block b2 = theSnake.peek();
            b.setDir(b2.getDir());
            b.setPoint(b2.getPoint());
        }
        else {
                Direction dir = b.getDir();
                double x = b.getPoint().getX();
                double y = b.getPoint().getY();

                switch (dir) {
                    case South:
                        y+=speed;
                        break;
                    case East:
                        x+=speed;
                        break;
                    case West:
                        x-=speed;
                        break;
                    case North:
                        y-=speed;
                        break;
                }
                b.setPoint(new Point((int)x,(int)y));
            }
          // System.out.println(b.getPoint().toString());
        temporary.addLast(b);

        }
        theSnake = temporary;
      //  System.out.println("------------------------");
}

    public void grow(){

        if (theSnake.peek()!= null)
        {
            Direction dir = theSnake.getFirst().getDir();
            Point p = theSnake.getFirst().getPoint();
            double x = p.getX();
            double y = p.getY();
            switch (dir)
            {
                case South:
                    y -= speed * 10;
                    break;
                case East:
                    x += speed * 10;
                    break;
                case West:
                    x -= speed * 10;
                    break;
                case North:
                    y += speed * 10;
                    break;
            }
            p.setLocation(x,y);
            theSnake.addFirst((new Block(dir,p)));
        }
        else {
            theSnake.add(new Block());
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Deque<Block> getTheSnake() {
        return theSnake;
    }

    public void setTheSnake(Deque<Block> theSnake) {
        this.theSnake = theSnake;
    }

    public boolean keyBugFixer(Direction direction){
        if (theSnake.size() < 2){
            return false;
        }
        Deque <Block> temp = new LinkedList<>(theSnake);
        Block head = temp.removeLast();
        Block second = temp.removeLast();

        switch (direction){
            case South:
                if (head.getPoint().getX() == second.getPoint().getX()){
                    return true;
                }
                break;
            case North:
                if (head.getPoint().getX() == second.getPoint().getX()){
                    return true;
                }
                break;
            case East:
                if (head.getPoint().getY() == second.getPoint().getY()){
                    return true;
                }
                break;
            case West:
                if (head.getPoint().getY() == second.getPoint().getY()){
                    return true;
                }
                break;
        }


        return false;

    }

    public void snakeKilledItself(){
        int size = theSnake.size();
        Deque <Block> temporary = new LinkedList<>(getTheSnake());
        Block head = temporary.peekLast();
        boolean check = false;
        Direction dir = head.getDir();

        for (int i = 0; i < size; i++) {
            if (temporary.size() > 1) {
                Block b = temporary.pop();

                if (head.getPoint().equals(b.getPoint())){
                    switch (dir){
                        case South:
                            if (b.getDir() == Direction.North){
                                check = true;
                            }
                            break;
                        case North:
                            if (b.getDir() == Direction.South){
                                check = true;
                            }
                            break;
                        case West:
                            if (b.getDir() == Direction.East){
                                check = true;
                            }
                            break;
                        case East:
                            if (b.getDir() == Direction.West){
                                check = true;
                            }
                            break;
                    }
                    if (!check){
                        speed = 0;
                    }
                }
            }
        }
    }

}
