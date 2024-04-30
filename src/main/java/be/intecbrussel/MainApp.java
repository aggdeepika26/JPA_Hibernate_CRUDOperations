package be.intecbrussel;

import be.intecbrussel.model.Student;
import be.intecbrussel.service.StudentService;

import java.util.Optional;


public class MainApp {
    public static void main(String[] args) {
        Student student1 = new Student("stuFirst1","studentLast1","stu1@yahoo.com");
        Student student2 = new Student("stuFirst2","studentLast2","stu2@yahoo.com");
        Student student3 = new Student("stuFirst3","studentLast3","stu4@yahoo.com");
        //create
        StudentService studentService = new StudentService();
        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);

        //read
        Optional<Student> studentFind = studentService.findEntity(1);
        if(studentFind.isEmpty())
        {
            System.out.println("Record Not found");
        }


        //Update

        Student updatedStudent = new Student(3,"stuFirst4","stuLast4");
        studentService.updateEntity(updatedStudent);

        //Delete

        studentService.removeEntity(2);

    }
}
