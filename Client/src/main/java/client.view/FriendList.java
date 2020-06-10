package client.view;

import client.tools.ManageChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * @description:好友列表
 * @author:zmj
 * @date 2020/6/212:54
 */
public class FriendList extends JFrame implements MouseListener{
    JPanel jPanel1,jPanel2;
    JLabel jLabel;
    JScrollPane jScrollPane;
    String owner;
//    public static void main(String[] args) {
//        FriendList friendList = new FriendList();
//    }
    public FriendList(String ownername){
        this.owner = ownername;
        jLabel = new JLabel("联系人",JLabel.CENTER);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jPanel1 = new JPanel(new BorderLayout());
        jPanel2 = new JPanel(new GridLayout(50,1,4,4));
        //初始化好友
        JLabel[] jbls = new JLabel[50];
        for (int i = 0; i < jbls.length; i++) {
            jbls[i] = new JLabel(i+1+"",JLabel.LEFT);
            jbls[i].addMouseListener(this);
            jbls[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
            jPanel2.add(jbls[i]);
        }
        jScrollPane = new JScrollPane(jPanel2);
        jPanel1.add(jLabel,"North");
        jPanel1.add(jScrollPane,"Center");
        this.add(jPanel1,"Center");
        //窗口显示自己的编号
        this.setTitle(ownername);
        this.setSize(240,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount()==2){
                String friendNo = ((JLabel)e.getSource()).getText();
                Chat c = new Chat(this.owner,friendNo);
                //聊天窗口加入管理类
                ManageChat.addChat(this.owner+" "+friendNo,c);
            }
    }

    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
            JLabel jLabel = (JLabel)e.getSource();
            jLabel.setForeground(Color.RED);
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
        JLabel jLabel = (JLabel)e.getSource();
        jLabel.setForeground(Color.black);

    }
}
