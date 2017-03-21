package Pityfly;

import java.awt.*;
import java.util.Random;

/**
 * Created by Olof Magnusson on 2017-03-15.
 */
public class Block {
    Random random = new Random();
    private Direction direction = Direction.East;
    private int width = 10;
    private int height = 10;
    private Point point = new Point();

    public Block(){
        point = new Point(300,300);
    }

    public Block(Direction direction, int width, int height, Point point) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.point = point;
    }

    public Block(Direction direction, Point point) {
        this.direction = direction;
        this.point = point;
    }

    public void move(){
        point = new Point(random.nextInt(50)*10,random.nextInt(50)*10);
    }
    public Direction getDir() {
        return direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getPoint() {
        return new Point(point);
    }

    public void setPoint(Point point) {
        this.point = new Point(point);
    }

    public void setDir(Direction dir) {
        this.direction = dir;
    }
}
