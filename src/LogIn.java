import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;


public class LogIn {

    private String userName;

    private String password;

    private HashMap<String, String> EmployeeLogin = new HashMap<>();

    //compares user-input username and password combo with on file employee credentials
    public LogIn() throws FileNotFoundException {

        employeeAdd();
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";

        // evaluates if username password combination are correct
        boolean value = true;

        while (value) {
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            try {if (EmployeeLogin.get(username).equals(password)) {
                // pair matches --> login successful
                value = false;
            } else {
                System.out.println("Invalid Username/Password");
            } }
            catch (NullPointerException e) {
                System.out.println("Invalid Username/Password");
            }
        }
    }



    // reads EmployID.txt to create paired username and password combos
    public void employeeAdd() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/src/EmployID.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String row = sc.nextLine();
            String[] parts = row.split(",");
            String userName = parts[0];
            String password = parts[1];
            EmployeeLogin.put(userName, password);
        }
    }

}



