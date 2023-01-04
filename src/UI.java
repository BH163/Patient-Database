import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class UI {

    // stores patient information-- key: patient ID number
    HashMap<Integer, Patient> PatientDatabase = new HashMap<Integer, Patient>();

    public UI() {
        // creates Patient Database Hashmap from file with previously stored patient data
        try {
            createPatientDatabase();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Patient Database System");
        String input = "";
        while (!input.equals("4")) {
            System.out.println("_______________________");
            System.out.println();
            System.out.println("1) Admission ");
            System.out.println("2) Charting");
            System.out.println("3) View Chart");
            System.out.println("4) Sign out");
            System.out.println("5) Save & Quit" + "\n"
            );
            System.out.print("Enter Selection: ");
            input = scanner.nextLine();

            if (input.equals("1")) {
                admission();
            } else if (input.equals("2")) {
                charting();
            } else if (input.equals("3")) {
                viewChart();
            } else if (input.equals("5")) {
                // uploads all data from PatientDatabse to 'Patients.txt' file
                try {
                    FileWriter myWriter = new FileWriter("Patients.txt");
                    for (int i = 0; i < PatientDatabase.size(); i++) {
                        myWriter.write("\n" + String.valueOf(i) + "\n");
                        myWriter.write(String.valueOf(PatientDatabase.get(i)));
                    }
                    myWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.exit(0);
            }


        }
    }



    // prints all data stored on patient
    public void viewChart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter patient ID number: ");
        int idNum_NameSearch_View = Integer.parseInt(scanner.nextLine());
        System.out.println();
        System.out.println(PatientDatabase.get(idNum_NameSearch_View));
        System.out.println();
    }


    // creates new patient ID number and prompts user to fill in all relevant data
    public void admission() {
        System.out.println();
        System.out.println();
        System.out.println("Patient Admission");
        System.out.println("_________________");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> allergies = new ArrayList<>();
        ArrayList<String> medications = new ArrayList<>();
        ArrayList<String> medHist = new ArrayList<>();

        System.out.print("Name (last, first): ");
        String name = scanner.nextLine();
        System.out.print("DOB (xx/xx/xxxx): ");
        String DOB = scanner.nextLine();
        System.out.print("Address (Street, City, State, Zip): ");
        String address = scanner.nextLine();

        // 'ENTER' moves user to next category to fill out data
        System.out.println("Press ENTER when complete");

        while (true) {
            System.out.print("Allergies: ");
            String inputAlle = scanner.nextLine();
            if (inputAlle.equals("")) {
                break;
            }
            allergies.add(inputAlle);

        }

        while (true) {
            System.out.print("Medications: ");
            String inputMed = scanner.nextLine();
            if (inputMed.equals("")) {
                break;
            }
            medications.add(inputMed);
        }

        while (true) {
            System.out.print("Medical History: ");
            String inputMedHist = scanner.nextLine();
            if (inputMedHist.equals("")) {
                break;
            }
            medHist.add(inputMedHist);
        }
        System.out.println();
        System.out.println();

        // generates patient ID number
        int idNum = PatientDatabase.size();

        // creates new patient with collected data
        Patient newPatient = new Patient(idNum, name, DOB, address, allergies, medications, medHist);
        // pairs patient data with generated patient ID number
        PatientDatabase.put(idNum, newPatient);
        System.out.println();
        System.out.println();
    }

    // enables user to update patient data
    public void charting() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.print("Enter patient ID number: ");
        int idNum_NameSearch_Chart = Integer.parseInt(scanner.nextLine());
        while (!input.equals("99")) {
            Patient chartingPatient = PatientDatabase.get(idNum_NameSearch_Chart);
            System.out.println("Select charting area");
            System.out.println("1) Name");
            System.out.println("2) DOB");
            System.out.println("3) Address");
            System.out.println("4) Allergies");
            System.out.println("5) Medications");
            System.out.println("6) Medical History");
            System.out.print("Enter Selection Number: ");
            System.out.println();

            String inputEdit = scanner.nextLine();

            if (inputEdit.equals("1")) {
                chartingPatient.editName();
            } else if (inputEdit.equals("2")) {
                chartingPatient.editDOB();
            } else if (inputEdit.equals("3")) {
                chartingPatient.editAddress();
            } else if (inputEdit.equals("4")) {
                chartingPatient.editAllergies();
            } else if (inputEdit.equals("5")) {
                chartingPatient.editMedications();
            } else if (inputEdit.equals("6")) {
                chartingPatient.editMedHistory();
            }
            System.out.println();
            System.out.println("98) Continue Charting");
            System.out.println("99) Return to Main Menu\n");
            System.out.print("Enter Selection Number: ");
            input = scanner.nextLine();
        }
    }

    // reads saved file containing patient data to create PatientDatabase hashmap
    public void createPatientDatabase() throws FileNotFoundException {
        File file = new File("Patients.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            int idNum = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine().replace("Name:", "");
            String DOB = scanner.nextLine().replace("DOB:", "");
            String address = scanner.nextLine().replace("Address:", "");
            ArrayList<String> allergies = new ArrayList<>();
            ArrayList<String> medications = new ArrayList<>();
            ArrayList<String> medHist = new ArrayList<>();

            // gets named allergies from list
            String line = scanner.nextLine();
            String[] newList = line.split(" ");
            for (int i = 1; i < newList.length; i++) {
                newList[i] = newList[i].replace("[", "");
                newList[i] = newList[i].replace(",", "");
                newList[i] = newList[i].replace("]", "");
                allergies.add(newList[i]);
            }

            // gets named medications from list
            String line2 = scanner.nextLine();
            String[] newList2 = line2.split(" ");
            for (int i = 1; i < newList2.length; i++) {
                newList2[i] = newList2[i].replace("[", "");
                newList2[i] = newList2[i].replace(",", "");
                newList2[i] = newList2[i].replace("]", "");
                medications.add(newList2[i]);
            }

            //gets named medical history from list
            String line3 = scanner.nextLine();
            String[] newList3 = line3.split(" ");
            for (int i = 2; i < newList3.length; i++) {
                newList3[i] = newList3[i].replace("[", "");
                newList3[i] = newList3[i].replace(",", "");
                newList3[i] = newList3[i].replace("]", "");
                medHist.add(newList3[i]);
            }

            // recreates PatientDatabase
            Patient newPatient = new Patient(idNum, name, DOB, address, allergies, medications, medHist);
            PatientDatabase.put(idNum, newPatient);
        }
    }
}
