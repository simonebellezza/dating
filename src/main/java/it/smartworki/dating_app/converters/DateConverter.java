package it.smartworki.dating_app.converters;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    // Client → Backend (es. "31/12/2020")
    private static final DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Backend → Client (ISO 8601)
    private static final DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    // Stringa (client) → LocalDate (ISO)
    public static LocalDate parseFromClientFormat(String date) {
        return LocalDate.parse(date, italianFormatter);
    }

    // LocalDate (ISO) → Stringa (per salvataggio/test/debug)
    public static String formatToClient(LocalDate date) {
        return date.format(italianFormatter);
    }

    // Calcolo età da data di nascita
    public static int calculateAge(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
