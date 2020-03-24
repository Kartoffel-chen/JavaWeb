package cn.cz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Kartoffel
 * @create 2020-03-23-11:01
 */
@WebServlet("/requestDemo1")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取字符流
        BufferedReader reader = req.getReader();

        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


    }
}
