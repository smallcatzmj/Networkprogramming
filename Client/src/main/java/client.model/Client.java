package client.model;

import client.tools.ClientConServerThread;
import client.tools.ManageClientThread;
import conmon.Message;
import conmon.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @description:客户端连接服务器后台
 * @author:zmj
 * @date 2020/6/216:31
 */
public class Client {

    public Socket s;
    public boolean sendInfoToServer(Object o) {
        boolean b = false;
        try {
            s = new Socket("127.0.0.1",9999);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Message message = (Message)ois.readObject();
            if (message.getMsType().equals("1")){
                //登录成功创建一个客户端与服务器的线程
                ClientConServerThread c = new ClientConServerThread(s);
                //启动通讯线程
                c.start();
                ManageClientThread.addClientConServerThread(((User)o).getUsername(),c);
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            return b;
    }
}
