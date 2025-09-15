package ca.bcit.comp2522.bank;

/**
 * Represents a Bank Client with name, birth/death dates, signup date, and a unique client ID.
 * Provides methods to get client details and check if alive.
 *
 * @author Sukhraj Sandhar
 * @version 1.0
 */
public class BankClient {

    private final Name name;        // Person's name
    private final Date birthDate;   // Birthdate
    private final Date deathDate;   // Can be null if alive
    private final Date signupDate;  // Date client joined the bank
    private final String clientID;  // 6 or 7 digit string

    /**
     * Constructs a BankClient.
     *
     * @param name the Name object
     * @param birthDate Date of birth
     * @param deathDate Date of death (can be null)
     * @param signupDate Date the client joined the bank
     * @param clientID unique 6 or 7 character string
     * @throws IllegalArgumentException if any required argument is invalid
     */
    public BankClient(Name name, Date birthDate, Date deathDate, Date signupDate, String clientID) {
        if (name == null || birthDate == null || signupDate == null) {
            throw new IllegalArgumentException("Name, birth date, and signup date cannot be null");
        }

        if (clientID == null || !(clientID.length() == 6 || clientID.length() == 7)) {
            throw new IllegalArgumentException("Client ID must be 6 or 7 characters");
        }

        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate; // can be null
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    public Name getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public String getClientID() {
        return clientID;
    }

    /**
     * Checks if the client is alive (deathDate is null).
     * @return true if alive, false otherwise
     */
    public boolean isAlive() {
        return deathDate == null;
    }

    /**
     * Returns client details in a formatted string suitable for the lab.
     * @return formatted details string
     */
    public String getDetails() {
        String status;
        if (isAlive()) {
            status = "alive";
        } else {
            status = "died " + deathDate.getDayOfWeek() + ", "
                    + deathDate.getMonth() + " "
                    + deathDate.getDay() + ", "
                    + deathDate.getYear();
        }

        return name.getFullName() + " client #" + clientID + " (" + status + ") joined the bank on "
                + signupDate.getDayOfWeek() + ", "
                + signupDate.getMonth() + " "
                + signupDate.getDay() + ", "
                + signupDate.getYear();
    }
}
