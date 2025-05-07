<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>count.jsp</title>
</head>
<body>
    This is the checkout counter. Please confirm the following information.
    <p>
        <%
            String no = (String) session.getAttribute("no");
            out.println("Your membership card number is: " + no);

            Enumeration<String> enumGoods = session.getAttributeNames();
            out.println("<br>List of goods in the shopping cart: <br>");
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