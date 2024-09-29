package com.myproject.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //telling the java app -->this class will contain API endpoints
//controller , api layer
public class StudentApi {


    //Database
    HashMap<Integer ,Student> studentDb = new HashMap<>();

    //Add a Student

    @PostMapping("/add_student")
    public  String addStudent(@RequestBody() Student student){
        int key = student.id;
        studentDb.put(key,student);

        return "Student added successfully";
    }

    //get students BY id

    @GetMapping("/get_student_by_id")
    public Student getStudent(@RequestParam("id")Integer id){

        return studentDb.get(id);
    }
  // get student by name

    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name")String studentName){
        for (Student stu : studentDb.values()){
            if(stu.studentName.equals(studentName)){
                return stu;
            }
        }
         return null;

    }
    // update the student
    @PutMapping("/update_student")
    public  String updateStudent(@RequestBody() Student student){
        int key = student.id;
        studentDb.put(key,student);

        return "Student updated successfully";
    }

    // remove the student

    @DeleteMapping("/delete_student")
    public String deleteString(@RequestParam("id")Integer id){

        studentDb.remove(id);
        return "student deleted successfully";
    }
   // get By Path

    @GetMapping("/get_by_path/{id}")
    public Student getStudentByPath(@PathVariable("id")Integer id){

        return studentDb.get(id);
    }
}
