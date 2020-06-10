package client.view;

import client.model.ClientUser;
import conmon.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description:登录界面
 * @author:zmj
 * @date 2020/6/29:27
 */
public class ClientLogin extends JFrame implements ActionListener {
    //界面上部分
    JPanel jP2;
    JLabel jL1,jL2;
    JTextField jTextField;
    JPasswordField jPasswordField;
    JPanel jP1;
    JButton jP1_jb1,jP1_jb2;

    public static void main(String[] args) {
        ClientLogin clientLogin = new ClientLogin();
    }
    public ClientLogin(){
        jP2 = new JPanel(new GridLayout(2,2));
        jP2.setSize(550,220);
        jL1 = new JLabel("账号：",JLabel.CENTER);
        jL1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jL2 = new JLabel("密码：",JLabel.CENTER);
        jL2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jTextField = new JTextField();
        jTextField.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jPasswordField = new JPasswordField();
        jPasswordField.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jP2.add(jL1);
        jP2.add(jTextField);
        jP2.add(jL2);
        jP2.add(jPasswordField);

        jP1 = new JPanel();
        jP1_jb1 = new JButton("登录");
        jP1_jb1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        //登录监听
        jP1_jb1.addActionListener(this);
        jP1_jb2 = new JButton("取消");
        jP1_jb2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jP1.add(jP1_jb1);
        jP1.add(jP1_jb2);
        this.add(jP1,"South");
        this.add(jP2);
        this.setSize(400,170);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jP1_jb1){
            ClientUser clientUser = new ClientUser();
            User u = new User();
            u.setUsername(jTextField.getText().trim());
            u.setPassword(new String(jPasswordField.getPassword()));
            if (clientUser.checkUser(u)){
                new FriendList(u.getUsername());
                //关闭登录界面
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"用户名或密码错误");
            }
        }
    }
}
