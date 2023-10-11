package BankATM;
public class SavingsAccount extends Account{//start class
    static SavingsAccount[] sAcc = new SavingsAccount[3];//declare an object array for 3 savings accounts
    public SavingsAccount(int userID, String userName, long userPin, double userBalance){//start constructor
        super(userID, userName, userPin, userBalance);
    }//end constructor
    public SavingsAccount(){}//empty constructor
    public void sLogin() {//start login method
        //list of current account users
        sAcc[0]=new SavingsAccount(1,"Joshua",4125, 3000);
        sAcc[1]=new SavingsAccount(2,"Eskandar",2134, 2000);
        sAcc[2]=new SavingsAccount(3,"Yonas",1234, 1000);
        System.out.println("Enter your Pin: ");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method from Account class
        int pin = Integer.parseInt(userInput);//parsing int to string
        for(int i=0;i<sAcc.length;i++) {//start for loop
            if (pin == sAcc[i].getUserPin()) {//start if
                sAcc[i].sAccMenu();//call menu method
            }//end if
        }//end for loop
        for(int i=0;i<sAcc.length;i++) {//start for loop
            if (pin != sAcc[i].getUserPin()) {//start if
                System.out.println("Invalid PIN");
                countExit();//call count exit method
                sAcc[i].sLogin();//call login method
            }//end if
        }//end for loop
    }//end login method
    public void sAccMenu(){//start menu method
        System.out.println("Welcome to the world of Bank ATM");
        System.out.println("Please select number of the option");
        while(true) {//start while loop
            System.out.println("1.Check Bank Statement\n2.Withdraw Money\n3.Deposit Money\n4.Change Pin\n5.Exit");
            String option = input.next();//error check the user input
            switch(option) {//start switch statement
                case "1": System.out.println(toString()); break;
                case "2": sAccWithdraw(); break;
                case "3": sAccDeposit(); break;
                case "4": sAccChangepin(); break;
                case "5": System.out.println("Goodbye!!");System.exit(0); break;
                default: System.out.println("Select number 1, 2, 3, 4 or 5 only!!!");
            }//end switch statement
        }//end while loop
    }//end menu method
    public void sAccWithdraw(){//start withdraw method
        System.out.println("How much you want to withdraw money?");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method
        Amount = Integer.parseInt(userInput);//parsing int to string
        setUserBalance(getUserBalance()-Amount);//calculate for withdraw money
        System.out.println("Current Balance: "+getUserBalance()+"€");
    }//end withdraw method

    public void sAccDeposit(){//start deposit method
        System.out.println("How much you want to deposit money?");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method from Account class
        Amount = Integer.parseInt(userInput);//parsing int to string
        double X = Amount * 0.5;
        setUserBalance(getUserBalance() + Amount + (X));//calculate interest rate for the deposit money
        System.out.println("Current Balance: "+getUserBalance()+"€");
        System.out.println("The rate of the interest is 0.5%\nThe money has been added is " + (Amount * (0.5))+"€");
    }//end deposit method

    public void sAccChangepin(){//start savings change pin method
        System.out.println("Enter your new Pin: ");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method from Account class
        int changePin = Integer.parseInt(userInput);//parsing int to string
        for(int i=0;i<sAcc.length;i++) {//start for loop
            if (changePin == getUserPin()) {//start if statement
                System.out.println("Pin is already existed, please try enter again");
                sAccChangepin();//call change pin method to enter the pin again
            }//end if statement
        }//end for loop
        for(int i=0;i<sAcc.length;i++) {//start for loop
            if (changePin != getUserPin()) {//start if statement
                setUserPin(getUserPin()+changePin-getUserPin());
                System.out.println("Your pin is now: "+getUserPin());
                sAccMenu();//call menu method
            }//end if statement
        }//end for loop
    }//end savings change pin method

}//end class
