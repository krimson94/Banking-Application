public class BankAccount {
    private String pinNum;
    private String accountName;
    private String accountNum;
    private double currentBalance;
    private double previousTransaction;
    private char transactionType;

    
    public BankAccount(){
        pinNum = "0000";
        accountName = "NoName";
        accountNum = "0000000000";
        currentBalance = 0.0;


    }

    public BankAccount(String pinNum, String accountName, String accountNum, double currentBalance){
        this.pinNum = pinNum;
        this.accountName = accountName;
        this.accountNum = accountNum;
        this.currentBalance = currentBalance;
    }

    public void setPin(String pinNum){
        this.pinNum = pinNum;
    }

    public void setAccountNumber(String accountNum){
        this.accountNum = accountNum;
    }

    public void setBalance(double currentBalance){
        this.currentBalance = currentBalance;

    }
    public void depositAmount(int amount){
        this.currentBalance += amount;
        transactionType = 'd';
        previousTransaction = amount;
    }

    public void withdrawAmount(int amount){
        this.currentBalance -= amount;
        transactionType = 'w';
        previousTransaction = amount;
    }
    
    public void setPreviousTransaction(String previousTransaction){
    }

    public String getPin(){
        return pinNum;
    }

    public String getAccountName(){
        return accountName;
    }
    public String getAccountNumber(){
        return accountNum;
    }
    public double getBalance(){
        return currentBalance;
    }

    public void printCurrentBalance(){
        System.out.printf("Balance: $%.2f\n", currentBalance);
        System.out.println("");
    }

    public void printPreviousTransaction(){
        if (transactionType == 'd'){
            System.out.printf("Deposited: $%.2f\n", previousTransaction);
            System.out.println("");
        }
        else if (transactionType == 'w'){
            System.out.printf("Withdrew: $%.2f\n", previousTransaction);
            System.out.println("");
        }
        else{
            System.out.println("No transaction history");
            System.out.println("");
        }
    }
    
}
