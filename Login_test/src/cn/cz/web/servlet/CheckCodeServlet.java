package cn.cz.web.servlet;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 *
 * @author Kartoffel
 * @create 2020-03-28-22:27
 */
@WebServlet("/CheckCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");

        int width = 100;
        int height = 40;
        //1.先定义一个图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        // 2.1 填充背景色
        //  获取画笔对象
        Graphics g = image.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, width, height);

        //   画边框
        g.setColor(Color.gray);
        g.drawRect(0, 0, width - 1, height - 1);

        //   加入文字
        g.setColor(Color.BLUE);
        String str = "0123456789qwertyuiopasdfghjklzxcvbQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            g.drawString(str.charAt(index) + "", width / 5 * i, height / 2);
        }


        //   画出干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //3.向页面写入图片
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
