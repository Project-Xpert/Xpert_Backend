package org.example.common.util;

import java.util.ArrayList;
import java.util.List;

public class DateFormatter {
    public static String format(String rawDate) {
        List<String> monthData = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        // dateTimeData ex) ["21" ,"Mar" "2025", "10:01:00", "+0900"]
        String[] dateTimeData = rawDate.substring(5).split(" ");
        String[] timeData = dateTimeData[3].split(":");

        int month = monthData.indexOf(dateTimeData[1]) + 1;
        boolean isPM = Integer.parseInt(timeData[0]) >= 12;
        boolean is12OClock = Integer.parseInt(timeData[0]) == 12;

        return String.format("%s.%s.%s %s %s:%s",
                dateTimeData[2],
                (month < 10 ? "0" : "") + month,
                dateTimeData[0],
                (isPM ? "오후" : "오전"),
                (is12OClock ? 12 : Integer.parseInt(timeData[0]) % 12),
                timeData[1]);
    }
}
