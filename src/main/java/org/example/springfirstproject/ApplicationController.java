package org.example.springfirstproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@RestController
public class ApplicationController {

    @GetMapping
    public String index() {
        return "server is running";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("info")
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("OS name: " + System.getProperty ("os.name")).append("\n");
        sb.append(" OS version: " + System.getProperty ("os.version")).append("\n");
        sb.append(" OS Architecture: " + System.getProperty ("os.arch")).append("\n");
        sb.append(" Java version: " + System.getProperty ("java.version")).append("\n");
        sb.append(" Java vendor: " + System.getProperty ("java.vendor")).append("\n");
        return sb.toString();
    }

    @GetMapping("current-date")
    public String currentDate() {
        String timeStamp = new SimpleDateFormat("dd.MM.yy HH:mm:ss")
                .format(Calendar.getInstance().getTime());
        return timeStamp.toString();
    }

    @GetMapping("days-to-new-year")
    public String daysToNewYear(){
        int days = Year.now().length() - LocalDate.now().getDayOfYear();

        return "Дней до НГ: "+days;
    }

}
