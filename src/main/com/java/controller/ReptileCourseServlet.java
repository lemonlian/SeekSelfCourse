package main.com.java.controller;

import main.com.java.service.ReptileCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ReptileCourseServlet")
public class ReptileCourseServlet extends HttpServlet {
    public ReptileCourseService reptileCourseService = null;
    public ReptileCourseServlet(){
        reptileCourseService = new ReptileCourseService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        try {
            pw.print(reptileCourseService.ReptileCourse( request,response ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost( request,response );
    }
}
