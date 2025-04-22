package org.projects.ahmed;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Servlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter pr = res.getWriter();
        pr.write("hello world 33");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
        public void destroy() {
        System.out.println("destroy");
        }
}