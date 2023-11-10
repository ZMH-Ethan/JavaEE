import java.io.File;
import java.io.IOException;

public class IO_Test1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./cat.jpg");
        System.out.println(file.getParent());   //返回 File 对象的父目录文件路径
        System.out.println(file.getName());     //返回 FIle 对象的纯文件名称
        System.out.println(file.getPath());       //返回 File 对象的文件路径
        System.out.println(file.getAbsolutePath());       //返回 File 对象的绝对路径
        System.out.println(file.getCanonicalPath());        //返回 File 对象的修饰过的绝对路径
    }
}
