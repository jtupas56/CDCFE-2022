package BankATM;
public class CurrentAccount extends Account{//start class
    static CurrentAccount[] cAcc = new CurrentAccount[3];//declare an object array for 3 current accounts
    public CurrentAccount(int userID, String userName, long userPin, double userBalance){//start constructor
        super(userID, userName, userPin, userBalance);
    }//end constructor
    public CurrentAccount(){}//empty constructor
    public void cLogin() {//start login method
        //list of current account users
        cAcc[0]=new CurrentAccount(1,"Tupas",5214, 3000);
        cAcc[1]=new CurrentAccount(2,"Atrakchi",4312, 2000);
        cAcc[2]=new CurrentAccount(3,"Haftom",4321, 1000);
        System.out.println("Enter your Pin: ");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method
        int pin = Integer.parseInt(userInput);//parsing int to string
        for(int i=0;i<cAcc.length;i++) {//start for loop
            if (pin == cAcc[i].getUserPin()) {//start if
                cAcc[i].cAccMenu();//call menu method
            }//end if
        }//end for loop
        for(int i=0;i<cAcc.length;i++) {//start for loop
            if (pin != cAcc[i].getUserPin()) {//start if
                System.out.println("Invalid PIN");
                countExit();//call count exit method
                cAcc[i].cLogin();//call current login method
            }//end if
        }//end for loop
    }//end current login method

    public void cAccMenu(){//start menu method
        System.out.println("Welcome to the world of Bank ATM");
        System.out.println("Please select number of the option");
        while(true) {//start while loop
            System.out.println("1.Check Bank Statement\n2.Withdraw Money\n3.Deposit Money\n4.Change Pin\n5.Exit");
            String option = input.next();//error check the user input
            switch(option) {//start switch statement
                case "1": System.out.println(toString()); break;
                case "2": cAccWithdraw(); break;
                case "3": cAccDeposit(); break;
                case "4": cAccChangepin(); break;
                case "5": System.out.println("Goodbye!!");System.exit(0); break;
                default: System.out.println("Select number 1, 2, 3, 4 or 5 only!!!");
            }//end switch statement
        }//end while loop
    }//end current menu method

    public void cAccWithdraw(){//start current withdraww method
        System.out.println("How much you want to withdraw money?");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method
        Amount = Integer.parseInt(userInput);//parsing int to string
        setUserBalance(getUserBalance()-Amount);//calculate for withdraw money
        setUserBalance(getUserBalance()-chargeFee);//calculate for charge fee in withdraw method
        System.out.println("Charge Fee:"+chargeFee+"€");//show the amount of charge fee for withdraw method
        System.out.println("Current Balance: "+getUserBalance()+"€");//show the current balance in withdraw method
    }//end current withdraw method

    public void cAccDeposit(){//start deposit method
        System.out.println("How much you want to deposit money?");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method
        Amount = Integer.parseInt(userInput);//parsing int to string
        setUserBalance(getUserBalance()+Amount);//calculate for deposit money
        setUserBalance(getUserBalance()-chargeFee);//calculate for charge fee in deposit
        System.out.println("Charge Fee:"+chargeFee+"€");//show the amount of charge fee for deposit method
        System.out.println("Current Balance: "+getUserBalance()+"€");//show the current balance in deposit method
    }//end current deposit method

    public void cAccChangepin(){//start change pin method
        System.out.println("Enter your new Pin: ");
        userInput = input.next();//error check the user input
        errorCheck();//call errorcheck method from Account class
        int changePin = Integer.parseInt(userInput);//parsing int to string
        for(int i=0;i<cAcc.length;i++) {//start for loop
            if (changePin == getUserPin()) {//start if
                System.out.println("Pin is already existed, please try enter again");
                cAccChangepin();//call change pin method
            }//end if
        }//end for loop
        for(int i=0;i<cAcc.length;i++) {//start for loop
            if (changePin != getUserPin()) {//start if
                setUserPin(getUserPin()+changePin-getUserPin());
                System.out.println("Your pin is now: "+getUserPin());
                cAccMenu();//call menu method
            }//end if
        }//end for loop
    }//end change pin method

}//end class

