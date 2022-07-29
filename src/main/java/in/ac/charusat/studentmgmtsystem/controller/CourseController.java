package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository CourseRepository;


    @GetMapping("/listCourses")
    public List<Course> getAllCourse() {
        return CourseRepository.findAll();
    }

    @GetMapping("/course/{courseID}")
    public Course getCourse(@PathVariable Integer courseID) {
        return CourseRepository.findById(courseID).get();
    }


    @DeleteMapping("/course/{courseID}")
    public List<Course> deleteCourse(@PathVariable Integer courseID) {
        CourseRepository.delete(CourseRepository.findById(courseID).get());
        return CourseRepository.findAll();
    }
    @PostMapping("/course")
    public List<Course> addStudent(@RequestBody Course course) {
        CourseRepository.save(course);
        return CourseRepository.findAll();
    }
    @PutMapping("/course/{courseID}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer courseID) {
        Course courseObj = CourseRepository.findById(courseID).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setDescription(course.getDescription());
        CourseRepository.save(courseObj);
        return CourseRepository.findAll();
    }
}
