package CompositionClass.CourseService;

import java.util.ArrayList;

public class Student {

    private String name;
    private String id;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    /* Use Case:
    1) Course can be enrolled by the Student.
    e.g. Eileen has registered for the online course service. A list of courses is shown to Eileen for her to choose. Eileen searches for Java course and enrolls for the course. Eileen also enrolls for JavaScript course. Eileen as a Student, has enrolled in 2 Courses (Java, JavaScript).
    2) A student can have many enrolled courses, therefore Student will need to keep track of what enrolled courses that he/she has enrolled in.
    3) Eileen can access her dashboard to check how many courses she has enrolled in.
    4) In Student Class, we need a Collection (e.g. ArrayList) to keep track on the number of enrolled courses for the Student.
    */

    public Student(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
        this.enrolledCourses = enrolledCourses;
    }

    public void unEnroll(Course course) {
        this.enrolledCourses.remove(course);
    }

    //TODO - To return the length of the ArrayList
    public int totalEnrollmentCourses() {
        return this.enrolledCourses.size();
    }

    //TODO - To return the whole ArrayList
    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }


    @Override
    public String toString() {
        return String.format("Student ID: %s, Student Name: %s, Enrolled Courses: ", this.id, this.name) + this.enrolledCourses;
    }

}
