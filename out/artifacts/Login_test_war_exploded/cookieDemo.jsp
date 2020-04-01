<%@ page import="cn.cz.domain.User" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user = (User) request.getAttribute("user");
        //打印输出
        if (user != null) {
            response.getWriter().write("登陆成功," + user.getUserName() + ",欢迎你");
        }

        //设置cookie
        Cookie[] cookies = request.getCookies();
        //没有找到cookies的值为lastTime
        boolean flag = false;

        //cookie不为空
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //获取cookie值名
                String name = cookie.getName();
                //判断cookie名是否是lastTime
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("上次登录时间 : " + value);
                    //获取系统时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = simpleDateFormat.format(date);
                    format = URLEncoder.encode(format, "utf-8");

                    //覆盖cookie值
                    cookie.setValue(format);
                    response.addCookie(cookie);
                    //设置cookie的生命周期一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    break;
                }
            }
        }

        //没有找到,说明第一次访问
        if (flag == false || cookies == null || cookies.length == 0) {
            //获取系统时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = simpleDateFormat.format(date);
            format = URLEncoder.encode(format, "utf-8");

            //首次访问
            response.getWriter().write("首次登陆");
            //覆盖cookie值
            Cookie cookie = new Cookie("lastTime",format);
            response.addCookie(cookie);
            //设置cookie的生命周期一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);


        }
    %>
</body>
</html>
