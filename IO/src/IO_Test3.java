import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IO_Test3 {
    public static void main(String[] args) throws IOException {

        try(InputStream inputStream = new FileInputStream("f:/test.txt")) {
            //读文件
            // read 一次返回的是一个字节. 但是此处的返回值类型是 int !!!
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    // 读到末尾了, 结束循环即可
                    break;
                }
                System.out.printf("%x\n", b);
            }
        }
    }
}
