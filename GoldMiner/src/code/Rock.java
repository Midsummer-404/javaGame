package code;

import java.awt.*;

public class Rock extends Object{
    public Rock(){
        this.x = (int)(Math.random()*700);
        this.y = (int)(Math.random()*400+300);
        this.flag = false;
        this.width = 71;
        this.height = 71;
        this.m = 50;
        this.count = 1;
        this.type = 1;
        this.img = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\rock1.png");
    }
}
