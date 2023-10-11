package BankATM;
public class StartATM extends Account{//start class
    static SavingsAccount savings = new SavingsAccount();//declare object class of the savings account
    static CurrentAccount current = new CurrentAccount();
    static Account acc = new Account();//declare object class of the current account


    public static void main(String[] args) {//start main method
        selectAccount();//call selectAccount
    }//end main method
    public static void selectAccount(){//start select account method
        System.out.println("Welcome to the world of Bank ATM system");
        System.out.println("Please select number of the account");
        while (true) {//start while loop
            System.out.println("1.Savings Account\n2.Current Account\n3.Exit\n");
            String option = input.next();//error check the user input
            switch (option) {//start switch statement
                case "1":savings.sLogin();break;
                case "2":current.cLogin();break;
                case "3":System.out.println("Goodbye!!!");System.exit(0);break;
                default:System.out.println("Select number 1, 2, or 3 only!!!");
            }//end switch statement
        }//end while loop
    }//end select account method



}//end class

