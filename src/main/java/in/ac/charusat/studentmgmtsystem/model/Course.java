package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Course {
    @Id
    private Integer courseID;
    private String title;
    private String description;
     public Course(Integer courseID,String title,String description){
         this.courseID = courseID;
         this.title = title;
         this.description = description;
     }
     public Course (){

     }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
