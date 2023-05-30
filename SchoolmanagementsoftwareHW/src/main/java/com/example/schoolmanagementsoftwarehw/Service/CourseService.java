package com.example.schoolmanagementsoftwarehw.Service;
import com.example.schoolmanagementsoftwarehw.ApiExeption.ApiExeption;
import com.example.schoolmanagementsoftwarehw.DTO.AdressDto;
import com.example.schoolmanagementsoftwarehw.Model.Address;
import com.example.schoolmanagementsoftwarehw.Model.Course;
import com.example.schoolmanagementsoftwarehw.Model.Teacher;
import com.example.schoolmanagementsoftwarehw.Repoistory.CourseRepository;
import com.example.schoolmanagementsoftwarehw.Repoistory.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    //  The Crud
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course ){
        courseRepository.save(course);
    }
    public void updateCourse(Course course,Integer id){
        Course course1= courseRepository.findCourseByid(id);
        if(course1==null){
            throw new ApiExeption("Course not found");
        }
      course1.setName(course.getName());
        courseRepository.save(course1);
    }
    public void deleteCourse(Integer id){
       Course course= courseRepository.findCourseByid(id);
        if(course==null){
            throw new ApiExeption("Courses not found");
        }

        courseRepository.delete(course);
    }
    public void assighnTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher =teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseByid(course_id);
        if(teacher==null||course==null){
            throw new ApiExeption("Merchant Or Branch are Null");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
//    public void updateAdress(AdressDto dto){
//        Teacher teacher = courseRepository.findCourseByid(dto.getTeacher_id());
//        if (teacher == null) {
//            throw new ApiExeption("Can not add Address ,Address not found");
//        }
//        Address address=adressRepository.getAddressById(dto.getTeacher_id());
//
//        address.setArea(dto.getArea());
//        address.setStreet(dto.getStreet());
//        address.setBuildingNumber(teacher.getSalary());
//        adressRepository.save(address);
    }


