package client.model;

import conmon.User;

/**
 * @description:前台登录验证
 * @author:zmj
 * @date 2020/6/216:48
 */
public class ClientUser {
    public boolean checkUser(User u){
        return new Client().sendInfoToServer(u);
    }
}
