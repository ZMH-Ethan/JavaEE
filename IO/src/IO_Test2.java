import java.io.File;
import java.io.IOException;

public class IO_Test2 {
    public static void main(String[] args) throws IOException {
        // 在相对路径中, ./ 通常可以省略
        File file = new File("hello_IO.txt");       // 该文件不存在

        System.out.println(file.exists());      //判断 File 对象描述的文件是否真实存在
        System.out.println(file.isDirectory());     //判断 File 对象代表的文件是否是一个目录
        System.out.println(file.isFile());      //判断 File 对象代表的文件是否是一个普通文件

        //创建文件
        file.createNewFile(); //根据 File 对象，自动创建一个空文件。成功创建后返回 true
        //创建后该文件存在
        System.out.println(file.exists());      //判断 File 对象描述的文件是否真实存在
        System.out.println(file.isDirectory());     //判断 File 对象代表的文件是否是一个目录
        System.out.println(file.isFile());      //判断 File 对象代表的文件是否是一个普通文件

        //删除文件
        file.delete();
        System.out.println("删除文件之后");
        System.out.println(file.exists());
    }
}
