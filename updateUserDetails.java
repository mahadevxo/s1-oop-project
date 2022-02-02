package proj1;

import java.io.*;
import java.util.Scanner;

public class updateUserDetails extends Login
{
    public static void updateuserdetails() throws IOException
    {

        System.out.println("""
                Press 1 to change password
                Press 2 to change phone number""");

        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch (ch)
        {
            case 1: updatePassword(); break;
            case 2: updatePhoneNo(); break;
            default: System.out.println("Wrong option"); break;
        }
        Login l2 = new Login();
        l2.Login();
    }
    public static void updatePassword() throws IOException
    {
        File file = new File("data.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String newPassword;
        System.out.println("Enter new password");
        Scanner sc = new Scanner(System.in);
        newPassword = sc.next();
        String line = "", oldContent = "";
        while((line = br.readLine()) != null)
        {
            String data[] = line.split(",");
            if(username.equals(data[0]) && data.length>1)
            {
                data[1] = newPassword;
                oldContent = oldContent + data[0] + "," + data[1] +  "," + data[2] + "," +  data[3] + "\n";
            }
            else if(data.length>1)
            {
                oldContent = oldContent + data[0] + "," +  data[1] +  "," + data[2] +  "," + data[3] + "\n";
            }
        }

        FileWriter fw = new FileWriter("data.csv");
        fw.write(oldContent);
        fw.flush();
        fw.close();
    }

    public static void updatePhoneNo() throws IOException
    {
        File file = new File("data.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String newPhoneno;
        System.out.println("Enter new phone number");
        Scanner sc = new Scanner(System.in);
        newPhoneno = sc.next();

        String line = "", oldContent = "";
        while((line = br.readLine()) != null)
        {
            String data[] = line.split(",");
            if(username.equals(data[0]) && data.length>1)
            {
                data[3] = newPhoneno;
                oldContent = oldContent + data[0] + "," + data[1] +  "," + data[2] + "," +  data[3] + "\n";
            }
            else if (data.length>1)
            {
                oldContent = oldContent + data[0] + "," +  data[1] +  "," + data[2] +  "," + data[3] + "\n";
            }
        }

        FileWriter fw = new FileWriter("data.csv");
        fw.write(oldContent);
        fw.flush();
        fw.close();
    }
}