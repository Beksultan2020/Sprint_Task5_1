package kz.bitlab.SPRINT_TASK_1.Controller;

import kz.bitlab.SPRINT_TASK_1.db.DBManager;
import kz.bitlab.SPRINT_TASK_1.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentList {
    @GetMapping(value = "/studentList")
    public String StudentList(Model model){
        List<Student>students= DBManager.getStudents();
        model.addAttribute("students",students);
        return "home";
    }

    @GetMapping(value = "/navbarAddStudent")
    public String navbarAddStudent(){
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name")String name,
                             @RequestParam(name = "surname")String surname,
                             @RequestParam(name = "exam")int exam,Model model)
    {
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        String mark=DBManager.resultMark(exam);
        student.setMark(mark);
        DBManager.addStudent(student);
        return "redirect:/studentList";
    }
}
