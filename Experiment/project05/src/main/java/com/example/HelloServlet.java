    package com.example;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.io.PrintWriter;

    @WebServlet("/hello")
    public class HelloServlet extends HttpServlet {

        @Override
        public void init() throws ServletException {
            super.init();
            System.out.println("HelloServlet 初始化");
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println("<html>");
                out.println("<head><title>Hello Servlet</title></head>");
                out.println("<body>");
                out.println("<h1>Hello, Servlet!</h1>");

                String name = request.getParameter("name");
                if (name != null && !name.isEmpty()) {
                    out.println("<p>你好, " + name + "!</p>");
                }
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            doGet(request, response);
        }


        @Override
        public void destroy() {
            super.destroy();
            System.out.println("HelloServlet 销毁");
        }
    }