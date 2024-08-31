import java.util.ArrayList;
import java.util.List;

public class MycheckedException {
    public static void main(String[] args) {
        List<String> emails = new ArrayList<>();
        emails.add("test@example.com");
        emails.add("chnuiftkn-email");
        emails.add("vldstrvskj@gmail.com");
        emails.add("user@domain.net");

        try {
            IfInvalidEmails(emails);
        } catch (CustomEmailFormatException e) {
            System.err.println("Error during email validation: " + e.getMessage());
        }

        System.out.println("Valid emails:");
        for (String email : emails) {
            System.out.println(email);
        }
    }

    public static void IfInvalidEmails(List<String> emails) throws CustomEmailFormatException {
        for (int i = emails.size() - 1; i >= 0; i--) {
            String email = emails.get(i);
            if (!isValidEmailFormat(email)) {
                emails.remove(i);
                throw new CustomEmailFormatException("Removed invalid email: " + email);
            }
        }
    }

    public static boolean isValidEmailFormat(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}