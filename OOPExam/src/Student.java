public class Student extends Application {
    private String studentName;
    private int studentID;
    private String studentEmail;

    public Student(String courseName, int courseID, String studentName, int studentID, String studentEmail) {
        super(courseName,courseID);
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentEmail = studentEmail;
    }//end constructor


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail(){
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Name: " + studentName + ", Student ID: " + studentID + ", E-mail: " + studentEmail+
                ')';
    }
}
