package client.tools;

import client.view.Chat;
import conmon.Message;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @description: 客户端和服务端保持连接线程
 * @author:zmj
 * @date 2020/6/39:07
 */
public class ClientConServerThread extends Thread{
    private Socket s;
    public ClientConServerThread(Socket s){
        this.s = s;
    }
    public void run(){
        while (true){
            //不停读取服务端发的消息
            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m = (Message)ois.readObject();
                System.out.println("读取到服务器消息"+m.getCon());
                //服务器消息显示聊天界面
                Chat chat = ManageChat.getChat(m.getGetter()+" "+m.getSender());
                //显示
                chat.showMessage(m);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public Socket getS() {
        return s;
    }
}
