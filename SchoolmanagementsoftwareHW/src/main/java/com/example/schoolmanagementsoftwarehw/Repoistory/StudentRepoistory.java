package com.example.schoolmanagementsoftwarehw.Repoistory;

import com.example.schoolmanagementsoftwarehw.Model.Course;
import com.example.schoolmanagementsoftwarehw.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepoistory extends JpaRepository<Student,Integer> {
    Student getStudentsByid(Integer id);
    List<Student> findStudentsByid(Integer course_id);

}
