package proj1;

import java.io.*;
import java.util.Scanner;

public class Login extends driver
{
    public void Login() throws IOException
    {
        System.out.println("----Login----");
        int i = 0;
        while (i < 3)
        {
            System.out.println("Enter username:");
            Scanner sc1 = new Scanner(System.in);
            username = sc1.next();
            System.out.println("Enter password:");
            password = sc1.next();
            File file = new File("data.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            username = username;
            password = password;
            while ((st = br.readLine()) != null)
            {
                String[] words = st.split(",");
                if (username.equals(words[0]) && password.equals(words[1]))
                {

                    System.out.println("\nLogin Successful");
                    i=4;
                    show_options();
                }
            }
            i++;
            System.out.println("\nWrong username or password, please try again\nYou have " + (3-i) + " more attempts left\n");
        }
        if (i == 3)
        {
            System.out.println("You have entered the wrong password 3 times");
            i = 0;
        }
    }
    static void show_options() throws IOException
    {
        System.out.println("""
                
                Enter 1 to go back to login
                Enter 2 to book Vaccine
                Enter 3 to view profile
                Enter 4 to update user details
                Enter 5 to log out
                """);
        Scanner scanner = new Scanner(System.in);
        int ch = scanner.nextInt();

        switch (ch)
        {
            case 1:
                System.out.println("Going back to login\n");
                Login l1 = new Login();
                l1.Login();
                break;
            case 2:
                System.out.println("-----Vaccine Booking-----\n");
                bookVaccine bv = new bookVaccine();
                bv.bookvaccine();
                break;
            case 3:
                System.out.println("-----Your Profile-----\n");
                viewProfile vp = new viewProfile();
                vp.showProfile();
                break;
            case 4:
                System.out.println("-----Update User Details-----\n");
                updateUserDetails udp = new updateUserDetails();
                udp.updateuserdetails();
                break;
            case 5:
                System.out.println("Logging out...\n");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong option\n");
                show_options();
                break;
        }
    }
}