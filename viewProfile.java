package proj1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class viewProfile extends Login
{
    public void showProfile() throws IOException
    {
        File file = new File("data.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        File file2 = new File("data_booking_1.csv");
        BufferedReader br1 = new BufferedReader(new FileReader(file2));

        File file3 = new File("data_booking_2.csv");
        BufferedReader br2 = new BufferedReader(new FileReader(file3));

        String st;
        while((st = br.readLine()) != null)
        {

            String data[] = st.split(",");
            String dose1 = "Not Booked", dose2 = "Not Booked";
            if(data[0].equals(username))
            {
                String st1;
                while ((st1 = br1.readLine()) != null)
                {
                    String words[] = st1.split(",");
                    if (words[0].equals(username))
                    {
                        dose1 = "Booked";
                    }
                }
                while ((st1 = br2.readLine()) != null)
                {
                    String words[] = st1.split(",");
                    if (words[0].equals(username))
                    {
                        dose2 = "Booked";
                    }
                }
                String details = "Name\t\t\t" + data[2] +
                        "\nPhone number\t" + data[3]+
                        "\nUsername\t\t" + data[0]+
                        "\nFirst Dose\t\t"+dose1+
                        "\nSecond Dose\t\t"+dose2;
                System.out.println(details);
            }
        }
        System.exit(0);
    }
}