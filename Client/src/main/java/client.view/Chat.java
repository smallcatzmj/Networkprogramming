package client.view;
import client.tools.ManageClientThread;
import conmon.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @description:聊天界面
 * @author:zmj
 * @date 2020/6/213:54
 */
public class Chat extends JFrame implements ActionListener{
    JTextArea jTextArea;
    JTextField jTextField;
    JButton jButton;
    JPanel jPanel;
    //用户和发送者id
    String ownwerId;
    String friendId;
    public static void main(String[] args) {
//        Chat chat = new Chat("1");
    }
    public Chat(String owner, String friend){
        this.ownwerId = owner;
        this.friendId = friend;
    jTextArea = new JTextArea();
    jTextArea.setFont(new Font("微软雅黑", Font.BOLD, 20));
    jTextField = new JTextField(15);
    jTextField.setFont(new Font("微软雅黑", Font.BOLD, 20));
    jTextField.setFont(new Font("微软雅黑", Font.BOLD, 20));
    jButton = new JButton("发送");
    jButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
    jButton.addActionListener(this);
    jPanel = new JPanel();
    jPanel.add(jTextField);
    jPanel.add(jButton);
    this.add(jTextArea,"Center");
    this.add(jPanel,"South");
    this.setTitle(owner+"正在和"+friend+"聊天");
    this.setSize(500,400);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    }

    //显示消息
    public void showMessage(Message m){
        String info = m.getSendTime()+" "+m.getSender()+"对"+m.getGetter()+"说："+m.getCon();
        this.jTextArea.append(info);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            //用户点击发送
            Message m = new Message();
            m.setSender(this.ownwerId);
            m.setGetter(this.friendId);
            m.setCon(jTextField.getText());
            m.setSendTime(new java.util.Date().toString());
            //发送给服务器
            try {
                ObjectOutputStream oos = new ObjectOutputStream(
                        ManageClientThread.getClientConServerThread(ownwerId).getS().getOutputStream());
                oos.writeObject(m);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

