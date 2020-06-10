package server.view;

import server.model.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description:服务器开关面板
 * @author:zmj
 * @date 2020/6/215:45
 */
public class ServerFrame extends JFrame implements ActionListener {
    JPanel jPanel;
    JButton jb1,jb2;

    public static void main(String[] args) {
        ServerFrame s = new ServerFrame();
    }
    public ServerFrame(){
        jPanel = new JPanel();
        jb1 = new JButton("启动服务器");
        jb1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jb1.addActionListener(this);
        jb2 = new JButton("关闭服务器");
        jb2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jPanel.add(jb1);
        jPanel.add(jb2);
        this.add(jPanel);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1){
            new Server();
        }
    }
}
