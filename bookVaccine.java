package proj1;

import java.io.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class bookVaccine extends Login
{
    public static void bookvaccine() throws IOException
    {

        File file_register = new File("data.csv");
        BufferedReader br2 = new BufferedReader(new FileReader(file_register));

        FileWriter fw = new FileWriter("data_booking_1.csv", true);

        String line;
        String date;
        try
        {
            while ((line = br2.readLine()) != null) {
                String[] words1 = line.split(",");
                if (words1[0].equals(username)) {
                    if (firstDoseTaken(username) == false)
                    {
                        System.out.println("Enter the sl no of the vaccine you prefer" +
                                "\n1: CoviShield" +
                                "\n2: CoVaccin" +
                                "\n3: Pfizer" +
                                "\n4: Sputnik");
                        Scanner sc = new Scanner(System.in);
                        int ch = sc.nextInt();
                        String vaccineName = "";
                        switch (ch)
                        {
                            case 1: vaccineName = "CoviShield"; break;
                            case 2: vaccineName = "CoVaccine"; break;
                            case 3: vaccineName = "Pfizer"; break;
                            case 4: vaccineName = "Sputnik"; break;
                            default: System.out.println("Wrong option");
                                     System.exit(0);
                        }

                        System.out.println("Enter date as DD-MM-YYYY");
                        date = sc.next();
                        String s = "";
                        int j = 0;
                        if (firstDoseSlot(date ,"1") == true && j == 0)
                        {
                            s = username + "," + vaccineName + "," + date + "," + "1";
                            j = 1;
                            System.out.println("First Dose has been booked for " + date + ", slot 1");
                        }
                        else if (firstDoseSlot(date, "2") == true && j == 0)
                        {
                            s = username + "," + vaccineName + "," + date + "," + "2";
                            j = 1;
                            System.out.println("First Dose has been booked for " + date + ", slot 2");
                        }
                        else if (firstDoseSlot(date, "3") == true && j == 0)
                        {
                            s = username + "," + vaccineName + "," + date + "," + "3";
                            j = 1;
                            System.out.println("First Dose has been booked for " + date + ", slot 3");
                        }
                        else if (firstDoseSlot(date, "4") == true && j == 0)
                        {
                            s = username + "," + vaccineName + "," + date + "," + "4";
                            j = 1;
                            System.out.println("First Dose has been booked for " + date + ", slot 4");
                        }
                        else if (firstDoseSlot(date, "5") == true && j == 0)
                        {
                            s = username + "," + vaccineName + "," + date + "," + "5";
                            j = 1;
                            System.out.println("First Dose has been booked for " + date + ", slot 5");
                        }
                        else
                        {
                            System.out.println("Sorry, no slots are available for " + date);
                            show_options();
                        }

                        fw.write("\n" + s);
                    }
                    else
                    {
                        System.out.println("You have already taken your first dose.\nDo you want to book your second dose?");
                        Scanner sc3 = new Scanner(System.in);
                        String yesno = sc3.next();
                        yesno = yesno.toLowerCase();
                        if (yesno.contains("y"))
                        {
                            book_second_dose();
                        } else
                        {
                            show_options();
                        }
                    }
                }
            }
            fw.flush();
            fw.close();
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("E   R   R   O   R");
        }
    }
    static boolean firstDoseTaken (String user) throws IOException
    {
        boolean b = false;
        File fileReader = new File("data_booking_1.csv");
        BufferedReader br3 = new BufferedReader(new FileReader(fileReader));
        String line1;
        while ((line1 = br3.readLine()) != null) {
            String[] words = line1.split(",");
            if (words[0].equals(user)) {
                b = true;
            }
        }
        return b;
    }
    static void book_second_dose () throws IOException
    {
        File fileReader = new File("data_booking_1.csv");
        BufferedReader br3 = new BufferedReader(new FileReader(fileReader));
        String line;
        while ((line = br3.readLine()) != null) {
            String[] words = line.split(",");
            if (words[0].equals(username)) {
                int days = getDays.getDays(words[2]);
                if (days > 89 || days == 89) {
                    FileWriter fw1 = new FileWriter("data_booking_2.csv", true);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDateTime now = LocalDateTime.now();
                    String date2_str = dtf.format(now);
                    String s = "";
                    int i = 0;
                    if(secondDoseSlot(date2_str, "1") == true && i == 0)
                    {
                        s = "\n" + username + "," + date2_str + "," + "1";
                        System.out.println("Second Dose has been booked for " + date2_str + ", slot 1");
                        i = 1;
                    }
                    else if(secondDoseSlot(date2_str ,"2") == true && i == 0)
                    {
                        s = "\n" + username + "," + date2_str + "," + "2";
                        System.out.println("Second Dose has been booked for " + date2_str + ", slot 2");
                        i = 1;
                    }
                    else if(secondDoseSlot(date2_str, "3") == true && i == 0)
                    {
                        s = "\n" + username + "," + date2_str + "," + "3";
                        System.out.println("Second Dose has been booked for " + date2_str + ", slot 3");
                        i = 1;
                    }
                    else if(secondDoseSlot(date2_str, "4") == true && i == 0)
                    {
                        s = "\n" + username + "," + date2_str + "," + "4";
                        System.out.println("Second Dose has been booked for " + date2_str + ", slot 4");
                        i = 1;
                    }
                    else if(secondDoseSlot(date2_str, "5") == true && i == 0)
                    {
                        s = "\n" + username + "," + date2_str + "," + "5";
                        System.out.println("Second Dose has been booked for " + date2_str + ", slot 5");
                        i = 1;
                    }
                    else
                    {
                        System.out.println("Sorry, no slots are available for " + date2_str);
                        show_options();
                    }

                    fw1.write(s);
                    fw1.flush();
                    fw1.close();

                }
                else
                {
                    System.out.println("It has not been 89 days yet, please try again in " + (89-days) + " days");
                    show_options();
                }
            }
        }
    }
    public static boolean firstDoseSlot (String date,String slot) throws IOException
    {
        File f2 = new File("data_booking_1.csv");
        BufferedReader br4 = new BufferedReader(new FileReader(f2));
        String line;
        boolean dose1 = false;
        int counter = 0;
        while ((line = br4.readLine()) != null )
        {
            String[] words = line.split(",");

            if(words.length > 1)
            {
                if (words[2].equals(date)) {
                    if (words[3].equals(slot)) {
                        counter++;
                    }
                }
            }
        }
        if (counter < 5)
        {
            dose1 = true;
        }
        return dose1;
    }
    public static boolean secondDoseSlot(String date, String slot) throws IOException
    {
        File f2 = new File("data_booking_2.csv");
        BufferedReader br4 = new BufferedReader(new FileReader(f2));
        String line;
        boolean dose2 = false;
        int counter = 0;
        while ((line = br4.readLine()) != null )
        {
            String[] words = line.split(",");

            if(words.length > 1)
            {
                if (words[1].equalsIgnoreCase(date))
                {
                    if (words[2].equals(slot))
                    {
                        counter++;
                    }
                }
            }
        }
        if (counter < 5) {
            dose2 = true;
        }
        return dose2;
    }
}