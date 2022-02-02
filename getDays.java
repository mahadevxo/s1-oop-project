package proj1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class getDays extends bookVaccine
{
    static int getDays(String date1_str)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String date2_str = dtf.format(now);


        LocalDate localDate1 = LocalDate.parse(date1_str, dtf);
        LocalDate localDate2 = LocalDate.parse(date2_str, dtf);
        long noOfDaysDifference = ChronoUnit.DAYS.between(localDate1, localDate2);
        int days = (int)noOfDaysDifference;
        return days;
    }
}