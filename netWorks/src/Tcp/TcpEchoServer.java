package Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    //serverSocket是外场拉客的小哥,serverSocket有且只有一个
    //cilentSocket是内场服务的小姐姐，cilentSocket会给每个客户端分配一个
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true) {
            Socket cilentSocket = serverSocket.accept();
            // 如果直接调用, 该方法会影响这个循环的二次执行, 导致 accept 不及时了.
            // 创建新的线程, 用新线程来调用 processConnection
            // 每次来一个新的客户端都搞一个新的线程即可
            Thread t = new Thread(() -> {
                try {
                    processConnection(cilentSocket);  //连接后通过processConnection来处理连接
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }

    //通过这个方法来处理一个连接:
    //1.读取请求
    //2.根据请求计算响应
    //3.把响应返回给客户端
    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());  //提示客户端上线并打印IP地址和端口号
        //try()这种写法，允许括号中写多个流对象，中间使用“；”来分割
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);  //为了读取请求方便，把字节流转为字符流
            PrintWriter printWriter = new PrintWriter(outputStream); //为了返回响应方便，把字节流转为字符流

            //我们读到哪里算是一个完整的请求呢；
            //此处做一个简单的约定：
            //每个请求是个字符串（文本数据），每个请求之间使用\n来分割,不要忘记响应也要这样约定

            while(true) {  //长连接：一次连接有多个请求
                //1.读取请求
                if (!scanner.hasNext()) {  //如果客户端关闭连接了，hasNext返回false,结束while循环
                    System.out.printf("[%s:%d] 客户端下线！\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());  //提示客户端下线并打印IP地址和端口号
                    break;
                }
                    //如果没有读完，直接使用scanner读取一段字符串
                String request = scanner.next();  //next会往后一直读直到读到空白符（空格、换行符、制表符、翻页符等）结束（不包含空白符）。此处尽量不要使用nextLine
                //2.根据请求计算响应
                String response = process(request);  //通过process方法来处理请求并返回响应
                //3.把响应返回给客户端(不要忘记响应里面也是要带上换行的，方便客户端区分从哪里到哪里是一个响应)
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req:%s ; resp:%s \n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();  //这里的cilentSocket只是给一个连接提供帮助，所以要及时释放
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
