package co.mr.restapi02.controller;

import co.mr.restapi02.mapper.StudentMapper;
import co.mr.restapi02.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("")
    public Student post(@RequestBody Student student) {
        studentMapper.insert(student);
        return student;
    }

    @GetMapping("")
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") int id) {
        return studentMapper.getById(id);
    }
}