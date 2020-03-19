package servlet;
import service.impl.userServiceImpl;
import service.userService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/sssServlet")
public class sssServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("userName");
        String pwd=request.getParameter("pwd");
        userService us=new userServiceImpl();
        int count=us.getselect(userName,pwd);
        if(count>0){
            request.getRequestDispatcher("success.jsp?userName="+userName).forward(request,response);
        }else {
            response.sendRedirect("index.jsp");
            // out.print(" <script type='text/javascript'> alert('登录失败!');  location.href='index.jsp';</script>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        doPost(request,response);
    }
}
