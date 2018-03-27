package main.com.java.service;

import main.com.java.dao.ReptileCourseDao;
import main.com.java.model.Course;
import main.com.java.util.CommonUtil;
import main.com.java.util.EnumUtil;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReptileCourseService {
    ReptileCourseDao reptileCourseDao = null;

    public ReptileCourseService() {
        try {
            reptileCourseDao = new  ReptileCourseDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断参数是否是空值
    public boolean checkParam(String param) {
        boolean flag = false;//设置标志位
        if (param == null || "".equals( param )) {
            flag = true;
        }
        return flag;
    }

 public JSONObject ReptileCourse(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
     try {//设置编码的方式
         req.setCharacterEncoding( "utf-8" );
         resp.setCharacterEncoding( "utf-8" );
     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     }
     System.out.println("你好");
     int studentId = Integer.parseInt( req.getParameter( "studentId" ) );
     List<Map<String,String>> courseList = new ArrayList<Map<String,String>>();
     try {
        courseList = reptileCourseDao.getData(studentId);
         System.out.println("请求参数成功！");
         System.out.println(courseList.toString());
         if (courseList == null || courseList.size() <= 0)
             return new CommonUtil().constructResponse( EnumUtil.NO_DATA, "无数据", null );
         else
             return new CommonUtil().constructResponse( EnumUtil.OK, "获取信息成功",courseList );

     } catch (Exception e) {
         return new CommonUtil().constructResponse( EnumUtil.SQL_FAILURE, "获取信息失败", null );
     }
 }
}
