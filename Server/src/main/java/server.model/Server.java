package server.model;

import conmon.Message;
import conmon.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:服务器，监听等待客户端连接
 * @author:zmj
 * @date 2020/6/215:57
 */
public class Server {
    public Server(){
        try {
            System.out.println("服务器已启动");
            //在9999端口监听
            ServerSocket ss = new ServerSocket(9999);
            //阻塞，等待连接
            while (true) {
                Socket s = ss.accept();
                //接收客户端发来的信息
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User u = (User)ois.readObject();
                System.out.println("账号"+u.getUsername()+"密码"+u.getPassword());
                Message m = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                if (u.getPassword().equals("123456")) {
                    //返回成功登录信息报
                    m.setMsType("1");
                    oos.writeObject(m);
                    //单开一个线程，让该线程与客户端保持通讯
                    SerConClientThread scct = new SerConClientThread(s);
                    //将用户线程加入HashMap
                    ManageClientThread.addClientThread(u.getUsername(),scct);
                    //启动客户端的线程
                    scct.start();
                } else {
                    m.setMsType("2");
                    oos.writeObject(m);
                    s.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
