package UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @description:UDP编程客户端
 * @author:zmj
 * @date 2020/4/2917:42
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端和端口
        DatagramSocket client = new DatagramSocket(6666);
        //2.准备数据
        double num = 99.99;
        byte[] data = convert(num);
        //3.打包（发送的地点及端口）
        DatagramPacket packet = new DatagramPacket(data, data.length,
                                    new InetSocketAddress("localhost",8888));
        //4.发送
        client.send(packet);
        //5.释放
        client.close();
    }
    public static byte[] convert(double num) throws IOException {
        byte[] date = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos. writeDouble(num);
        dos.flush();
        //获取数据
        date = bos.toByteArray();
        return date;
    }
}
