import java.util.ArrayList;
import java.util.Scanner;
public class StartApp {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Student> stud = new ArrayList<Student>();

    public static void main(String[] args) {
        stud.add (new Student ("Computer Science",10,"Kevin Morant",1,"kevin@gmail.com"));
        stud.add (new Student ("Business",20,"Ja Durant",2,"ja@gmail.com"));
        stud.add (new Student ("Computer Networking",30,"Kyrie Swerving",3,"kyrie@gmail.com"));

        menuOption();
    }//end main
    public static void menuOption(){
        System.out.println("Welcome to my Student Application!");
        System.out.println("Please choose from the following options:");
        while(true) {
            System.out.println("1.Add Student:\n2.View all students\n3.Exit program");
            int option = input.nextInt();
            //switch statement to choose the options
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    exitProgram();
                    break;
                default:
            }//end switch
        }
    }
    public static void addStudent(){
        System.out.println("Please enter your course: ");
        String cname=input.next();
        System.out.println("Please enter your Course ID: ");
        int cID=input.nextInt();
        System.out.println("Please enter your Student Name: ");
        String sName=input.next();
        System.out.println("Please enter your Student ID: ");
        int sID=input.nextInt();
        System.out.println("Please enter your Student Email: ");
        String sEmail=input.next();
        stud.add(new Student(cname,cID,sName,sID,sEmail));


    }
    public static void viewAllStudents(){
        for(int i = 0;i<stud.size();i++){
            System.out.println(stud.get(i));
            System.out.println("===========================================================");
        }
    }
    public static void exitProgram(){
        System.out.println("Thank you!!! Enjoy your holidays!!!");
        System.exit(0);
    }

}//end class
