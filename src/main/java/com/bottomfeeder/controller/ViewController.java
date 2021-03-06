package com.bottomfeeder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "viewController",
    urlPatterns = {"/view/*"},
    initParams = @WebInitParam(name = "renderer-class-name", value = "com.logicbig.HtmlRenderer"),
    loadOnStartup = 1)
public class ViewController extends HttpServlet {
    /**
   *
   */
  private static final long serialVersionUID = -5864420539432084779L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String renderer = getServletConfig().getInitParameter("renderer-class-name");
        PrintWriter writer = resp.getWriter();
        writer.println("renderer: " + renderer);

        String servletName = getServletConfig().getServletName();
        writer.println("servlet name " + servletName);
    }
}
