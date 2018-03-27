package main.com.java.dao;

import main.com.java.model.Course;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReptileCourseDao {
    public  List<Map<String,String>>getData(int studentId) throws IOException {
        List< Map<String,String>>coursesList = new ArrayList <Map<String, String>>( );
        Map<String,String> courseMap = null;
        //从web中获取和解析html文档,获取编辑推荐页
        Document document= Jsoup.connect("http://jwzx.cqupt.edu.cn/jwzxtmp/kebiao/kb_stu.php?xh="+studentId)
                //模拟火狐浏览器
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .get();
        if (document!=null){
            Element element = document.getElementById( "kbStuTabs-list");//定位到数据
            Elements trs = element.select( "tr" );
            //以下是提取课表的信息
            for (int i =1;i<trs.size();i++){
                //获取一个tr
                Elements tds = trs.get( i ).select( "td" );
                try{
                    courseMap =new HashMap <>( );
                    courseMap.put( "teachingClass",tds.get( 0 ).text()  );
                    courseMap.put( "courseIdAndCourseName",tds.get( 1).text() );
                    courseMap.put( "courseCategory",tds.get( 2 ).text() );
                    courseMap.put( "classClassification",tds.get( 3 ).text()   );
                    courseMap.put( "courseSelectionState", tds.get( 4 ).text() );
                    courseMap.put( "courseTeacher", tds.get( 5 ).text()  );
                    courseMap.put( "courseAddress",tds.get( 6 ).text() );
                    courseMap.put( "courseTime",tds.get( 7 ).text()   );
                    courseMap.put( "courseStudent",tds.select("a[href]").first().attr("href")  );
                    courseMap.put( "remark", tds.get(9 ).text()  );
                    coursesList.add( courseMap );
                }catch (Exception e){
                    continue;
                }
            }
        }
        return coursesList;//返回课程的信息
    }
}
