package com.example.schoolmanagementsoftwarehw.Controller;

import com.example.schoolmanagementsoftwarehw.ApiRecponse.ApiResponce;
import com.example.schoolmanagementsoftwarehw.Model.Student;
import com.example.schoolmanagementsoftwarehw.Model.Teacher;
import com.example.schoolmanagementsoftwarehw.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
 private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        List<Student> students=studentService.getAllStudent();
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student ){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponce("Student added Succssfully!!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student  student, @PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("teacher Updated Succssfully!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudnt(@Valid@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted Succssfully");

    }
@GetMapping("/get_Student/{id}")
public ResponseEntity assighnCourseToStudent(@Valid@PathVariable Integer student_id,Integer course_id){
    studentService.assighnCourseToStudent(student_id,course_id);
    return ResponseEntity.status(200).body("assighned done Sucssufuly");
}
    @PutMapping("/update-major/{id}")
    public ResponseEntity updateMajor(@Valid @RequestBody Student student, @PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("student Updated");
    }

    @GetMapping("/get_Student/{id}")
    public ResponseEntity getStudentBy(@Valid@PathVariable Integer id){
       List<Student> student=studentService.findStudentByID(id);
        return ResponseEntity.status(200).body(student);
    }


}
