package Udp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

// 使用继承, 是为了复用之前的代码.
public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("dog", "小狗");
        dict.put("cat", "小猫");
        dict.put("fuck", "卧槽");
        // ........... 可以无限的添加很多很多数据. 有道词典和咱们相比, 就是人家的这个表更大!!
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "该单词没有查到!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer = new UdpDictServer(9090);
        udpDictServer.start();
    }
}