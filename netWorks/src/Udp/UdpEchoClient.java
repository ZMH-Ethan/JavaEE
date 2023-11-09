
package Udp;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    // 客户端启动, 需要知道服务器在哪里!!
    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        // 对于客户端来说, 不需要显示关联端口.
        // 不代表没有端口, 而是系统自动分配了个空闲的端口.
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        // 通过这个客户端可以多次和服务器进行交互.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 先从控制台, 读取一个字符串过来
            //    先打印一个提示符, 提示用户要输入内容
            System.out.print("-> ");
            String request = scanner.next();
            // 2. 把字符串构造成 UDP packet, 并进行发送.
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);
            // 3. 客户端尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            // 4. 把响应数据转换成 String 显示出来.
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.printf("req: %s, resp: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
//        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
         UdpEchoClient udpEchoClient = new UdpEchoClient("192.168.56.1", 9090);
        udpEchoClient.start();
    }
}