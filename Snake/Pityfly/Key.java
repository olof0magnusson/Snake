package Pityfly;

import javax.swing.*;
import java.awt.event.KeyListener;


/**
 * Created by Olof Magnusson on 2017-03-16.
 */
public class Key extends JPanel{
    Model model;
    public Key(Model model) {
        this.model = model;
        KeyListener listener = new Keys(model.snake);
        addKeyListener(listener);
        setFocusable(true);
    }
}
