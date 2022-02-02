package proj1;

import java.io.*;
import java.util.Scanner;

public class Register extends driver
{
    public void Register() throws IOException
    {
        System.out.println("----Register----");
        Scanner sc = new Scanner(System.in);
        //name, phone number, username, password
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your Phone Number: ");
        String phone = sc.next();
        if(phone.length() == 10)
        {
            System.out.println("Enter your username: ");
            username = sc.next();
            if (checkUsername(username) == false)
            {
                System.out.println("Enter your password: ");
                password = sc.next();
                System.out.println("Enter your year of birth");
                int year = sc.nextInt();
                if((2022 - year) < 18)
                {
                    System.out.println("You must be at least 18 years old.");
                    System.exit(0);
                }
                String data = username + "," + password + "," + name + "," + phone;

                FileWriter fw = new FileWriter("data.csv", true);
                fw.write("\n" + data);
                fw.flush();
                fw.close();
                Login l1 = new Login();
                l1.Login();
            }
            else
            {
                System.out.println("Username is already taken\nPlease enter your details again");
                Register();
            }
        }
        else
        {
            System.out.println("Phone Number is not 10 digits long, please try again");
            Register();
        }
    }

    static boolean checkUsername(String user_n) {
        boolean username_check = false;
        try
        {
            File file = new File("data.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] words = st.split(",");
                if (user_n.equals(words[0]))
                {
                    username_check = true;
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return username_check;
    }
}