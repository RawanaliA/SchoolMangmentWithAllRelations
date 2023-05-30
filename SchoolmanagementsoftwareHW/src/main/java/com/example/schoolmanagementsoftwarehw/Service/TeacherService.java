package com.example.schoolmanagementsoftwarehw.Service;

import com.example.schoolmanagementsoftwarehw.ApiExeption.ApiExeption;
import com.example.schoolmanagementsoftwarehw.Model.Course;
import com.example.schoolmanagementsoftwarehw.Model.Teacher;
import com.example.schoolmanagementsoftwarehw.Repoistory.CourseRepository;
import com.example.schoolmanagementsoftwarehw.Repoistory.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository ;
    private final CourseRepository courseRepository ;

    //  The Crud
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Teacher teacher,Integer id){
        Teacher oTeacher= teacherRepository.findTeacherById(id);
        if(oTeacher==null){
            throw new ApiExeption("teacher not found");
        }
        oTeacher.setName(teacher.getName());
        oTeacher.setAge(teacher.getAge());
        oTeacher.setEmail(teacher.getEmail());
        oTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oTeacher);
    }
    public void getAllDetails(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiExeption("teacher not found");
        }
        teacher.getName();
        teacher.getAge();
        teacher.getEmail();
        teacher.getSalary();

       teacherRepository.save(teacher);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiExeption("teacher not found");
        }

        teacherRepository.delete(teacher);
    }
    public Teacher getTeacherNameByCustmer(Integer Custmer_id){
       return teacherRepository.findTeacherById(courseRepository.findCourseByid(Custmer_id).getId());


    }

}
