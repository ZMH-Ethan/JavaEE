package Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    // 需要先定义一个 socket 对象.
    // 通过网络通信, 必须要使用 socket 对象.
    private DatagramSocket socket = null;

    // 绑定一个端口, 不一定能成功!!
    // 如果某个端口已经被别的进程占用了, 此时这里的绑定操作就会出错.
    // 同一个主机上, 一个端口, 同一时刻, 只能被一个进程绑定.
    public UdpEchoServer(int port) throws SocketException {
        // 构造 socket 的同时, 指定要关联/绑定的端口.
        socket = new DatagramSocket(port);
    }

    // 启动服务器的主逻辑.
    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            // 每次循环, 要做三件事情:
            // 1. 读取请求并解析
            //    构造空饭盒
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //    食堂大妈给饭盒里盛饭. (饭从网卡上来的)
            socket.receive(requestPacket);
            //    为了方便处理这个请求, 把数据包转成 String
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2. 根据请求计算响应(此处省略这个步骤)
            String response = process(request);
            // 3. 把响应结果写回到客户端
            //    根据 response 字符串, 构造一个 DatagramPacket .
            //    和请求 packet 不同, 此处构造响应的时候, 需要指定这个包要发给谁.
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    // requestPacket 是从客户端这里收来的. getSocketAddress 就会得到客户端的 ip 和 端口
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    // 这个方法希望是根据请求计算响应.
    // 由于咱们写的是个 回显 程序. 请求是啥, 响应就是啥!!
    // 如果后续写个别的服务器, 不再回显了, 而是有具体的业务了, 就可以修改 process 方法,
    // 根据需要来重新构造响应.
    // 之所以单独列成一个方法, 就是想让同学们知道, 这是一个服务器中的关键环节!!!
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}