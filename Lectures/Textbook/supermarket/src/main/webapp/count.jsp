<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>count.jsp</title>
</head>
<body>
    这里是结账柜台，请确认以下信息
    <p>
        <%
            String no = (String) session.getAttribute("no");
            out.println("您的会员卡号是： " + no);

            // 这里虽然在 page 指令里导入了 java.util.*，但为了代码清晰，可明确写出导入语句
            Enumeration<String> enumGoods = session.getAttributeNames();
            out.println("<br>购物车中的商品清单： <br>");
            while (enumGoods.hasMoreElements()) {
                String key = enumGoods.nextElement();
                String good = (String) session.getAttribute(key);

                if (!(good.equals(no))) {
                    out.println("&nbsp;&nbsp;" + good + "<br>");
                    session.removeAttribute(key);
                }
            }
        %>
    </p>
</body>
</html>    