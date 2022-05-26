package CompositionClass.CourseService;

//Exercise 3: A Course Service “has’ Courses and Students. A Student “has’ Enrolled Courses.
//README: https://docs.google.com/document/d/1hCjb3Q1Bqh7fP0USPvN7o6p_R7G0YztV/edit#heading=h.tyjcwt

//Java Collections and Class Challenge Practice
//README: https://docs.google.com/document/d/1tc8HVrXXSDEUO3dtecDnhQPZA-dc-af9/edit#

public class Main {

    public static void main(String[] args) {

        //Create instance of CourseService Object

            CourseService courseXplosion = new CourseService();

        // ------ Complete List of Methods ------
        /*
        1) Adding New Course
        1a) Extra: Add New Course - Using Scanner Prompt
        2) Removing Existing Course
        3) Updating Existing Course - Using Scanner Prompt
        4) Getting All Course Information
        5) Finding a Course
        6) Adding New Student
        7) Removing Existing Student
        8) Updating Existing Student Information - Using Scanner Prompt
        9) Enrolling Course to Student
        10) Un-enrolling Course from Student
        11) Getting All Student Information
        12) Displaying Student Information
        13) Checking Total Number of Courses Enrolled for Student
        14) Checking Total Course Credits for Student
        */

        // --- Implement Methods for Courses ---

        //Getting All Course Information (Initial Launch)

            System.out.println("\n>>>>> Initial Launch: Getting All Course Information >>>>>\n");
            courseXplosion.getCourse();

        //Adding New Course

            System.out.println("\n>>>>> Perform Action: Adding New Courses >>>>>\n");
            courseXplosion.addCourse("SQL1", "Introduction to SQL", 4); //Show successful transaction
            courseXplosion.addCourse("SQL1", "Introduction to SQL", 4); //Show error for duplicate ID
            courseXplosion.addCourse("HTML2", "HTML 404: Error No More", 1);
            courseXplosion.addCourse("JAVA2", "Java for Dummies", 1);
            courseXplosion.addCourse("JS2", "JavaScript is Dead", 1);

            //Extra: Add New Course - Using Scanner Prompt
            //Remove the comment-off below to enable method
            courseXplosion.addCoursePrompt();

        //Removing Existing Course

            System.out.println("\n>>>>> Perform Action: Removing Existing Courses >>>>>\n");
            courseXplosion.removeCourse("JS");  //Show error for incorrect ID
            courseXplosion.removeCourse("JS2"); //Show successful transaction

        //Updating Existing Course - Using Scanner Prompt
            System.out.println("\n>>>>> Perform Action: Updating Existing Courses >>>>>\n");
            courseXplosion.updateCourse("HTML2");

        //Getting All Course Information

            System.out.println("\n>>>>> Perform Action: Getting All Course Information >>>>>\n");
            courseXplosion.getCourse();

        //Finding a Course

            System.out.println("\n>>>>> Perform Action: Finding a Course >>>>>\n");
            courseXplosion.findCourse("JAVA");  //Show error for incorrect ID
            courseXplosion.findCourse("JAVA1"); //Show successful transaction
            //courseXplosion.findCoursePrompt();


        // --- Implement Methods for Students ---

        //Getting All Student Information (Initial Launch)

            System.out.println("\n>>>>> Initial Launch: Getting All Student Information >>>>>\n");
            courseXplosion.getAllStudents();

        //Adding New Student

            System.out.println("\n>>>>> Perform Action: Adding New Students >>>>>\n");
            courseXplosion.addStudent("Boba Tea", "S001");      //Show error for incorrect ID
            courseXplosion.addStudent("Boba Tea", "S004");      //Show successful transaction
            courseXplosion.addStudent("Jean Looi", "S005");

        //Removing Existing Student

            System.out.println("\n>>>>> Perform Action: Removing Existing Students >>>>>\n");
            courseXplosion.removeStudent("S000");       //Show error for incorrect ID
            courseXplosion.removeStudent("S005");       //Show successful transaction

        //Updating Existing Student Information - Using Scanner Prompt

            System.out.println("\n>>>>> Perform Action: Updating Existing Student Information >>>>>\n");
            courseXplosion.updateStudent("S003");

        //Getting All Student Information - Before Course Enrollment

            System.out.println("\n>>>>> Perform Action: Getting All Student Information (Before Course Enrollment) >>>>>\n");
            courseXplosion.getAllStudents();

        //Enrolling Course to Student

            System.out.println("\n>>>>> Perform Action: Enrolling Course to Student >>>>>\n");
            courseXplosion.enrollCourseToStudent("S000", "JAVA1");      //Show error for incorrect ID
            courseXplosion.enrollCourseToStudent("S001", "JAVA1");      //Show successful transaction
            courseXplosion.enrollCourseToStudent("S001", "JS1");
            courseXplosion.enrollCourseToStudent("S001", "SQL1");
            courseXplosion.enrollCourseToStudent("S002", "HTML1");
            courseXplosion.enrollCourseToStudent("S003", "CSS1");
            courseXplosion.enrollCourseToStudent("S004", "JAVA2");

        //Un-enrolling Course from Student

            System.out.println("\n>>>>> Perform Action: Un-enrolling Course from Student >>>>>\n");
            courseXplosion.unEnrollCourseFromStudent("S001", "SQLL");   //Show error for incorrect ID
            courseXplosion.unEnrollCourseFromStudent("S001", "SQL1");   //Show successful transaction

        //Getting All Student Information - After Course Enrollment

            System.out.println("\n>>>>> Perform Action: Getting All Student Information (After Course Enrollment) >>>>>\n");
            courseXplosion.getAllStudents();

        //Displaying Student Information

            System.out.println("\n>>>>> Perform Action: Displaying Student Information >>>>>\n");
            courseXplosion.displayStudentInformation("S001");

        //Checking Total Number of Courses Enrolled for Student

            System.out.println("\n>>>>> Perform Action: Checking Total Number of Courses Enrolled for Student >>>>>\n");
            courseXplosion.totalEnrolledCourse("S001");

        //Checking Total Course Credits for Student

            System.out.println("\n>>>>> Perform Action: Checking Total Course Credits for Student >>>>>\n");
            courseXplosion.totalCredit("S001");

    }

}
