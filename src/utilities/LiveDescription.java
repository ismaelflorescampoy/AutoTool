package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @class LiveDescription
 * @author ismael.flores
 **/
public class LiveDescription {
    private static final String INPUT_FORMAT = "dd/MM/yyyy HH:mm:ss";

    private HashMap<String, String> countriesTimeZones = new HashMap<>();
    private TreeMap<String, ZonedDateTime> orderedCountriesByDatetime = null;
    private HashMap<String, String> countriesFlags = new HashMap<>();
    private boolean hasFlag = false;
    private boolean hasText = true;
    private ZonedDateTime utc = null;

    public LiveDescription() {}

    /**
     * Get clock icon for a given date. These are icons for each hour:
     * 
     * U+1F550	🕐	Uno en punto
     * U+1F551	🕑	Dos en punto
     * U+1F553	🕓	Cuatro en punto
     * U+1F554	🕔	Cinco en punto
     * U+1F555	🕕	Seis en punto
     * U+1F556	🕖	Siete en punto
     * U+1F557	🕗	Ocho en punto
     * U+1F558	🕘	Nueve en punto
     * U+1F559	🕙	Diez en punto
     * U+1F55A	🕚	Once en punto
     * U+1F55B	🕛	Doce en punto
     * U+1F55C	🕜	Uno y media
     * U+1F55D	🕝	Dos y media
     * U+1F55E	🕞	Tres y media
     * U+1F55F	🕟	Cuatro y media
     * U+1F560	🕠	Cinco y media
     * U+1F561	🕡	Seis y media
     * U+1F562	🕢	Siete y media
     * U+1F563	🕣	Ocho y media
     * U+1F564	🕤	Nueve y media
     * U+1F565	🕥	Diez y media
     * U+1F566	🕦	Once y media
     * U+1F567	🕧	Doce y media
     * 
     * @param ldt date to get clock icon for
     * @return clock icon
     */
    public String getClockIcon(LocalDateTime ldt) {
        String clock_string = "";
        for (int i = 0; i < 12; i++) {
            if (ldt.isAfter(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i, 45)) &&
                ldt.isBefore(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i + 1, 16)))
                clock_string = "\uD83D" + Character.toString(0xDD50 + i);
            else if (i != 11 && ldt.isAfter(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i + 12, 45)) &&
                ldt.isBefore(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i + 13, 16)))
                clock_string = "\uD83D" + Character.toString(0xDD50 + i);
        }
        if (ldt.isAfter(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), 23, 45)) ||
            ldt.isBefore(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), 0, 16)))
            clock_string = "\uD83D" + Character.toString(0xDD5B);
        
        for (int i = 0; i < 12; i++) {
            if (ldt.isAfter(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i, 15)) &&
                ldt.isBefore(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i, 46)))
                clock_string = "\uD83D" + Character.toString(0xDD5C + (i == 0 ? 11 : i - 1));
            else if (ldt.isAfter(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i + 12, 15)) &&
                ldt.isBefore(LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), i + 12, 46)))
                clock_string = "\uD83D" + Character.toString(0xDD5C + (i == 0 ? 11 : i - 1));
        }
        return clock_string;
    }

    /**
     * Initialize countries and its timezones (hardcoded)
     */
    private void initialiceCountriesTimeZones() {
        countriesTimeZones.put("Nueva Zelanda", "Pacific/Auckland");
        countriesTimeZones.put("Corea del Sur", "Asia/Seoul");
        countriesTimeZones.put("Japón", "Asia/Tokyo");
        countriesTimeZones.put("Islas Canarias", "Atlantic/Canary");
        countriesTimeZones.put("Argentina", "America/Buenos_Aires");
        countriesTimeZones.put("Uruguay", "America/Montevideo");
        countriesTimeZones.put("Brasil", "America/Sao_Paulo");
        countriesTimeZones.put("Chile", "America/Santiago");
        countriesTimeZones.put("Paraguay", "America/Asuncion");
        countriesTimeZones.put("Venezuela", "America/Caracas");
        countriesTimeZones.put("República Dominicana", "America/Santo_Domingo");
        countriesTimeZones.put("Bolivia", "America/La_Paz");
        countriesTimeZones.put("Puerto Rico", "America/Puerto_Rico");
        countriesTimeZones.put("Florida", "America/New_York");
        countriesTimeZones.put("New York", "America/New_York");
        countriesTimeZones.put("Cuba", "America/Havana");
        countriesTimeZones.put("Panamá", "America/Panama");
        countriesTimeZones.put("Perú", "America/Lima");
        countriesTimeZones.put("Colombia", "America/Bogota");
        countriesTimeZones.put("Ecuador", "America/Guayaquil");
        countriesTimeZones.put("México", "SystemV/CST6");
        countriesTimeZones.put("Costa Rica", "America/Costa_Rica");
        countriesTimeZones.put("Honduras", "America/Tegucigalpa");
        countriesTimeZones.put("El Salvador", "America/El_Salvador");
        countriesTimeZones.put("Nicaragua", "America/Managua");
        countriesTimeZones.put("Guatemala", "America/Guatemala");
        countriesTimeZones.put("California", "America/Los_Angeles");
        countriesTimeZones.put("España", "Europe/Madrid");       
    }

    /**
     * Initialize countries and its flags (hardcoded)
     * @return HashMap with countries and their flags
     */
    private void initialiceCountriesFlags() {
        countriesFlags.put("Nueva Zelanda", "\uD83C\uDDF3\uD83C\uDDFF");
        countriesFlags.put("Corea del Sur", "\uD83C\uDDF0\uD83C\uDDF7");
        countriesFlags.put("Japón", "\uD83C\uDDEF\uD83C\uDDF5");
        countriesFlags.put("Islas Canarias", "\uD83C\uDDEE\uD83C\uDDE8");
        countriesFlags.put("Argentina", "\uD83C\uDDE6\uD83C\uDDF7");
        countriesFlags.put("Uruguay", "\uD83C\uDDFA\uD83C\uDDFE");
        countriesFlags.put("Brasil", "\uD83C\uDDE7\uD83C\uDDF7");
        countriesFlags.put("Chile", "\uD83C\uDDE8\uD83C\uDDF1");
        countriesFlags.put("Paraguay", "\uD83C\uDDF5\uD83C\uDDFE");
        countriesFlags.put("Venezuela", "\uD83C\uDDFB\uD83C\uDDEA");
        countriesFlags.put("República Dominicana", "\uD83C\uDDE9\uD83C\uDDF4");
        countriesFlags.put("Bolivia", "\uD83C\uDDE7\uD83C\uDDF4");
        countriesFlags.put("Puerto Rico", "\uD83C\uDDF5\uD83C\uDDF7");
        countriesFlags.put("Florida", "\uD83C\uDDFA\uD83C\uDDF8"); // Ola: \uD83C\uDF0B
        countriesFlags.put("New York", "\uD83C\uDDFA\uD83C\uDDF8");  // Estatua de la libertad: \uD83D\uDDFD
        countriesFlags.put("Cuba", "\uD83C\uDDE8\uD83C\uDDFA");
        countriesFlags.put("Panamá", "\uD83C\uDDF5\uD83C\uDDF8");
        countriesFlags.put("Perú", "\uD83C\uDDF5\uD83C\uDDEA");
        countriesFlags.put("Colombia", "\uD83C\uDDE8\uD83C\uDDF4");
        countriesFlags.put("Ecuador", "\uD83C\uDDEA\uD83C\uDDE8");
        countriesFlags.put("México", "\uD83C\uDDF2\uD83C\uDDFD");
        countriesFlags.put("Costa Rica", "\uD83C\uDDE8\uD83C\uDDF7");
        countriesFlags.put("Honduras", "\uD83C\uDDED\uD83C\uDDF3");
        countriesFlags.put("El Salvador", "\uD83C\uDDF8\uD83C\uDDFB");
        countriesFlags.put("Nicaragua", "\uD83C\uDDF3\uD83C\uDDEE");
        countriesFlags.put("Guatemala", "\uD83C\uDDEC\uD83C\uDDF9");
        countriesFlags.put("California", "\uD83C\uDDFA\uD83C\uDDF8"); // Palmera: \uD83C\uDF34
        countriesFlags.put("España", "\uD83C\uDDEA\uD83C\uDDF8");
    }

    /**
     * Update format for country text. Initialice 'hasName' and 'hasFlag' variables
     * @param format String with format definition to update. Posible values: "only_flag", "only_text", "text_and_flag"
     * @return void
     **/
   public void setFormat(String format) {
        if (format.equals("only_flag")) {
            hasFlag = true;
            hasText = false;
        } else if (format.equals("only_text")) {
            hasFlag = false;
            hasText = true;
        } else if (format.equals("text_and_flag")) {
            hasFlag = true;
            hasText = true;
        }
    }

    /*
     * Initialize UTC date and time
     */
    public void setUTC(String UTCStr) {
        try {
            DateTimeFormatter input_formatter = DateTimeFormatter.ofPattern(INPUT_FORMAT);
            utc = ZonedDateTime.parse(UTCStr, input_formatter.withZone(ZoneId.of("UTC")));
        }
        catch (Exception e) {
            System.out.println("Error: '" + UTCStr + "' is not a valid UTC date and time.");
            return;
        }
    }

    /**
     * Get if country flag must be shown
     * @return boolean True if country flag must be shown, false otherwise
     **/
    public boolean getHasFlag() {
        return hasFlag;
    }

    /**
     * Get if country text must be shown
     * @return boolean True if country text must be shown, false otherwise
     **/
    public boolean getHasText() {
        return hasText;
    }

    /**
     * Get country string (country name plus flag) depending on whether flag and/or name must be shown
     * @param countryNameString country name
     * @return country string containing country name and/or flag depending on whether hasFlag and/or hasText are true or false
     */
    private String getCountryString(String countryNameString) {
        String country_string = "";
        if (!hasFlag)
            country_string += countryNameString;
        else if (hasText)
            country_string += (countryNameString + " " + countriesFlags.get(countryNameString));
        else
            country_string += countriesFlags.get(countryNameString);
        return country_string;
    }

    /**
     * Build ordered dates for a launch
     */
    private void setOrderedDates() {
        // Create a HashMap with countries and their local dates (liftoff date and time converted to local time)
        HashMap<String, ZonedDateTime> dates = new HashMap<>();
        for (String country : countriesTimeZones.keySet()) {
            ZoneId local_zone_id = ZoneId.of(countriesTimeZones.get(country));
            ZonedDateTime local = utc.withZoneSameInstant(local_zone_id);
            dates.put(country, local);
        }

        // Create a TreeMap with countries and their local dates ordered by date and time
        // If dates are equal, sort by country name
        orderedCountriesByDatetime = new TreeMap<>(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                // If dates are equal, sort by country name
                if (dates.get(o1).compareTo(dates.get(o2)) == 0)
                    return o1.compareTo(o2);
                return dates.get(o1).compareTo(dates.get(o2));
            }
        });
        orderedCountriesByDatetime.putAll(dates);
    }

    public TreeMap<LocalDateTime, String> getOrderedGroupedDates() {
        TreeMap<LocalDateTime, String> grouped_dates = new TreeMap<>();
        for (String country : orderedCountriesByDatetime.descendingKeySet()) {
            ZonedDateTime zdt = orderedCountriesByDatetime.get(country);
            String grouped_string = grouped_dates.get(zdt.toLocalDateTime());
            if (grouped_string == null)
                grouped_dates.put(zdt.toLocalDateTime(), getCountryString(country));
            else
                grouped_dates.put(zdt.toLocalDateTime(), grouped_string + ", " + getCountryString(country));
        }
        return grouped_dates;
    }

    /**
     * Initialize countries information from file. The file contains lines with country name, timezone and flag separated by a character 'splitCharacter' (usually ';')
     * @param fileName file to read countries from
     * @param splitCharacter character to split file lines
     * @return HashMap with countries and their timezones and flags
     **/
    public void initializeCountriesInfoFromFile(String fileName, char splitCharacter) {
        countriesTimeZones.put("UTC", "UTC");
        countriesFlags.put("UTC", "\uD83D\uDE80"); // Rocket: \uD83D\uDE80
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Character.toString(splitCharacter));
                if (parts.length >= 2)
                    countriesTimeZones.put(parts[0], parts[1]);
                if (parts.length >= 3)
                    countriesFlags.put(parts[0], parts[2]);
                if (parts.length <= 1) {
                    reader.close();
                    throw new Exception("Line '" + line + "' has less than 2 parts. At least 2 parts are needed.");
                }
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("File " + fileName + "not found or invalid. Creating list of countries and time zones and flags hardcoded. Error: " + e.getMessage());
            initialiceCountriesTimeZones();
            initialiceCountriesFlags();
        }
        setOrderedDates();
    }
}