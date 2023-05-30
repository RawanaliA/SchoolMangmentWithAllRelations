package com.example.schoolmanagementsoftwarehw.Controller;

import com.example.schoolmanagementsoftwarehw.ApiRecponse.ApiResponce;
import com.example.schoolmanagementsoftwarehw.Model.Course;
import com.example.schoolmanagementsoftwarehw.Model.Teacher;
import com.example.schoolmanagementsoftwarehw.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        List<Course> course=courseService.getAllCourse();
        return ResponseEntity.status(200).body(course);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponce("Teacher added Succssfully!!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Course course, @PathVariable Integer id){
        courseService.updateCourse(course,id);
        return ResponseEntity.status(200).body("teacher Updated Succssfully!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("teacher deleted Succssfully");

    }
    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assighnteacherTocourse(@Valid @PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assighnTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponce("Merchant assighn to Branch "));
    }

}
