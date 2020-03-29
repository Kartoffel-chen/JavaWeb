package cn.cz.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 向浏览器写入数据
 * @author Kartoffel
 * @create 2020-03-28-16:43
 */
@WebServlet("/response03")
public class ResponseDemo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取流对象之前,设置流默认编码
//        resp.setCharacterEncoding("GBK");
        // 2. 在请求头中告诉浏览器,服务器发送的消息的解码数据编码,建议浏览器使用该编码
//        resp.setHeader("content-type","text/html;charset=utf-8");


        // 3. 简单方式,设置编码
        resp.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = resp.getWriter();
        //输出数据
        writer.write("<h1>Hello,Response</h1>");
        writer.write("你好 response 乱码");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
