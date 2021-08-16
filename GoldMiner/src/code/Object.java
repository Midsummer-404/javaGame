package code;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class Object {
    // 坐标
    int x;
    int y;
    // 宽高
    int width;
    int height;
    // 图片
    Image img;
    // 标记是否可以移动
    boolean flag;
    // 质量
    int m;
    // 积分
    int count;
    // 类型 0金块 1石块
    int type;

    public void paintSelf(Graphics g){ g.drawImage(img,x,y,null); }

    public int getWidth() {
        return width;
    }


    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
