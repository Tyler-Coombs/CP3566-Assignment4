package com.example.assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewStudent (@RequestParam String firstName, @RequestParam String lastName,
                                               @RequestParam String email, @RequestParam String address,
                                               @RequestParam String city, @RequestParam String postal,
                                               @RequestParam String phone) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        studentRepository.save(student);
        return "Student saved.";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path="/view")
    public @ResponseBody Student getStudent(@RequestParam Integer studentID) {
        return studentRepository.findStudentByStudentID(studentID);
    }
}
