public class BankAccount {
    private double balance;
    private int accountID;
    private String password;
    
    public BankAccount(int ID, double bal, String pass){
        balance = bal;
	accountID = ID;
	password = pass;
    }

    public String toString(){
	return accountID + "\t" + balance; 
    }

    public double getBalance(){
	return balance;
    }

    public int getAccountID(){
	return accountID;
    }

    public void setPassword(String newPass){
	password = newPass;
    }

    public boolean deposit(double amount){
	if (amount < 0.00) {
	    return false;
	}
	balance = balance + amount;
	return true;
    }

    public boolean withdraw(double amount){
	if (amount > balance) {
	    return false;
	}
	balance = balance - amount;
	return true;
	
    }
}
