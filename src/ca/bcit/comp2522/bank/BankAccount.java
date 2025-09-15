package ca.bcit.comp2522.bank;

/**
 * BankAccount Class represents a bank account belonging to a client
 * @author Jaden Zhang
 * @version 1.0
 */

public class BankAccount {
    private BankClient client;
    private String accountNumber; // 6 or 7 characters
    private Date accountOpened;
    private Date accountClosed; // can be null
    private double balance;
    private int pin;

    /**
     * Creates a new bank account
     *
     * @param client the client
     * @param accountNumber the account number
     * @param balance the initial balance
     * @param accountOpened the opening date
     * @param pin the PIN code
     * @throws IllegalArgumentException if account number is not 6 or 7 characters or null
     */
    public BankAccount(BankClient client, String accountNumber, double balance, Date accountOpened, int pin) {
        if (accountNumber == null || (accountNumber.length() != 6 && accountNumber.length() != 7)) {
            throw new IllegalArgumentException("Invalid account number. Account number must be 6 or 7 characters.");
        }
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = null;
        this.balance = balance;
        this.pin = pin;
    }

    // Withdraw without a pin
    public boolean withdraw(final double amountUsd) {
        if (amountUsd > 0 && amountUsd <= balance) {
            balance = balance - amountUsd;
            return true;
        }
        return false;
    }

    // Withdraw with a pin
    public boolean withdraw(final double amountUsd, final int pinToMatch) {
        if (this.pin != pinToMatch) {
            return false;
        }
        return withdraw(amountUsd);
    }

    // Returns the current account balance
    public double getBalance() {
        return balance;
    }

    /**
     * Returns a summary of account details
     * @return a formatted string of account details
     */
    public String getDetails() {
        return "Account #:" + accountNumber +
                "Balance: $" + balance +
                "Opened: " + accountOpened.getYYYYMMDD() +
                ((accountClosed == null) ? "still open" : accountClosed.getYYYYMMDD());
    }
}
