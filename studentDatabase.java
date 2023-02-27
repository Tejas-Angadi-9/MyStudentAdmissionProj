package Admission;

import java.util.Scanner;

public class studentDatabase {
    String defaultBranch = "Branch: ";
    String defaultGender = "Gender: ";
    String defaultYear = "Year: ";
    String defaultAdmission = "Admission Category: ";
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dob;
    private final long phoneno;
    private final String email;
    private final String Gender;
    private final String year;
    private final String branch;
    private  final String adminWay;
    int totalPayment;
    private static int id = 0;
    private String studentId;
    Scanner sc = new Scanner(System.in);
   public studentDatabase(){
        //Taking the input from the user

        System.out.println("Enter the first name: ");
        firstName = sc.next();
        System.out.println("Enter the middle name: ");
        middleName = sc.next();
        System.out.println("Enter the last name: ");
        lastName = sc.next();
        System.out.println("Enter the date of birth (DD/MM/YYYY) : ");
        dob = sc.next();
        System.out.println("Enter your phone number: ");
        phoneno = sc.nextLong();
        System.out.println("Enter your Email id: ");
        email = sc.next();
        System.out.println("Gender (M/F/O): ");
        Gender = sc.next();
        System.out.println("Enter the mode of Admission (CET/ COMED-K/ Management)");
        adminWay = sc.next();
        System.out.println("Enter your branch (EC, CS, EE, CV & ME): ");
        branch = sc.next();
        System.out.println("Enter your year (First, Second, Third or Last)");
        year = sc.next();
        toPrint();

    }
    private void setId(){
       String defaultId = "2JI";
       //defaultID + setYear() + branch + id
        id++;
        this.studentId = defaultId+setYear()+branch+id;
        System.out.println("USN: " + studentId);

    }

    //Creating toPrint() method to print
    public void toPrint(){
        System.out.println();
        System.out.println("Full Name: "+firstName+" "+middleName+" "+lastName);
        System.out.println("Date of birth: "+dob);
        System.out.println("Phone No."+phoneno);
        System.out.println("Email: "+email);
        whichAdmission();
        whichBranch();
        whichYear();
        setId();
        toGender();
        int a = pay(adminWay);
        System.out.println("Your Total fees is: "+a);
        System.out.println("How much amount do you want to pay? ");
        int toPay = sc.nextInt();
        fees(totalPayment, toPay);
        System.out.println("\n\t\t\tTHANK YOU! \n YOUR ADMISSION PROCESS IS COMPLETED");
    }
    //Creating toGender() method to store the value of gender
    public void toGender(){

        //enhanced Switch               //This is better than regular switch statement

        switch (Gender) {
            case "M" -> System.out.println(defaultGender + "Male");
            case "F" -> System.out.println(defaultGender + "Female");
            default -> System.out.println(defaultGender + "Others");
        }
    }

    public void whichBranch(){
        switch (branch){
            case "EC" -> System.out.println(defaultBranch + "Electronics and communication Engineering");
            case "CS" -> System.out.println(defaultBranch + "Computer Science Engineering");
            case "EE" -> System.out.println(defaultBranch + "Electrical and electronics Engineering");
            case "CIV" -> System.out.println(defaultBranch + "Civil Engineering Engineering");
            case "MECH" -> System.out.println(defaultBranch + "Mechanical Engineering");
            default -> System.out.println(defaultBranch + "Invalid input \nEnter the branch as mentioned");
        }
    }
    public void whichYear(){
        switch (year){
            case "First" -> System.out.println(defaultYear + "First");
            case "Second" -> System.out.println(defaultYear + "Second");
            case "Third" -> System.out.println(defaultYear + "Third");
            case "Last" -> System.out.println(defaultYear + "Last");
            default -> System.out.println("Invalid input \nEnter the year as mentioned");
        }
    }

    public void whichAdmission(){
        switch(adminWay){
            case "CET" -> System.out.println(defaultAdmission + "CET");
            case "COMED-K" -> System.out.println(defaultAdmission + "COMED-K");
            case "Management" -> System.out.println(defaultAdmission + "Management");
            default -> System.out.println("Enter the valid way of admission as mentioned");
        }
    }

    public int pay(String adminWay){
        switch (adminWay) {
            case "CET", "COMED-K" -> totalPayment = 86000;
            case "Management" -> totalPayment = 110000;
        }
        return totalPayment;
    }

    public int setYear(){

        return switch (year) {
            case "First" -> 19;
            case "Second" -> 20;
            case "Third" -> 21;
            case "Last" -> 22;
            default -> 0;
        };
    }

    public void fees(int totalPayment, int toPay){
        int remainingFees = totalPayment - toPay;
        System.out.println("You have paid: Rs. " +toPay);
        if(remainingFees == 0)
            System.out.println("No remaining fees");
        else if(remainingFees < 0)
            System.out.println("Error in payment input. Check the payment");
        else
            System.out.println("Your remaining fees is: Rs. "+remainingFees);
    }
}
