package com.perion.refresh_prototype_in_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
public abstract class ColorFrame extends JFrame {

    private Color color;

    @Autowired
    private Random random;

    @PostConstruct
    public void init(){
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void moveToRandomLocation() {
        color = getColorBean();
        getContentPane().setBackground(color);
        setLocation(random.nextInt(1200),random.nextInt(800));
        repaint();
    }

    @Lookup
    protected abstract Color getColorBean();
}





