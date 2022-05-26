package CompositionClass.CourseService;

import java.util.*;

/*
Guide: https://jenkov.com/tutorials/java-collections/map.html
*/

public class CourseService {

    private HashMap<String, Student> students;
    private HashMap<String, Course> courses;

    private ArrayList<Course> myCourses;

    //Constructor
    public CourseService() {

        //Create courses
        Course java = new Course("JAVA1", "Introduction to Java", 5);
        Course css = new Course("CSS1", "Introduction to CSS", 4);
        Course html = new Course("HTML1", "Introduction to HTML", 3);
        Course javascript = new Course("JS1", "Introduction to JavaScript", 5);

        //HashMap for courses
        courses = new HashMap<>();
        courses.put(java.getId(), java);
        courses.put(css.getId(), css);
        courses.put(html.getId(), html);
        courses.put(javascript.getId(), javascript);

        //Create students
        Student eileen = new Student("Eileen Tan", "S001");
        Student cola = new Student("Cola Tan", "S002");
        Student coffee = new Student("Coffee Black", "S003");

        //HashMap for students
        students = new HashMap<>();
        students.put(eileen.getId(), eileen);
        students.put(cola.getId(), cola);
        students.put(coffee.getId(), coffee);

    }

    //Getter and Setter Methods

        public HashMap<String, Student> getStudents() {
            return students;
        }

        public void setStudents(HashMap<String, Student> students) {
            this.students = students;
        }

        public HashMap<String, Course> getCourses() {
            return courses;
        }

        public void setCourses(HashMap<String, Course> courses) {
            this.courses = courses;
        }

    //Other Methods

        // Boolean checkCourseKey() - To check if user input ID matches a key in courses
            public boolean checkCourseKey(String courseID) {
                if (courses.containsKey(courseID)) { return true; }
                else { return false; }
            }

        // Boolean checkStudentKey() - To check if user input ID matches a key in students
            public boolean checkStudentKey(String studentID) {
                if (students.containsKey(studentID)) { return true; }
                else { return false; }
            }

        // addCourse() Method - To add a new course into the course database
        //TODO - To add a new course to the ArrayList
            public void addCourse(String id, String name, int credits)
            {
                Course newCourse = new Course(id, name, credits);
                if (checkCourseKey(id) == true) {
                    System.out.println(String.format("Error! Course ID [ %s ] already exists, please check and try again.", id));
                }
                else {
                    courses.put(id, newCourse);
                    System.out.println(String.format("New course [ %s: %s (%d Credits) ] has been added.", id, name, credits));
                }
            }
            /*  Alternative Solution for addCourse():
            Here I can also create a new HashMap named "newCourses", set up the steps to add new course, then use putAll() to insert all elements from my new map into the original HashMap named "courses".

            HashMap<String, Course> newCourses = new HashMap<>();
            newCourses.put(id, newCourse);
            courses.putAll(newCourses);
            */

        // addCoursePrompt() Method - To add a new course into the course database using scanner prompt input
            public void addCoursePrompt()
            {
                System.out.println("\n<< Add a New Course >>");

                Scanner scanCourseID = new Scanner(System.in);
                System.out.print("Please enter a new Course ID: ");
                String newCourseID = scanCourseID.nextLine();

                Scanner scanCourseName = new Scanner(System.in);
                System.out.print("Please enter the new Course Name: ");
                String newCourseName = scanCourseName.nextLine();

                Scanner scanCourseCredits = new Scanner(System.in);
                System.out.print("Please enter the new Course Credits: ");
                int newCourseCredits = scanCourseCredits.nextInt();

                addCourse(newCourseID, newCourseName, newCourseCredits);
            }

        // removeCourse() Method - To remove an existing course from the course database
        //TODO - To remove the specified course from the ArrayList
            public void removeCourse(String id)
            {

                if (checkCourseKey(id) == true) {
                    /* Alternative Method:
                    //Use Iterator's remove() method if we need to avoid java.util.ConcurrentModfiicationException in Java.
                    //Guide: https://www.java67.com/2017/06/how-to-remove-entry-keyvalue-from-HashMap-in-java.html
                    Iterator<String> iterator = courses.keySet().iterator();
                    while(iterator.hasNext()){
                        String certification = iterator.next();
                        if(certification.contains(id)) {
                            iterator.remove();
                        }
                    }
                    */
                    Course removedCourse = courses.get(id);
                    courses.remove(id, removedCourse);
                    System.out.println(String.format("Course [ ID: %s ] has been removed.", id));
                }
                else {
                    System.out.println(String.format("Error! Course ID [ %s ] does not exist, please check and try again.", id));
                }
            }

