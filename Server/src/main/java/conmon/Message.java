package conmon;

/**
 * @description:发送信息类型
 * @author:zmj
 * @date 2020/6/218:12
 */
public class Message implements java.io.Serializable{
    private String msType;

    private String sender;
    private String getter;
    private String con;
    private String sendTime;

    public void setMsType(String msType) {
        this.msType = msType;
    }

    public String getMsType() {
        return msType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
