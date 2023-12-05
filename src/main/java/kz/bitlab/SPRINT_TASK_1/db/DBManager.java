package kz.bitlab.SPRINT_TASK_1.db;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    @Getter
    private static List<Student> students=new ArrayList<>();

    private static Long id=6l;

    static {
        students.add(new Student(1l,"Beksultan","Zhalgasov",100,"A"));
        students.add(new Student(2l,"Dinmukhammet","Abdyrassulov ",76,"B"));
        students.add(new Student(3l,"Abilay ","Biarstan",33,"F"));
        students.add(new Student(4l,"Medet","Idrish",55,"D"));
        students.add(new Student(5l,"ErkeAbu","Abu",48,"F"));
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }


    public static String resultMark(Integer exam){
        String result;
        if(exam>=90){
            result="A";
        } else if (exam>=75 && exam<=89) {
            result="B";
        } else if (exam>=60 && exam<=74) {
            result="C";
        } else if (exam>=50 && exam<=59) {
            result="D";
        }
        else {
            result="F";
        }
        return result;
    }
}
