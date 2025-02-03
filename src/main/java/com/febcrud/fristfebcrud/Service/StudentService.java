package com.febcrud.fristfebcrud.Service;

import com.febcrud.fristfebcrud.Entity.StudentEntity;
import com.febcrud.fristfebcrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;

    public ResponseEntity saveStudentDetails(StudentEntity studentEntity) {
        System.out.println("no issue in service");
        StudentEntity res = studentRepository.save(studentEntity);
        System.out.println(res.getGender());
        return ResponseEntity.ok().body(res);

    }

    public StudentEntity findStudentById(int id) {
        StudentEntity res = studentRepository.findById(id).get();
        return res;
    }

    public StudentEntity updateStudentDetails(StudentEntity studentEntity) {
        Long  studentId = studentEntity.getId();
        if(studentRepository.existsById(Math.toIntExact(studentId))){
            studentEntity = studentRepository.findById(Math.toIntExact(studentId)).get();
            studentEntity.setName(studentEntity.getName());
            studentEntity.setAge(studentEntity.getAge());
            studentEntity.setGender(studentEntity.getGender());
        }
        return studentRepository.save(studentEntity);
        }

    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "student has been deleted";
    }
}

