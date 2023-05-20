package com.tang.controller;

import com.tang.pojo.Course;
import com.tang.service.CourseService;
import com.tang.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    String email;
    @RequestMapping("toallCourse/{mail}")
    public String toallCourse(@PathVariable("mail")String mail) {
        email = mail;
        return "redirect:/Course/allCourse";
    }
    //显示所有内容
    @RequestMapping("/allCourse")
    public String list(Model model) {
        List<Course> list = courseService.queryAllCourse();
        model.addAttribute("list", list);
        model.addAttribute("email", email);
        return "allCourse";
    }

    //新增内容
    @RequestMapping("toAddCourse")
    public String toAddCourse() {
        return "addCourse";
    }

    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        System.out.println(course.getName());
        int f = courseService.queryamount(course.getName());
        System.out.println(f);
        if (f == 0) courseService.addCourse(course);
        return "redirect:/Course/allCourse";
    }

    //删除内容
    @RequestMapping("/delete/{CourseId}")
    public String deleteCourse(@PathVariable("CourseId") int CourseId) {
        courseService.deleteCourseById(CourseId);
        return "redirect:/Course/allCourse";
    }
    //更新内容
    int updateId = 0;
    @RequestMapping("/toUpdateCourse")
    public String toUpdateCourse(Model model, int id) {
//        System.out.println(courseService.queryById(id).toString());
        updateId = id;
        model.addAttribute("course", courseService.queryById(id));
        return "updateCourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Course course) {
        String name = course.getName() ;
        Course course1 = courseService.queryCourseByName(name);

        System.out.println(updateId);

        int f = courseService.queryamount(course.getName());
        if(f == 0 || (f == 1 && course1.getCourseId() == updateId))courseService.updateCourse(course);
/*        courseService.queryById(course.getCourseId());
        model.addAttribute("course", course);*/
        return "redirect:/Course/allCourse";
    }

    @RequestMapping("/queryCourse")
    public String queryBook(String queryCourseName, Model model) {
        Course course = courseService.queryCourseByName(queryCourseName);
        System.err.println("queryCourseName => " + queryCourseName);
        System.err.println("queryCourse => " + course);
        List<Course> list = new ArrayList<Course>();
        list.add(course);

        if(course==null)
        {
            list = courseService.queryAllCourse();
            System.out.println(list);
            model.addAttribute("err", "未查到");
        }

        model.addAttribute("list", list);
        return "allCourse";
    }
}