        // updateCourse() Method - To allow user to update course information using scanner prompt commands
            public void updateCourse(String id)
            {
                if (checkCourseKey(id) == true)
                {
                    Scanner scanInput = new Scanner(System.in);
                    System.out.print(String.format("Do you want to update information for Course ID [ %s ]? Enter Y/N : ", id));
                    String choice = scanInput.nextLine();
                    String changeInfo = choice;
                    switch (changeInfo) {
                        //Typing "Y" key will prompt the user to enter changes for the values in Course
                        case "Y":
                            //Update Course ID
                            String courseID = courses.get(id).getId();
                            Scanner scanInputID = new Scanner(System.in);
                            System.out.print(String.format("Update Course ID: [ %s ] to: ", courseID));
                            String newCourseID = scanInputID.nextLine();
                            courses.get(id).setId(newCourseID);

                            //Update Course Name
                            String courseName = courses.get(id).getName();
                            Scanner scanInputName = new Scanner(System.in);
                            System.out.print(String.format("Update Course Name: [ %s ] to: ", courseName));
                            String newCourseName = scanInputName.nextLine();
                            courses.get(id).setName(newCourseName);

                            //Update Course Credits
                            int courseCredits = courses.get(id).getCredits();
                            Scanner scanInputCredits = new Scanner(System.in);
                            System.out.print(String.format("Update Course Credits: [ %d ] to: ", courseCredits));
                            int newCourseCredits = scanInputCredits.nextInt();
                            courses.get(id).setCredits(newCourseCredits);

                            //Print successful transaction message and terminate switch loop
                            Course updatedCourse = courses.get(id);
                            System.out.println(String.format("Changes have been saved as [ %s ]", updatedCourse));
                            break;

                        //Typing any key other than "Y" will stop the update and exit function
                        default:
                            System.out.println("Exiting function, no changes have been made.");
                            break;
                    }
                }
                else
                {
                    System.out.println(String.format("Error! Course ID [ %s ] does not exist, please check and try again.", id));
                }
            }

        // getCourse() Method - To get and display all courses' information in the database
            public void getCourse()
            {
                System.out.println("Course Catalogue:");
                int index = 0;
                for (String key: courses.keySet()) {
                    ++index;
                    System.out.println("Course #" + index + " [ " + courses.get(key) + " ] ");
                }
            }

        // findCourse() Method - To find and display a course's information via the course ID, case-sensitive
            public void findCourse(String courseID)
            {
                System.out.println("Course Search Results:");
                Course searchResult = courses.get(courseID);
                //if (searchResult != null) {
                if (checkCourseKey(courseID) == true) {
                    System.out.println("[ " + searchResult + " ]");
                } else {
                    System.out.println("Course ID [ " + courseID + " ] does not exist in the database.");
                }
            }

        // findCoursePrompt() Method - To find a course via the course ID using scanner prompt input, case-sensitive
            public void findCoursePrompt()
            {
                System.out.println("\n<< Search for Course ID >>");

                Scanner scanCourseID = new Scanner(System.in);
                System.out.print("Please enter a new Course ID: ");
                String courseID = scanCourseID.nextLine();

                findCourse(courseID);
            }

        // enrollCourseToStudent() Method
        //TODO - To enroll the course to the student with the course Id, and student Id that passed in as the parameters. Add the course to the student's enrolledCourses ArrayList
            public void enrollCourseToStudent(String studentID, String courseID)
            {
                if (checkCourseKey(courseID) == true && checkStudentKey(studentID) == true) {
                    Course enrollCourse = courses.get(courseID);
                    students.get(studentID).enroll(enrollCourse);
                    System.out.println(String.format("Student ID [ %s ] has enrolled for Course ID [ %s ].", studentID, courseID));
                }
                else {
                    System.out.println(String.format("Student ID [ %s ] and/or Course ID [ %s ] are incorrect, please check and try again.", studentID, courseID));
                }
            }

        // unEnrollCourseFromStudent() Method
        //TODO - To un-enroll the course from the student with the course Id, and student Id. Remove the course to the student's enrolledCourses ArrayList
            public void unEnrollCourseFromStudent(String studentID, String courseID)
            {
                if (checkCourseKey(courseID) == true && checkStudentKey(studentID) == true) {
                    Course unEnrollCourse = courses.get(courseID);
                    students.get(studentID).unEnroll(unEnrollCourse);
                    System.out.println(String.format("Student ID [ %s ] has un-enrolled from Course ID [ %s ].", studentID, courseID));
                }
                else {
                    System.out.println(String.format("Student ID [ %s ] and/or Course ID [ %s ] are incorrect, please check and try again.", studentID, courseID));
                }
            }

        // displayStudentInformation() Method - To find and display a student's information via the student ID, case-sensitive
        //TODO - To return student's detail with the student ID passes in from the parameter
            public void displayStudentInformation(String studentID)
            {
                System.out.println("Student Search Results:");
                Student searchResult = students.get(studentID);
                //if (searchResult != null) {
                if (checkStudentKey(studentID) == true) {
                    System.out.println("[ " + searchResult + " ]");
                } else {
                    System.out.println("Student ID [ " + studentID + " ] does not exist in the database.");
                }
            }

