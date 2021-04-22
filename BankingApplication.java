import java.util.Scanner;


public class BankingApplication {
    
    public static void printMenu(){
        System.out.println("1: Check balance.");
        System.out.println("2: Deposit.");
        System.out.println("3: Withdraw.");
        System.out.println("4: View previous transaction.");
        System.out.println("5: Calculate Interest.");
        System.out.println("6: Exit.");
        System.out.println("");
    }

    public static void printLogo(){
        System.out.println("BBBBBBBBB	BBBBBBBBB");
        System.out.println("BBBBBBBBBB	BBBBBBBBBB");
        System.out.println("BBB    BBBB	BBB    BBBB");
        System.out.println("BBBBBBBBBB	BBBBBBBBBB");
        System.out.println("BBBBBBBBBB	BBBBBBBBBB");
        System.out.println("BBB    BBBB	BBB    BBBB");
        System.out.println("BBBBBBBBBB	BBBBBBBBBB");
        System.out.println("BBBBBBBBB	BBBBBBBBB");
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount("1569", "Ned Flanders", "66293160", 133.44);
        String userPin = "";
        int userInput = -1;
        boolean pinConfirm = false;
        boolean exitBank = false;
        int amount = 0;
        double interestRate = 1.35;
        int numAttempt = 3;
        
        System.out.println("Welcome to Brokebank Bank.");
        System.out.println("");
        printLogo();

        System.out.println("Please enter your 4 pin code: ");
        
        while (!pinConfirm){
            if (numAttempt < 0){
                break;
            }
            userPin = scnr.next();
            if (userPin.equals(bankAccount.getPin())){
                System.out.println("Pin confirmed.");
                System.out.println("");
                pinConfirm = true;
            }
            else if (userPin.length() > 4){
                System.out.println("Invalid. Enter 4 pin code.");
            }

            else{
                System.out.println("Pin incorrect. Try again.");
                if (numAttempt == 1){
                    System.out.println(numAttempt + " attempt remaining.");
                }
                else{
                    System.out.println(numAttempt + " attempts remaining.");
                }
                System.out.println("");
                numAttempt--;
            }
        }

        while (!exitBank && pinConfirm){
            System.out.println("=====Welcome=====");
            System.out.printf("%12s\n", bankAccount.getAccountName());
            //System.out.println("");
            System.out.println("=================");
            System.out.println("");
            printMenu();

            userInput = scnr.nextInt();
            System.out.println("");
            
            if (userInput == 1){
                bankAccount.printCurrentBalance();
            }
            else if (userInput == 2){
                System.out.println("Enter deposit amount: ");
                System.out.print("$ ");
                amount = scnr.nextInt();
                System.out.println("");
                bankAccount.depositAmount(amount);
                 
            }
            else if (userInput == 3){
                System.out.println("Enter withdrawal amount: ");
                System.out.print("$ ");
                amount = scnr.nextInt();
                System.out.println("");
                if (amount > bankAccount.getBalance()){
                    System.out.println("You don't have enough.");

                }
                else if (amount <= bankAccount.getBalance()){
                    bankAccount.withdrawAmount(amount);
                }
            }
            else if (userInput == 4){
                // TODO: view previous transaction
                bankAccount.printPreviousTransaction();
            }
            else if (userInput == 5){
                // TODO: calculate interest
                System.out.println("Current interest rate: " + interestRate + "% p.a.");
                System.out.printf("$%.2f\n", (bankAccount.getBalance() * interestRate / 100 * 1));
                System.out.println("");


            }
            else if (userInput == 6){
                // TODO: quit
                System.out.println("Thank you for banking with us.");
                System.out.println("");
                printLogo();
                exitBank = true;
            }

        }

        if (numAttempt < 0){
            System.out.println("This account has now been locked out. Please call our customer service.");
        }

        
    }


        

}
