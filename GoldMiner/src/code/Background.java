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
    // 开始时间
    long starTime;
    // 结束时间
    long endTime;
    // 药水价格
    int price = (int) (Math.random() * 10);
    // 是否购买
    boolean shop = false;
    // 载入图片
    Image bg = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\bg.jpg");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\bg1.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("D:\\javaGame\\GoldMiner\\img\\water.png");

    void paintSelf(Graphics g){
        g.drawImage(bg,0,200,null);
        g.drawImage(bg1,0,0,null);
        switch (GameWindow.state){
            case 0:
                drawWord(g,80,Color.green,"准备开始",200,400);
                drawWord(g,40,Color.green,"单击右键开始",240,440);
                break;
            case 1:
                g.drawImage(peo,310,50,null);
                g.drawImage(water,450,40,null);
                drawWord(g,30,Color.black,"积分:"+count,30,150);
                drawWord(g,30,Color.black,"*"+waterNum,510,70);
                // 关卡数
                drawWord(g,20,Color.black,"第" + level + "关",30,60);
                // 目标积分
                drawWord(g,30,Color.black,"目标:" + goal,30,110);
                endTime = System.currentTimeMillis();
                long time = 20 - (endTime - starTime) / 1000;
                drawWord(g,30,Color.black,"时间:"+(time > 0 ? time:0),520,150);
                break;
            case 2:
                g.drawImage(water,300,400,null);
                drawWord(g,30,Color.black,"价格" + price,300,500);
                drawWord(g,30,Color.black,"是否购买",300,550);
                if (shop){
                    count = count - price;
                    waterNum ++;
                    shop = false;
                    GameWindow.state = 1;
                    starTime = System.currentTimeMillis();
                }
                break;
            case 3:
                drawWord(g,80,Color.black,"失败！",250,350);
                drawWord(g,80,Color.black,"积分:"+count,200,450);
                break;
            case 4:
                drawWord(g,80,Color.yellow,"成功！",250,350);
                drawWord(g,80,Color.red,"积分:"+count,200,450);
                break;
            default:
        }

    }
    // t计时完成 false计时中
    boolean gameTime(){
        long tim = (endTime - starTime) / 1000;
        if (tim > 20){
            return true;
        }
        return false;
    }

    // 重置游戏
    public void reGame(){
        // 关卡数
        int level = 1;
        // 目标得分
        int goal = level * 5;
        // 总积分
        int count = 0;
        // 药水数量
        int waterNum = 3;
        // 药水状态 true:正在使用 false:未使用
        boolean waterFlag = false;
    }

    // 绘制字符串
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
