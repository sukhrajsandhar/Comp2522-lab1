package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
        // === Albert Einstein ===
        Name einsteinName = new Name("Albert", "Einstein");
        BankClient einsteinClient = new BankClient(
                einsteinName,
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Date(1900, 1, 1),
                "123456"
        );
        BankAccount einsteinAccount = new BankAccount(einsteinClient,
                "abc123",
                1000,
                new Date(1900, 1, 1),
                3141
        );
        einsteinAccount.withdraw(100);

        System.out.println("Albert Einstein:");
        System.out.println("Initials: " + einsteinName.getInitials());
        System.out.println("Full name: " + einsteinName.getFullName());
        System.out.println("Reversed name: " + einsteinName.getReverseName());
        System.out.println("Client details: " + einsteinClient.getDetails());
        System.out.println("Account details: " + einsteinAccount.getDetails());
        System.out.println();

        // === Nelson Mandela ===
        Name mandelaName = new Name("Nelson", "Mandela");
        BankClient mandelaClient = new BankClient(
                mandelaName,
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                new Date(1994, 5, 10),
                "654321"
        );
        BankAccount mandelaAccount = new BankAccount(mandelaClient,
                "654321",
                2000,
                new Date(1994, 5, 10),
                4664
        );
        mandelaAccount.withdraw(200);

        System.out.println("Nelson Mandela:");
        System.out.println("Initials: " + mandelaName.getInitials());
        System.out.println("Full name: " + mandelaName.getFullName());
        System.out.println("Reversed name: " + mandelaName.getReverseName());
        System.out.println("Client details: " + mandelaClient.getDetails());
        System.out.println("Account details: " + mandelaAccount.getDetails());
        System.out.println();

        // === Frida Kahlo ===
        Name kahloName = new Name("Frida", "Kahlo");
        BankClient kahloClient = new BankClient(
                kahloName,
                new Date(1907, 7, 6),
                new Date(1954, 7, 13),
                new Date(1940, 1, 1),
                "frd123"
                );
        BankAccount kahloAccount = new BankAccount(kahloClient,
                "frd123",
                500,
                new Date(1940, 1, 1),
                1907
        );
        kahloAccount.withdraw(50);

        System.out.println("Frida Kahlo:");
        System.out.println("Initials: " + kahloName.getInitials());
        System.out.println("Full name: " + kahloName.getFullName());
        System.out.println("Reversed name: " + kahloName.getReverseName());
        System.out.println("Client details: " + kahloClient.getDetails());
        System.out.println("Account details: " + kahloAccount.getDetails());
        System.out.println();

        // === Jackie Chan ===
        Name chanName = new Name("Jackie", "Chan");
        BankClient chanClient = new BankClient(
                chanName,
                new Date(1954, 4, 7),
                null, // still alive
                new Date(1980, 10, 1),
                "chan789"
        );
        BankAccount chanAccount = new BankAccount(chanClient,
                "chan789",
                3000,
                new Date(1980, 10, 1),
                1954
        );
        chanAccount.withdraw(500);

        System.out.println("Jackie Chan:");
        System.out.println("Initials: " + chanName.getInitials());
        System.out.println("Full name: " + chanName.getFullName());
        System.out.println("Reversed name: " + chanName.getReverseName());
        System.out.println("Client details: " + chanClient.getDetails());
        System.out.println("Account details: " + chanAccount.getDetails());
        System.out.println();
    }
}
