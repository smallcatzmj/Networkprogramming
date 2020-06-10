package client.tools;

import client.view.Chat;

import java.util.HashMap;

/**
 * @description:管理用户聊天
 * @author:zmj
 * @date 2020/6/310:11
 */
public class ManageChat {
    private static HashMap hashMap = new HashMap<String,Chat>();
    //加入聊天界面
    public static void addChat(String id,Chat chat){
        hashMap.put(id,chat);
    }
    //取出聊天界面
    public static Chat getChat(String id){
       return (Chat) hashMap.get(id);
    }
}
