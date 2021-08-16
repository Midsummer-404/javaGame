package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWindow extends JFrame {
    // 存储金块、石块
    List<Object> objectList = new ArrayList<>();
    Background bg = new Background();
    Line line = new Line(this);

    {
        // 是否可以放置
        boolean isPlace = true;
        for (int i = 0; i < 11; i++) {
            double random = Math.random();
            Gold gold;  // 存放当前生成的金块
            if (random < 0.3){
                gold = new GoldMini();
            }
            else if(random < 0.7){
                gold = new Gold();
            }
            else{
                gold = new  GoldPlus();
            }

            for (Object obj:objectList){
                if (gold.getRec().intersects(obj.getRec())){
                    // 重叠，不可放置，须重新生成
                    isPlace = false;
                }
            }
            if (isPlace){
                objectList.add(gold);
            }else{
                isPlace = true;
                i--;
            }
        }
        for (int i = 0; i < 3; i++) {
            Rock rock = new Rock();
            for (Object obj:objectList){
                if (rock.getRec().intersects(obj.getRec())){
                    isPlace = false;
                }
            }
            if (isPlace){
                objectList.add(rock);
            }else{
                isPlace = true;
                i--;
            }
        }
    }

    // 缓存画布
    Image offScreenImage;

    void init(){
        this.setVisible(true);  // 设置窗口可见
        this.setSize(768,800);  // 设置窗口大小(根据图片尺寸修改）
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //退出

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1 && line.state == 0){
                    line.state = 1;
                }
                if (e.getButton() == 3 && line.state == 3){
                    Background.waterFlag = true;
                    Background.waterNum--;
                }
            }
        });

        while (true){
            repaint();
            nextLevel();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextLevel(){
        if (Background.count >= Background.goal){
            Background.level++;
            dispose();
            GameWindow gameWindow = new GameWindow();
            gameWindow.init();
        }
    }
    @Override
    public void paint(Graphics g) {
        offScreenImage = this.createImage(768,800);
        Graphics gImage = offScreenImage.getGraphics();
        bg.paintSelf(gImage);
        // 绘制物体
        for (Object obj:objectList){
            obj.paintSelf(gImage);
        }
        line.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        GameWindow gw = new GameWindow();
        gw.init();
    }
}
