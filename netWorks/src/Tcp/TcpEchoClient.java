package Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int port) throws IOException {
        // 这个操作相当于让客户端和服务器建立 tcp 连接.
        // 这里的连接连上了, 服务器的 accept 就会返回.
        socket = new Socket(serverIp, port);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scannerFromSocket = new Scanner(inputStream);
            while (true) {
                // 1. 从键盘上读取用户输入的内容.
                System.out.print("-> ");
                String request = scanner.next();
                // 2. 把读取的内容构造成请求, 发送给服务器.
                //    注意, 这里的发送, 是带有换行的!!
                printWriter.println(request);
                printWriter.flush();
                // 3. 从服务器读取响应内容
                String response = scannerFromSocket.next();
                // 4. 把响应结果显示到控制台上.
                System.out.printf("req: %s; resp: %s\n", request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}