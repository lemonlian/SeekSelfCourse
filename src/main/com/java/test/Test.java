package main.com.java.test;

import main.com.java.dao.ReptileCourseDao;
import main.com.java.model.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Test {
    @org.junit.Test
    public void test() throws IOException {
        System.out.println(new ReptileCourseDao().getData( 2016211001 ));
    }
}

