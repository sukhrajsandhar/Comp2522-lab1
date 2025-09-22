package ca.bcit.comp2522.bank;

/**
 * Demonstrates the Banking System by creating clients and accounts.
 * Prints formatted details for lab simulation.
 *
 * This class initializes several BankClient and BankAccount objects,
 * performs withdrawals, and prints the details of each client and account
 * in a readable format.
 *
 * Author: Sukhraj Sandhar, Jaiden Yhang
 * Version: 1.0
 */
public class Main {

    /**
     * Main entry point for the banking simulation.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // -----------------------
        // Albert Einstein
        // -----------------------
        Name einsteinName = new Name("Albert", "Einstein");
        BankClient einsteinClient = new BankClient(
                einsteinName,
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Date(1900, 1, 1),
                "123456"
        );
        BankAccount einsteinAccount = new BankAccount(
                einsteinClient,
                "123456",
                1000,
                new Date(1900, 1, 1),
                true,
                new Date(1950, 10, 14),
                3141
        );
        einsteinAccount.withdraw(100);
        printClientAccount(einsteinClient, einsteinAccount);

        // -----------------------
        // Nelson Mandela
        // -----------------------
        Name mandelaName = new Name("Nelson", "Mandela");
        BankClient mandelaClient = new BankClient(
                mandelaName,
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                new Date(1994, 5, 10),
                "654321"
        );
        BankAccount mandelaAccount = new BankAccount(
                mandelaClient,
                "654321",
                2000,
                new Date(1994, 5, 10),
                false,
                null,
                4664
        );
        mandelaAccount.withdraw(200);
        printClientAccount(mandelaClient, mandelaAccount);

        // -----------------------
        // Frida Kahlo
        // -----------------------
        Name kahloName = new Name("Frida", "Kahlo");
        BankClient kahloClient = new BankClient(
                kahloName,
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                new Date(1940, 1, 1),
                "123457"
        );
        BankAccount kahloAccount = new BankAccount(
                kahloClient,
                "123457",
                500,
                new Date(1940, 1, 1),
                true,
                new Date(1954, 7, 13),
                1907
        );
        kahloAccount.withdraw(50);
        printClientAccount(kahloClient, kahloAccount);

        // -----------------------
        // Jackie Chan
        // -----------------------
        Name chanName = new Name("Jackie", "Chan");
        BankClient chanClient = new BankClient(
                chanName,
                new Date(1954, 4, 7),
                null,
                new Date(1980, 10, 1),
                "123458"
        );
        BankAccount chanAccount = new BankAccount(
                chanClient,
                "123458",
                3000,
                new Date(1980, 10, 1),
                false,
                null,
                1954
        );
        chanAccount.withdraw(500);
        printClientAccount(chanClient, chanAccount);
    }

    /**
     * Prints formatted details for a given client and account.
     *
     * @param client  the BankClient object
     * @param account the BankAccount object
     */
    private static void printClientAccount(BankClient client, BankAccount account) {
        System.out.println(client.getName().getFullName() + ":");
        System.out.println("Initials: " + client.getName().getInitials());
        System.out.println("Full name: " + client.getName().getFullName());
        System.out.println("Reversed name: " + client.getName().getReverseName());
        System.out.println("Client details: " + client.getDetails());
        System.out.println("Account details: " + account.getDetails());
        System.out.println();
    }
}
