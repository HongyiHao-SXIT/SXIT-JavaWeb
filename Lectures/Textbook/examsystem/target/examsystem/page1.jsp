<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF - 8">
    <title>page1.jsp</title>
</head>
<body>
<form action="answer.jsp" method="post">
    考号:
    <input type="text" name="id"/>
    <p>
        一、单项选择题(每题2分)
        <br/><br/>
        1. 下列哪个方法是获取`session`中关键字是`key`的对象().
        <br/>
        <input type="radio" name="one" value="A"/> A. public void setAttribute( String key, Object obj)<br/>
        <input type="radio" name="one" value="B"/> B. public void removeAttribute(String key)<br/>
        <input type="radio" name="one" value="C"/> C. public Enumeration getAttributeNames()<br/>
        <input type="radio" name="one" value="D"/> D. public Object getAttribute(String key)<br/>
    </p>
    <p>
        2. 在Java Web中，`EL`表达式是在（  ）中使用的。
        <br/>
        <input type="radio" name="two" value="A"/> A. JSP页面
        <input type="radio" name="two" value="B"/> B. Servlet
        <input type="radio" name="two" value="C"/> C. JavaBean
        <input type="radio" name="two" value="D"/> D. HTML页面
    </p>
    <p>
        3. `JSP`中`out`对象的`println()`方法用于（  ）。
        <br/>
        <input type="radio" name="three" value="A"/> A. 向浏览器输出数据
        <input type="radio" name="three" value="B"/> B. 向服务器输出数据
        <input type="radio" name="three" value="C"/> C. 向控制台输出数据
        <input type="radio" name="three" value="D"/> D. 向文件输出数据
    </p>
    <p>
        二、判断题(每题2分)<br/><br/>
        1. 同一用户在多个Web服务中，所对应的`session`对象是互不相同的.<br/>
        True <input type="radio" name="four" value="True"/>
        False <input type="radio" name="four" value="False"/>
    </p>
    <p>
        2. `Servlet`中`init()`方法在每次处理请求时都会被调用。
        <br/>
        True <input type="radio" name="five" value="True"/>
        False <input type="radio" name="five" value="False"/>
    </p>
    <p>
        3. 在`JSP`页面中可以直接使用`request`对象获取客户端提交的数据。
        <br/>
        True <input type="radio" name="six" value="True"/>
        False <input type="radio" name="six" value="False"/>
    </p>
    <input type="submit" value="提交" name="submit">
    <input type="reset" value="重置" name="reset">
</form>
</body>
</html>