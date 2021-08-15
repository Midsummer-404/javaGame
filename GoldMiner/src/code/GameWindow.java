package code;

import javax.swing.*;

public class GameWindow extends JFrame {

    public void init(){
        this.setVisible(true);  // 设置窗口可见
        this.setSize(500,500);  // 设置窗口大小
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //退出
    }

    public static void main(String[] args) {
        GameWindow gw = new GameWindow();
        gw.init();
    }
}
