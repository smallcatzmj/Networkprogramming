package server.model;

import java.util.HashMap;

/**
 * @description: 管理客户端线程
 * @author:zmj
 * @date 2020/6/38:07
 */
public class ManageClientThread {
    public static HashMap hashMap = new HashMap<String,SerConClientThread>();

    //添加客户端线程
    public static void addClientThread(String uid,SerConClientThread thread){
        hashMap.put(uid,thread);
    }

    public static SerConClientThread getClientThread(String uid){
        return (SerConClientThread) hashMap.get(uid);
    }
}
