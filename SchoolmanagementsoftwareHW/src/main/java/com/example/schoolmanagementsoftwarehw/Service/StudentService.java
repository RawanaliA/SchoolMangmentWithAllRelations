package com.example.schoolmanagementsoftwarehw.Service;

import com.example.schoolmanagementsoftwarehw.ApiExeption.ApiExeption;
import com.example.schoolmanagementsoftwarehw.Model.Course;
import com.example.schoolmanagementsoftwarehw.Model.Student;
import com.example.schoolmanagementsoftwarehw.Model.Teacher;
import com.example.schoolmanagementsoftwarehw.Repoistory.CourseRepository;
import com.example.schoolmanagementsoftwarehw.Repoistory.StudentRepoistory;
import com.example.schoolmanagementsoftwarehw.Repoistory.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepoistory studentRepoistory;
    private final CourseRepository courseRepository;


    //  The Crud
    public List<Student> getAllStudent(){
        return studentRepoistory.findAll();
    }
    public void addStudent(Student student){
        studentRepoistory.save(student);
    }
    public void updateStudent(Student student ,Integer id){
        Student student1 = studentRepoistory.getStudentsByid(id);
        if(student1==null){
            throw new ApiExeption("Student not found");
        }
        student1.setName(student.getName());
        student1.setMajor(student.getMajor());
        student1.setAge(student.getAge());
        studentRepoistory.save(student1);
    }
    public void deleteStudent(Integer id){
        Student student= studentRepoistory.getStudentsByid(id);
        if(student==null){
            throw new ApiExeption("Courses not found");
        }
        studentRepoistory.delete(student);
    }
//    public void
public void assighnCourseToStudent(Integer student_id,Integer course_id){
    Student student  =studentRepoistory.getStudentsByid(student_id);
    Course course=courseRepository.findCourseByid(course_id);
    if(student==null||course==null){
        throw new ApiExeption("Merchant Or Branch are Null");
    }
    student.getCourset().add(course);
    course.getStudents().add(student);

    studentRepoistory.save(student);
    courseRepository.save(course);
}
    public void updateStudentmajor(Integer id,String major) {
        Student student1 = studentRepoistory.getStudentsByid(id);
        Course course = courseRepository.getCourseByName(major);
        if (student1 == null) {
            throw new ApiExeption("Student not found");
        }
        student1.setMajor(major);
        student1.getCourset().remove(course.getStudents());

    }
    public List<Student> findStudentByID(Integer custmer_id){
        Course course=courseRepository.findCourseByid(custmer_id);
        List<Student> students=studentRepoistory.findStudentsByid(custmer_id);
        return  students;

    }
}
