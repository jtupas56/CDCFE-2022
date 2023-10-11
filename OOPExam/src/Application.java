public class Application {
    private String courseName;
    private int courseID;

    public Application(String courseName, int courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }//end constructor



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Application(" +
                "Course: " + courseName + ", Course ID: " + courseID+", ";
    }
}
