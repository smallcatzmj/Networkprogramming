package server.model;

import conmon.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @description: 服务器和某个客户端的通讯线程
 * @author:zmj
 * @date 2020/6/37:27
 */
public class SerConClientThread extends Thread{
    Socket s;
    public SerConClientThread(Socket s){
        this.s = s;
    }
    public void run(){
        while (true){
            //该线程接收客户端信息
            try{
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m  = (Message) ois.readObject();
                System.out.println(m.getSender()+"给"+m.getGetter()+"说"+m.getCon());

                //信息转发给另外一个客户端
                SerConClientThread sc = ManageClientThread.getClientThread(m.getGetter());
                ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
                oos.writeObject(m);

        }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
