import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class veterdays {
  public static void main(String[] args) {
    Scanner strInput = new Scanner(System.in);
    String choice, cont = "y";
    while (cont.equalsIgnoreCase("y")) {
      clrscr();
      System.out.println("-----Welcome to Veterdays-----");
      System.out.println("Veterinary Clinic Patient Information Management System");
      System.out.println("1. Add Patient");
      System.out.println("2. View All Patient");
      System.out.println("3. Search Patient");
      System.out.println("4. Update Patient");
      System.out.println("5. Delete Patient");
      System.out.println("6. Exit");
      System.out.println("\n\n");
      System.out.print("Enter your choice: ");
      choice = strInput.nextLine();
      switch (choice) {
        case "1":
          try {
            AddNewPatient();
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "2":
          try {
            ViewAllPatient();
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "3":
          try {
            SearchPatientByIDOrName();
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "4":
          try {
            UpdatePatientByID();
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "5":
          try {
            DeletePatient();
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        case "6":
          try {
            System.exit(0);
          } catch (Exception e) {
            e.printStackTrace();
          }
        default:
          System.out.println("Invalid choice please try again");
          break;
      }
      System.out.print("Do you want to continue? Y/N ");
      cont = strInput.nextLine();
    }
  }

  public static String PadString(String str, int num) {
    int str_size = str.length();
    for (int i = str_size; i <= num; i++) {
      str = str + " ";
    }
    return str;
  }

  public static void header() {
    System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
    System.out.print("|" + PadString("ID", 5));
    System.out.print("|" + PadString("Pet's Name", 40));
    System.out.print("|" + PadString("Age", 10));
    System.out.print("|" + PadString("Sex", 10));
    System.out.print("|" + PadString("Weight", 10));
    System.out.print("|" + PadString("Breed", 30));
    System.out.print("|" + PadString("Owner", 30));
    System.out.print("|" + PadString("Address", 30));
    System.out.print("|" + PadString("Contact Number", 20));
    System.out.print("|" + PadString("Recent Veterinarian", 20));
    System.out.print("|" + PadString("Date of Last Visit", 20));
    System.out.print("|" + PadString("Infections", 30));
    System.out.print("|" + PadString("Symptoms", 30));
    System.out.print("|" + PadString("Diseases", 20));
    System.out.println("|");
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  }

  public static void showPatient(String[] data) {
    System.out.print("|" + PadString(data[0].toString(), 5));
    System.out.print("|" + PadString(data[1].toString(), 40));
    System.out.print("|" + PadString(data[2].toString(), 10));
    System.out.print("|" + PadString(data[3].toString(), 10));
    System.out.print("|" + PadString(data[4].toString(), 30));
    System.out.print("|" + PadString(data[5].toString(), 10));
    System.out.print("|" + PadString(data[6].toString(), 30));
    System.out.print("|" + PadString(data[7].toString(), 30));
    System.out.print("|" + PadString(data[8].toString(), 20));
    System.out.print("|" + PadString(data[9].toString(), 20));
    System.out.print("|" + PadString(data[10].toString(), 20));
    System.out.print("|" + PadString(data[11].toString(), 30));
    System.out.print("|" + PadString(data[12].toString(), 30));
    System.out.print("|" + PadString(data[13].toString(), 20));
    System.out.println("|");
    System.out.println( "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  }

  public static void AddNewPatient() throws IOException {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("vet_db.txt", true));

      Scanner strInput = new Scanner(System.in);
      String ID, name, age, address, sex, breed, owner, contact, recent_vet, symptoms, disease, weight, lastvisit,
          infection;

      System.out.println("Enter ID: ");
      ID = strInput.nextLine();
      System.out.println("Enter Pet's Name: ");
      name = strInput.nextLine();
      System.out.println("Enter Age: ");
      age = strInput.nextLine();
      System.out.println("Enter Sex: ");
      sex = strInput.nextLine();
      System.out.println("Enter Breed: ");
      breed = strInput.nextLine();
      System.out.println("Enter Weight: ");
      weight = strInput.nextLine();
      System.out.println("Enter Owner: ");
      owner = strInput.nextLine();
      System.out.println("Enter Address: ");
      address = strInput.nextLine();
      System.out.println("Enter Contact Number: ");
      contact = strInput.nextLine();
      System.out.println("Enter Recent Veterinarian: ");
      recent_vet = strInput.nextLine();
      System.out.println("Enter Date of Last Visit: ");
      lastvisit = strInput.nextLine();
      System.out.println("Enter Infections: ");
      infection = strInput.nextLine();
      System.out.println("Enter Symptoms: ");
      symptoms = strInput.nextLine();
      System.out.println("Enter Disease: ");
      disease = strInput.nextLine();

      bw.write(ID + "---" + name + "---" + age + "---" + sex + "---" + breed + "---" + weight + "---" + owner + "---"
          + address + "---" + contact + "---" + recent_vet + "---" + lastvisit + "---" + infection + "---" + symptoms
          + "---" + disease);
      bw.flush();
      bw.newLine();
      bw.close();

      ViewAllPatient();
      System.out.println("Patient added successfully!");
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }

  }

  public static void ViewAllPatient() throws IOException {
    try {
      BufferedReader br = new BufferedReader(new FileReader("vet_db.txt"));
      String patient;
      header();
      while ((patient = br.readLine()) != null) {
        String[] data = patient.split("---");
        showPatient(data);
      }
      br.close();
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }
  }

  public static void SearchPatientByIDOrName() throws IOException {
    try {
      String patient, search;
      BufferedReader br = new BufferedReader(new FileReader("vet_db.txt"));
      Scanner strInput = new Scanner(System.in);
      System.out.println("\t\t Search Patients\n");
      System.out.println("Enter the ID or Name of your pet that you want to search: ");
      search = strInput.nextLine();
      header();
      int i = 0;
      while ((patient = br.readLine()) != null) {
        String[] data = patient.split("---");
        if (data[0].toString().equals(search) || (data[1].toString().contains(search))) {
          showPatient(data);
          i++;
        }
      }
      if (i == 0) {
        System.out.println("No Patient found on search data: " + search);
      }

      br.close();
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }

  }

  public static void UpdatePatientByID() throws IOException {
    try {
      ViewAllPatient();
      String ID, newName, newAddress, newAge, newContact, newSymptoms, newDisease, patient, newWeight, newLastVisit,
          newInfection;

      File db = new File("vet_db.txt");
      File tempDB = new File("vet_db_temp.txt");

      BufferedReader br = new BufferedReader(new FileReader(db));
      BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

      Scanner strInput = new Scanner(System.in);
      System.out.println("Enter the ID of the patient you want to update: ");
      ID = strInput.nextLine();
      header();
      int i = 0;
      while ((patient = br.readLine()) != null) {
        String[] data = patient.split("---");
        if (data[0].toString().equals(ID)) {
          showPatient(data);
          i++;
        }
      }

      br.close();
      if (i != 0) {
        System.out.println("Enter the new ID: ");
        ID = strInput.nextLine();
        System.out.println("Enter the new Pet's Name: ");
        newName = strInput.nextLine();
        System.out.println("Enter the new Age: ");
        newAge = strInput.nextLine();
        System.out.println("Enter the new Weight: ");
        newWeight = strInput.nextLine();
        System.out.println("Enter the new Address: ");
        newAddress = strInput.nextLine();
        System.out.println("Enter the new Contact Number: ");
        newContact = strInput.nextLine();
        System.out.println("Enter the Last Visit: ");
        newLastVisit = strInput.nextLine();
        System.out.println("Enter the new Infection: ");
        newInfection = strInput.nextLine();
        System.out.println("Enter the new Symptoms: ");
        newSymptoms = strInput.nextLine();
        System.out.println("Enter the new Disease: ");
        newDisease = strInput.nextLine();

        BufferedReader br2 = new BufferedReader(new FileReader(db));

        String patient2;
        while ((patient2 = br2.readLine()) != null) {
          String[] data = patient2.split("---");
          if (data[0].toString().equals(ID)) {
            bw.write(  ID + "---" + newName + "---" + newAge + "---" + data[3] + "---" + data[4] + "---" + newWeight + "---"
                    + data[6] + "---" + newAddress + "---" + newContact + "---" + data[9] + "---" + newLastVisit + "---"
                    + newInfection + "---" + newSymptoms + "---" + newDisease);
          } else {
            bw.write(patient2);
          }
          bw.flush();
          bw.newLine();
        }

        bw.close();
        br2.close();
        db.delete();
        tempDB.renameTo(db);
      }

    } catch (IOException ex) {
      System.out.println(ex.toString());
    }
  String date;
    date = java.time.LocalDateTime.now().toString();
    System.out.println("Updated on: " + date);

  }

  public static void DeletePatient() throws IOException {
    try {
      ViewAllPatient();
      File tempDB = new File("vet_db_temp.txt");
      File db = new File("vet_db.txt");

      BufferedReader br = new BufferedReader(new FileReader(db));
      BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
      Scanner strInput = new Scanner(System.in);
      String patient, search;
      System.out.println("Enter the ID or Name you want to delete: ");
      search = strInput.nextLine();
      int i = 0;
      header();
      while ((patient = br.readLine()) != null) {
        String[] data = patient.split("---");
        if (data[0].toString().equals(search) || data[1].toString().equals(search)) {
          i++;
          continue;
        }
        bw.write(patient);
        bw.flush();
        bw.newLine();
      }
      if (i == 0) {
        System.out.println("No Patient found on search data :" + search);
      }
      br.close();
      bw.close();
      db.delete();
      tempDB.renameTo(db);
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }
  }

  public static void clrscr() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    } catch (IOException | InterruptedException ex) {
      System.out.println(ex.toString());
    }

  }

}
