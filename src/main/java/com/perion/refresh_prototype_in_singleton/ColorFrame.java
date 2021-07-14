package com.perion.refresh_prototype_in_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    @Autowired
    private Random random;

    @PostConstruct
    public void init() {
        System.out.println(color.getClass());
        System.out.println(color.getBlue());
        System.out.println(color.getBlue());
        System.out.println(color.getBlue());
        System.out.println(color.getBlue());
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void moveToRandomLocation() {
        getContentPane().setBackground(color);
        setLocation(random.nextInt(1200), random.nextInt(800));
        repaint();
    }


}





