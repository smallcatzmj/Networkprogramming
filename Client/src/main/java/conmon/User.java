package conmon;

/**
 * @description:用户信息类
 * @author:zmj
 * @date 2020/6/216:24
 */
public class User implements java.io.Serializable{
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
