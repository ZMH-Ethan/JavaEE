import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showRequest")
public class ShowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过字符串拼接的方式演示各个get方法得到的结果
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");

        stringBuilder.append("------------------------<br>");

        Enumeration<String> headerNames = req.getHeaderNames();  //getHeaderNames返回的是枚举类型
        while (headerNames.hasMoreElements()) {//通过循环返回枚举类型中的每个元素
            String headerName = headerNames.nextElement();  //每个元素的key
            String headerValue = req.getHeader(headerName);  //每个元素的value
            stringBuilder.append(headerName + ":" + headerValue + "<br>");  //以键值对的形式写入stringBuilder
        }


        //在响应中设置body的类型方便浏览器解析
        resp.setContentType("text/html;charset=utf8");//为了让<br>生效
        //写入响应中
        resp.getWriter().write(stringBuilder.toString());
    }
}
