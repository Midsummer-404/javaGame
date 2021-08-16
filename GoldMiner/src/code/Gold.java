package code;

import java.awt.*;

public class Gold extends Object{

    public Gold(){
        this.x = (int)(Math.random()*700);
        this.y = (int)(Math.random()*400+300);
        this.flag = false;
        this.width = 52;
        this.height = 52;
        this.m = 30;
        this.count = 4;
        this.type = 0;
        this.img = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\gold1.gif");
    }
}

class GoldMini extends Gold{
    public GoldMini(){
        this.width = 36;
        this.height = 36;
        this.m = 15;
        this.count = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\gold0.gif");
    }
}

class GoldPlus extends Gold{
    public GoldPlus(){
        this.x = (int) (Math.random()*650);
        this.width = 105;
        this.height = 105;
        this.m = 60;
        this.count = 8;
        this.img = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\gold2.gif");
    }
}
