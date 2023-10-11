package StudentApplication;

public class FulltimeStudent extends Student {

    private String studentEmail; // Private string variable for the full-time student's email address
    public FulltimeStudent(int studentID, String studentName, String studentEmail) { // Constructor of the student's ID, name, and email
        super(studentID, studentName); // Call to the superclass constructor with the studentID and studentName
        this.studentEmail = studentEmail; // Assign the value to the studentEmail variable
    }

    public void setStudentEmail(String studentEmail) { // Set the value of the studentEmail variable
        this.studentEmail = studentEmail;
    }

    public void editStudentDetails() {
        System.out.print("Enter Name: ");
        // Read the user input
        userLetters = input.next();
        // Call the lettersInput
        lettersInput();
        // Convert the validated user input from userLetters
        String name = String.valueOf(userLetters);
        System.out.print("Enter Email: ");
        // Read the user input
        String email = input.next();
        // Check if the entered email is valid using an expression
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            // If the entered email is invalid, print an error message and return from the method
            System.out.println("Invalid email address. Please try again.");
            return;
        }
        // If the entered email is valid, edit the student's name and email
        setStudentName(name);
        setStudentEmail(email);
        System.out.println("Full-time Student details is updated!");
    }

    @Override
    public String toString() { // Return a studentID, studentName and studentEmail
        return "Full-time Student -" + " ID:" + getStudentID() + ", Student Name:" + getStudentName() + ", Email:" + studentEmail;
    }


} // end class definition
