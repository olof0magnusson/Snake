package Pityfly;
import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by Olof Magnusson on 2017-03-15.
 */

public class DrawGame extends JPanel{
    Model model;
    JFrame frame = new JFrame();
    private int width = 10;
    private int height = 10;


    // Draws everything

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect((int) model.block.getPoint().getX(),(int) model.block.getPoint().getY(),width,height);
        g.fillRect((int) model.block.getPoint().getX(),(int) model.block.getPoint().getY(),width,height);

        for(Iterator itr = model.snake.getTheSnake().iterator();itr.hasNext();)  {
            Block block =(Block) itr.next();
          //  System.out.println(block.getPoint().toString());
            g.drawRect((int) block.getPoint().getX(),(int) block.getPoint().getY(),width,height);
            g.fillRect((int) block.getPoint().getX(),(int) block.getPoint().getY(),width,height);
        }}

    // Getters and setters
    public JFrame getFrame() {
        return frame;
    }
    public void setModel(Model model) {
        this.model = model;
    }
}
