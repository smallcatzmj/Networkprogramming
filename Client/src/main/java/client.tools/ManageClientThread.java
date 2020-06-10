package client.tools;

import java.util.HashMap;

/**
 * @description:管理客户短语服务器连接线程
 * @author:zmj
 * @date 2020/6/39:15
 */
public class ManageClientThread {
    private static HashMap hashMap = new HashMap<String,ClientConServerThread>();
    //加入创建好的线程
    public static void addClientConServerThread(String id,ClientConServerThread c){
        hashMap.put(id,c);
    }
    public static ClientConServerThread getClientConServerThread(String id){
        return (ClientConServerThread) hashMap.get(id);
    }
}
