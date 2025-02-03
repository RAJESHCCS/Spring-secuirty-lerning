package com.febcrud.fristfebcrud.Controller;

import com.febcrud.fristfebcrud.Entity.StudentEntity;
import com.febcrud.fristfebcrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity saveDetails(@RequestBody StudentEntity studentEntity){
        try {
            ResponseEntity result = studentService.saveStudentDetails(studentEntity);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findStudent")
    public ResponseEntity findStudent(@RequestParam("id") int id){
        try {
            StudentEntity res = studentService.findStudentById(id);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("updateStudentDetails")
    public ResponseEntity updateDetails(@RequestBody StudentEntity studentEntity){
    try {
        StudentEntity res = studentService.updateStudentDetails(studentEntity);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
    @DeleteMapping("deleteById")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        try{
            String response = String.valueOf(studentService.deleteStudentById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
