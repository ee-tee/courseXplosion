package CompositionClass.CourseService;

public class Course {

    private String name;
    private String id;
    private int credits;

    public Course(String id, String name, int credits)
    {
        this.id = id;
        this.name = name;
        this.credits = credits;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


    @Override
    public String toString() {
        return String.format("Course ID: %s, Name: %s, Credits: %d", this.id, this.name, this.credits);
    }

}
