import java.util.ArrayList;
import java.util.Scanner;

public class Patient {
    int idNum;
    String name;
    String DOB;
    String address;
    ArrayList<String> allergies;
    ArrayList<String> medications;
    ArrayList<String> medicalHistory;

    Scanner scanner = new Scanner(System.in);

    Patient (int idNum, String name, String DOB, String address, ArrayList<String> allergies, ArrayList<String> medications, ArrayList<String> medicalHistory) {
        this.idNum = idNum;
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.allergies = allergies;
        this.medications = medications;
        this.medicalHistory = medicalHistory;
        String pt = ("ID: " + idNum + "\n" + "Name: "  + name + "\n" + "DOB: " + DOB + "\n" + "Address: " + address + "\n" + "Allergies: " + allergies + "\n" + "Medications: " + medications + "\n" + "Medical History: " + medicalHistory);
    }



    public String toString () {
        String s = ("Name: "  + name + "\n" + "DOB: " + DOB + "\n" + "Address: " + address + "\n" + "Allergies: " + allergies + "\n" + "Medications: " + medications + "\n" + "Medical History: " + medicalHistory);
        return(s);
    }

    public void editName() {
        System.out.print("Name (last, first): ");
        String newName = scanner.nextLine();
        this.name = newName;
    }

    public void editDOB () {
        System.out.print("DOB (xx/xx/xxxx):");
        String newDOB = scanner.nextLine();
        this.DOB = newDOB;
    }

    public void editAddress () {
        System.out.print("Address (Street, City, State, Zip): ");
        String newAdd = scanner.nextLine();
        this.address = newAdd;
    }

    public void editAllergies() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println(allergies);
        System.out.println("1) Add Allergy \n2) Edit Existing Allergy\n3) Remove Existing Allergy");
        System.out.print("Enter selection number: ");
        String selection1 = scanner.nextLine();
        if (selection1.equals("1")) {
            System.out.print("Enter new allergy: ");
            String newAllergy = scanner.nextLine();
            allergies.add(newAllergy);
        } else if (selection1.equals("2")) {
            System.out.println("Select allergy to edit: ");
            for (int i = 0; i < allergies.size(); i++) {
                System.out.println((i + 1) + ")" + allergies.get(i));
            }
            System.out.print("Enter selection number: ");
            int input = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.print("Enter update: ");
            String editAllergy = scanner.nextLine();
            allergies.set(input, editAllergy);
        } else if (selection1.equals("3")) {
            System.out.println("Select allergy to remove");
            for (int i = 0; i < allergies.size(); i++) {
                System.out.println((i + 1) + ")" + allergies.get(i));
            }
            System.out.print("Enter selection number: ");
            int input = Integer.parseInt(scanner.nextLine()) - 1;
            allergies.remove(input);
            System.out.println();
        }
    }


    public void editMedications() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println(medications);
        System.out.println("1) Add medication \n2) Edit existing medication\n3) Remove existing medication");
        System.out.print("Enter selection number: ");
        String selection1 = scanner.nextLine();
        if (selection1.equals("1")) {
            System.out.print("Enter new medication: ");
            String newMedication = scanner.nextLine();
            medications.add(newMedication);
        } else if (selection1.equals("2")) {
            System.out.println("Select medication to edit ");
            for (int i = 0; i < medications.size(); i++) {
                System.out.println((i + 1) + ")" + medications.get(i));
            }
            System.out.print("Enter selection number: ");

            int input = Integer.valueOf(scanner.nextLine()) - 1;
            System.out.print("Enter update:");
            String editMedication = scanner.nextLine();
            medications.set(input, editMedication);
        } else if (selection1.equals("3")) {
            System.out.println("Select medication to remove");
            for (int i = 0; i < medications.size(); i++) {
                System.out.println((i + 1) + ")" + medications.get(i));
            }
            System.out.print("Enter selection number: ");
            int input = Integer.valueOf(scanner.nextLine()) - 1;
            medications.remove(input);
            System.out.println();
        }
    }
    public void editMedHistory() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println(medicalHistory);
        System.out.println("1) Add History \n2) Edit Existing History\n3) Remove Existing History");
        System.out.print("Enter selection number: ");
        String selection1 = scanner.nextLine();
        if (selection1.equals("1")) {
            System.out.print("Enter new history item: ");
            String newHistory = scanner.nextLine();
            medicalHistory.add(newHistory);
        } else if (selection1.equals("2")) {
            System.out.println("Select history to edit");
            for (int i = 0; i < medicalHistory.size(); i++) {
                System.out.println((i + 1) + ")" + medicalHistory.get(i));
            }
            System.out.print("Enter selection number: ");
            int input = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.print("Enter update: ");
            String editMedHist = scanner.nextLine();
            medicalHistory.set(input, editMedHist);
        } else if (selection1.equals("3")) {
            System.out.println("Select history item to remove");
            for (int i = 0; i < medicalHistory.size(); i++) {
                System.out.println((i + 1) + ")" + medicalHistory.get(i));
            }
            System.out.print("Enter selection number: ");
            int input = Integer.parseInt(scanner.nextLine()) - 1;
            medicalHistory.remove(input);
            System.out.println();
        }
    }

}










