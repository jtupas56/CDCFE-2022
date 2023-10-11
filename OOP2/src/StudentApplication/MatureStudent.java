package StudentApplication;

public class MatureStudent extends Student {

    private int studentAge; // Private integer variable for the mature student's age

    public MatureStudent(int studentID, String studentName, int studentAge) { // Constructor of the student's ID, name, and age
        super(studentID, studentName); // Call to the superclass constructor with the studentID and studentName
        this.studentAge = studentAge; // Assign the argument value to the studentAge
    } // end constructor

    public void setStudentAge(int studentAge) { // Set the value of the studentAge variable
        this.studentAge = studentAge;
    }

    public void editStudentDetails() {
        System.out.print("Enter new name: ");
        userLetters = input.next(); // read the user input for the name
        lettersInput(); // validate the name input to ensure it contains only letters
        String name = String.valueOf(userLetters); // convert the validated name input to a String
        System.out.println("Enter new age: ");
        userID = input.next(); // read the user input for the age
        limitNumber(); // validate the age input to ensure it enters only digits and no more than 4 digits
        int age = Integer.parseInt(userID); // convert the validated age input to an int
        if (age >= 23 && age <= 60) { // check that the age is between 23 and 60 for mature students
            setStudentAge(age); // set the new age for the student
            setStudentName(name); // set the new name for the student
            System.out.println("Mature Student details is updated!");
        } else {
            System.out.println("Student must be between 23 and 60 years old to be a mature student.");
        }
    }


    @Override
    public String toString() { // Return studentID, studentName and studentAge
        return "Mature Student -" + " ID:" + getStudentID() + ", Student Name:" + getStudentName() + ", Age:" + studentAge;
    }



} // end class definition
