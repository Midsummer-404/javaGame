package code;

import java.awt.*;

public class Background {
    // 关卡数
    static int level = 1;
    // 目标得分
    static int goal = level * 5;
    // 总积分
    static int count = 0;
    // 药水数量
    static int waterNum = 3;
    // 药水状态 true:正在使用 false:未使用
    static boolean waterFlag = false;
    // 载入图片
    Image bg = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\bg.jpg");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\bg1.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\water.png");

    void paintSelf(Graphics g){
        g.drawImage(bg,0,200,null);
        g.drawImage(bg1,0,0,null);
        g.drawImage(peo,310,50,null);
        g.drawImage(water,450,40,null);
        drawWord(g,30,Color.black,"积分:"+count,30,150);
        drawWord(g,30,Color.black,"*"+waterNum,510,70);
        // 关卡数
        drawWord(g,20,Color.black,"第" + level + "关",30,60);
        // 目标积分
        drawWord(g,30,Color.black,"目标:" + goal,30,110);
    }



    // 绘制字符串
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
