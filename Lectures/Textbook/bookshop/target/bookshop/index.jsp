<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
    <body>
        <form action="index.jsp" method="post" accept-charset="GB2312">
            请输入书本: <input name="book" type="text">
            <input type="submit" value="添加到购物车">
        </form>
        <hr>
        <%
        ArrayList books = (ArrayList)session.getAttribute("books");
        if(books == null){
            books = new ArrayList();
            session.setAttribute("books", books);
        }

        String book = request.getParameter("book");
        if(book != null){
            books.add(book);
        }
        %>
        购物车的内容是： <br>
        <%
        for(int i = 0; i < books.size(); i++){
            out.println(books.get(i) + "<br>");
        }
        %>
    </body>
</html>