package proj1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class driver
{
    public static String username;
    public static String password;
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Hello, Welcome to CO-VAC app. Please enter your choice to continue: ");
        System.out.println("1. Login (For registered users)");
        System.out.println("2. Register (For new users)");

        int ch=sc.nextInt();

        FileWriter fw1 = new FileWriter("data.csv", true);
        FileWriter fw2 = new FileWriter("data_booking_1.csv", true);
        FileWriter fw3 = new FileWriter("data_booking_2.csv", true);

        fw1.close();
        fw2.close();
        fw3.close();


        Login login=new Login();
        Register register = new Register();

        switch(ch)
        {
            case 1: login.Login(); break;
            case 2: register.Register(); break;
        }

    }
}