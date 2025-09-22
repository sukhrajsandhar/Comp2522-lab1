package ca.bcit.comp2522.bank;

/**
 * Represents a bank account owned by a BankClient.
 * Includes balance, PIN, account number, and open/close dates.
 * Provides deposit, withdraw, and formatted account details.
 *
 * Author: Sukhraj Sandhar, Jaiden Zhang
 * Version: 1.0
 */
public class BankAccount {

    private final BankClient client;
    private final String accountNumber;
    private double balance;
    private final Date accountOpened;
    private final boolean closed;
    private final Date accountClosed;
    private final int pin;

    /**
     * Constructs a BankAccount.
     *
     * @param client        the client who owns this account
     * @param accountNumber unique account number (6 or 7 characters)
     * @param balance       initial balance
     * @param accountOpened date the account was opened
     * @param closed        true if account is closed, false if open
     * @param accountClosed date the account was closed (null if open)
     * @param pin           PIN code for account security
     * @throws IllegalArgumentException if account number is invalid
     */
    public BankAccount(
            BankClient client,
            String accountNumber,
            double balance,
            Date accountOpened,
            boolean closed,
            Date accountClosed,
            int pin
    ) {
        if (accountNumber == null || !accountNumber.matches("\\w{6,7}")) {
            throw new IllegalArgumentException("Account number must be 6 or 7 characters.");
        }

        this.client = client;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountOpened = accountOpened;
        this.closed = closed;
        this.accountClosed = accountClosed;
        this.pin = pin;
    }

    /**
     * Deposits money into the account.
     *
     * @param amountUsd the amount to deposit (must be positive)
     */
    public void deposit(double amountUsd) {
        if (amountUsd > 0) {
            balance += amountUsd;
        }
    }

    /**
     * Withdraws money from the account if sufficient balance exists.
     *
     * @param amountUsd the amount to withdraw (must be positive and <= balance)
     */
    public void withdraw(double amountUsd) {
        if (amountUsd > 0 && amountUsd <= balance) {
            balance -= amountUsd;
        }
    }

    /**
     * Withdraws money if the provided PIN matches the account's PIN.
     *
     * @param amountUsd  the amount to withdraw
     * @param pinToMatch the PIN code to validate
     */
    public void withdraw(double amountUsd, int pinToMatch) {
        if (pinToMatch == this.pin) {
            withdraw(amountUsd);
        }
    }

    /**
     * Returns formatted account details including client name,
     * balance, account number, opening date, and status.
     *
     * @return formatted account details
     */
    public String getDetails() {
        String status = closed
                ? "closed on " + accountClosed.getFormattedDate()
                : "still open";

        return client.getName().getFullName()
                + " has $" + balance + " USD in account #" + accountNumber
                + " opened on " + accountOpened.getFormattedDate()
                + " and " + status + ".";
    }
}
