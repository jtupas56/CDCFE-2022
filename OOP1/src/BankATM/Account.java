package BankATM;

import java.util.Scanner;//import scanner from java library
public class Account {//start class
    //Declare 4 variables of private ID as Integer, Name as String, Pin as Long, Balance as Double
    private int userID;
    private String userName;
    private long userPin;
    private double userBalance;
    static Scanner input = new Scanner(System.in);//make reference to the Scanner
    public static String userInput;//declare string variable for user input
    public static int count = 3;//declare integer variable for 3 attempts
    public int Amount;//declare variable for amount
    public static int chargeFee= 5;//declare variable for charge fee
    public Account(int userID, String userName, long userPin, double userBalance) {//start constructor
        this.userID = userID;
        this.userName=userName;
        this.userPin=userPin;
        this.userBalance=userBalance;
    }//end constructor

    public Account() {}//empty constructor

    public int getUserID() {//start get ID method
        return userID;
    }//end get ID method

    public void setUserID(int userID) {//start set ID method
        this.userID = userID;
    }//end set ID method

    public String getUserName() {//start get name method
        return userName;
    }//start get name method

    public void setUserName(String userName) {//start set name method
        this.userName = userName;
    }//end set name method

    public long getUserPin() {//start get pin method
        return userPin;
    }//end get pin method

    public void setUserPin(long userPin) {//start set pin method
        this.userPin = userPin;
    }//end set pin method

    public double getUserBalance() {//start get balance method
        return userBalance;
    }//end get balance method

    public void setUserBalance(double userBalance) {//start set balance method
        this.userBalance = userBalance;
    }//end set balance method

    @Override
    public String toString() {//start toString method
        return "Bank Statement:(ID:"+ userID + "  Name:" + userName + "  Pin:" + userPin + "  Balance:" + userBalance+"€)";
    }//end toString method

    public static void errorCheck(){//start error check method
        while(!userInput.matches("\\d+")){
            System.out.println("Error, numbers only");
            System.out.println("Please enter again");
            userInput = input.next();
        }//end while
    }//end error check method

    public static void countExit(){//start count exit method
        count--;//declare minus count variable
        System.out.println("Count: "+count);
        if(count==0){//start if
            System.out.println("Sorry no more attempts!");
            System.exit(0);//exit
        }//end if
    }//end method

}//end class
