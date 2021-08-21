package code;

import java.awt.*;

public class Line {

    // 起点坐标
    int X = 380;
    int Y = 180;
    // 终点坐标
    int endX = 500;
    int endY = 500;
    // 线长
    double length = 100;
    // 线长最小值
    double MIN_length = 100;
    // 线长最大值
    double MAX_length = 600;
    // 角度
    double angle = 0;
    // 方向参数
    int dir = 1;
    // 状态 0摇摆 1抓取 2收回 3抓取收回
    int state;
    // 勾爪图片
    Image hook = Toolkit.getDefaultToolkit().createImage("D:\\javaGame\\GoldMiner\\img\\hook.png");

    // 让本类接收到主窗口的数据
    GameWindow frame;

    public Line(GameWindow frame){
        this.frame = frame;
    }

    // 碰撞检测 检测金块和石块是否被抓取
    public void logic(){
        for(Object obj:this.frame.objectList){
            if (endX > obj.x && endX < obj.x + obj.width){
                if (endY > obj.y && endY < obj.y + obj.height){
                    state = 3;
                    obj.flag = true;
                }
            }
        }

    }

    // 绘制方法
    public void drawLine(Graphics g){
        endX = (int) (X + length * Math.cos(angle * Math.PI));
        endY = (int) (Y + length * Math.sin(angle * Math.PI));
        g.setColor(Color.red);
        g.drawLine(X-1,Y,endX-1,endY);
        g.drawLine(X,Y,endX,endY);          // 绘制平行线实现线体加粗
        g.drawLine(X+1,Y,endX+1,endY);
        g.drawImage(hook,endX-36,endY-2,null);
    }

    public void paintSelf(Graphics g){
        logic();
        switch (state){
            case 0:
                if (angle < 0.1){
                    dir = 1;
                }
                else if(angle > 0.9){
                    dir = - 1;
                }
                angle += 0.005 * dir;
                drawLine(g);
                break;
            case 1:
                if (length < MAX_length){
                    length += 5;
                    drawLine(g);
                }else{
                    state = 2;
                }
                break;
            case 2:
                if (length > MIN_length){
                    length -= 5;
                    drawLine(g);
                }else{
                    state = 0;
                }
                break;
            case 3:
                int m = 1;
                if (length > MIN_length){
                    length -= 5;
                    drawLine(g);
                    for (Object obj: this.frame.objectList){
                        if (obj.flag){
                            m = obj.m;
                            obj.x = endX - obj.getWidth()/2;
                            obj.y = endY;
                            if (length <= MIN_length){
                                obj.x = -150;
                                obj.y = -150;
                                obj.flag = false;
                                Background.waterFlag = false;
                                // 加分
                                Background.count += obj.count;
                                state = 0;
                            }
                            if (Background.waterFlag){
                                if (obj.type == 0){
                                    m = (int) (obj.m * 0.5);
                                }
                                if (obj.type == 1){
                                    obj.x = -150;
                                    obj.y = -150;
                                    obj.flag = false;
                                    Background.waterFlag = false;
                                    state = 2;
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    // 重置线
    public void reLine(){
        angle = 0;
        length = 100;
    }
}