        // totalEnrolledCourse() Method - To show the total number of courses enrolled for the student ID
        //TODO - To return the number of enrolled courses from a student with the student ID passes in from the parameter
            public void totalEnrolledCourse(String studentID)
            {
                if (checkStudentKey(studentID) == true) {
                    int totalCourses = students.get(studentID).totalEnrollmentCourses();
                    System.out.println("Course Enrollment Status:");
                    System.out.println(String.format("[ Student ID: %s, Number of Courses Enrolled: %d ]", studentID, totalCourses));

                    myCourses = myCourses(studentID);
                    System.out.println("My Courses: \n" + myCourses);
                }
                else {
                    System.out.println("Student ID [ " + studentID + " ] does not exist in the database.");
                }
            }

        // myCourses() Method - To get an ArrayList of all the courses enrolled by a student using the student ID as a parameter
            public ArrayList<Course> myCourses(String studentID)
            {
                myCourses = students.get(studentID).getEnrolledCourses();
                return myCourses;
            }

        // totalCredit(studentId:String):int
        //TODO return the total credit of a student with the student ID passes in from the parameter
            public int totalCredit(String studentID) {

                myCourses = myCourses(studentID);
                int credits = 0;

                for (int i = 0; i < myCourses.size(); i++) {
                    int additionalCredits = myCourses.get(i).getCredits();
                    credits = credits + additionalCredits;
                }

                System.out.println("Course Enrollment Credits:");
                System.out.println(String.format("[ Student ID: %s, Total Course Credits: %d ]", studentID, credits));
                return credits;
            }

        // addStudent() Method - To add a new student into the student database
        //TODO - To be able to add a new student to the CourseService Center
            public void addStudent(String name, String id)
            {
                if (checkStudentKey(id) == true) {
                    System.out.println(String.format("Error! Student ID [ %s ] already exists, please check and try again.", id));
                }
                else {
                    Student newStudent = new Student(name, id);
                    students.put(id, newStudent);
                    System.out.println(String.format("New student [ ID: %s, Name: %s) ] has been added.", id, name));
                }
            }

        // removeStudent() Method - To remove an existing student from the student database
            public void removeStudent(String id)
            {
                if (checkStudentKey(id) == true) {
                    /* Alternative Method:
                    //Use Iterator's remove() method if we need to avoid java.util.ConcurrentModfiicationException in Java.
                    Iterator<String> iterator = students.keySet().iterator();
                    while (iterator.hasNext()) {
                        String certification = iterator.next();
                        if (certification.contains(id)) { iterator.remove(); }
                    }
                    */
                    Student removedStudent = students.get(id);
                    students.remove(id, removedStudent);
                    System.out.println(String.format("Student [ ID: %s ] has been removed.", id));
                }
                else {
                    System.out.println(String.format("Error! Student ID [ %s ] does not exist, please check and try again.", id));
                }
            }

        // updateStudent() Method - To allow user to update student information using scanner prompt commands
            public void updateStudent(String id)
            {
                if (checkStudentKey(id) == true)
                {
                    Scanner scanInput = new Scanner(System.in);
                    System.out.print(String.format("Do you want to update information for Student ID [ %s ]? Enter Y/N : ", id));
                    String choice = scanInput.nextLine();
                    String changeInfo = choice;
                    switch (changeInfo) {
                        //Typing "Y" key will prompt the user to enter changes for the values in Student
                        case "Y":
                            //Update Student ID
                            String studentID = students.get(id).getId();
                            Scanner scanInputID = new Scanner(System.in);
                            System.out.print(String.format("Update Student ID: [ %s ] to: ", studentID));
                            String newStudentID = scanInputID.nextLine();
                            students.get(id).setId(newStudentID);

                            //Update Student Name
                            String studentName = students.get(id).getName();
                            Scanner scanInputName = new Scanner(System.in);
                            System.out.print(String.format("Update Student Name: [ %s ] to: ", studentName));
                            String newStudentName = scanInputName.nextLine();
                            students.get(id).setName(newStudentName);

                            //Print successful transaction message and terminate switch loop
                            Student updatedStudent = students.get(id);
                            System.out.println(String.format("Changes have been saved as [ %s ]", updatedStudent));
                            break;

                        //Typing any key other than "Y" will stop the update and exit function
                        default:
                            System.out.println("Exiting function, no changes have been made.");
                            break;
                    }
                }
                else
                {
                    System.out.println(String.format("Error! Student ID [ %s ] does not exist, please check and try again.", id));
                }
            }

        // getAllStudents() Method - To get and display all the students' information in the database
            public void getAllStudents()
            {
                System.out.println("Student Database:");
                int index = 0;
                for (String key : students.keySet()) {
                    ++index;
                    System.out.println("Student #" + index + " [ " + students.get(key) + " ] ");
                }
            }

}
