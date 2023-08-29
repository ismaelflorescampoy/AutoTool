import java.io.*;
import java.lang.reflect.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import utilities.CodeChef;

/**
 *
 * @author ismael.flores
 * 
 * Multipurpose tool:
 * 
 * 1.- CodeChef solver
 * 
 *   1.a.- java -jar .\HelloWorld.jar CodeChef [problem code]
 * 
 * 2.- SpaceXStorm tool
 * 
 *   2.a.- java -jar .\HelloWorls.jar SpaceXStorm LiveDescription "dd/MM/yyyy HH:mm:ss"
 * 
 */
public class Main {

    public static final String INPUT_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String OUTPUT_FORMAT = "dd/MM HH:mm";
    public static boolean HAS_FLAG = true;
    public static boolean HAS_NAME = true;
    public static Scanner scn = new Scanner(System.in);

    public static final HashMap<String, Method> CODECHEF_FUNCTIONS = new HashMap<>();
    
    /**
     * Get an option either from command line or from user input
     * @param args command line arguments
     * @param min_length minimum number of arguments to get (if less, ask for user input)
     * @param ask_question question to ask to user if needed
     * @return option selected by user or through command line
     */
    public static String getOption(String[] args, int min_length, String ask_question) {
        if (args.length < min_length) {
            System.out.println(ask_question);
            return scn.hasNextLine() ? scn.nextLine() : "";
        }
        else
            return args[min_length - 1];
    }
    
    /**
     * Code to solve codeChef problems
     * @param args command line arguments
     */
    public static void solveCodeChef(String[] args) throws Exception {
        
        //Added solutions
        CODECHEF_FUNCTIONS.put("XOREQUAL", CodeChef.class.getDeclaredMethod("solveCodeChefXOREQUAL"));
        CODECHEF_FUNCTIONS.put("LUCKYFR", CodeChef.class.getDeclaredMethod("solveCodeChefLUCKYFR"));
        CODECHEF_FUNCTIONS.put("AVG", CodeChef.class.getDeclaredMethod("solveCodeChefAVG"));
        CODECHEF_FUNCTIONS.put("MAXFUN", CodeChef.class.getDeclaredMethod("solveCodeChefMAXFUN"));
        CODECHEF_FUNCTIONS.put("MXENVSUB", CodeChef.class.getDeclaredMethod("solveCodeChefMXENVSUB"));
        CODECHEF_FUNCTIONS.put("POPCORN", CodeChef.class.getDeclaredMethod("solveCodeChefPOPCORN"));
        CODECHEF_FUNCTIONS.put("FRGAME", CodeChef.class.getDeclaredMethod("solveCodeChefFRGAME"));
        CODECHEF_FUNCTIONS.put("BALLBOX", CodeChef.class.getDeclaredMethod("solveCodeChefBALLBOX"));
        CODECHEF_FUNCTIONS.put("KEPLERSLAW", CodeChef.class.getDeclaredMethod("solveCodeChefKEPLERSLAW"));
        CODECHEF_FUNCTIONS.put("ONP", CodeChef.class.getDeclaredMethod("solveCodeChefONP"));
        CODECHEF_FUNCTIONS.put("DDMMORMMDD", CodeChef.class.getDeclaredMethod("solveCodeChefDDMMORMMDD"));
        CODECHEF_FUNCTIONS.put("DARLIG", CodeChef.class.getDeclaredMethod("solveCodeChefDARLIG"));
        CODECHEF_FUNCTIONS.put("NFS", CodeChef.class.getDeclaredMethod("solveCodeChefNFS"));
        CODECHEF_FUNCTIONS.put("TRAVELPS", CodeChef.class.getDeclaredMethod("solveCodeChefTRAVELPS"));
        CODECHEF_FUNCTIONS.put("CS2023_STK", CodeChef.class.getDeclaredMethod("solveCodeChefCS2023_STK"));
        
        String problem = getOption(args, 2, "Enter 'CodeChef' code problem to solve :");
        if (!CODECHEF_FUNCTIONS.containsKey(problem))
            System.out.println("Error: solution for CodeChef problem '" + problem + "' not found!");
        else
            CODECHEF_FUNCTIONS.get(problem).invoke(null);
    }
    
    /**
     * Initialize countries from file. The file contains lines with country name and timezone separated by a character 'splitCharacter' (usually ';')
     * @param fileName file to read countries from
     * @param splitCharacter character to split file lines
     * @return HashMap with countries and their timezones
     */
    public static HashMap<String, String> initializeCountriesTimeZonesFromFile(String fileName, char splitCharacter) {
        HashMap<String, String> zonasHorarias = new HashMap<>();
        zonasHorarias.put("UTC", "UTC");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Character.toString(splitCharacter));
                if (parts.length >= 2)
                    zonasHorarias.put(parts[0], parts[1]);
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("File " + fileName + "not found. Creating list of countries and time zones hardcoded. Error: " + e.getMessage());
            zonasHorarias = initialiceCountriesTimeZones();
        }
        return zonasHorarias;
    }

    /**
     * Initialize countries flags from file. The file contains lines with country name, timezone and flag separated by a character 'splitCharacter' (usually ';')
     * @param fileName file to read countries from
     * @param splitCharacter character to split file lines
     * @return HashMap with countries and their flags
     */
    public static HashMap<String, String> initializeCountriesFlagsFromFile(String fileName, char splitCharacter) {
        HashMap<String, String> countriesFlags = new HashMap<>();
        countriesFlags.put("UTC", "\uD83D\uDE80"); // Rocket: \uD83D\uDE80
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Character.toString(splitCharacter));
                if (parts.length >= 3)
                    countriesFlags.put(parts[0], parts[2]);
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("File " + fileName + "not found. Creating list of countries and flags hardcoded. Error: " + e.getMessage());
            countriesFlags = initialiceCountriesFlags();
        }
        return countriesFlags;
    }        

    /**
     * Order a HashMap by values
     * @param dates HashMap to order
     * @return TreeMap with ordered values
     */
    public static TreeMap<String, ZonedDateTime> order(HashMap<String, ZonedDateTime> dates) {
        TreeMap<String, ZonedDateTime> sorted = new TreeMap<>(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                // If dates are equal, sort by country name
                if (dates.get(o1).compareTo(dates.get(o2)) == 0)
                    return o1.compareTo(o2);
                return dates.get(o1).compareTo(dates.get(o2));
            }
        });
        sorted.putAll(dates);
        return sorted;
    }

    /**
     * Initialize countries and its timezones (hardcoded)
     * @return HashMap with countries and their timezones
     */
    public static HashMap<String, String> initialiceCountriesTimeZones() {
        HashMap<String, String> zonasHorarias = new HashMap<>();
        
        zonasHorarias.put("Nueva Zelanda", "Pacific/Auckland");
        zonasHorarias.put("Corea del Sur", "Asia/Seoul");
        zonasHorarias.put("Japón", "Asia/Tokyo");
        zonasHorarias.put("Islas Canarias", "Atlantic/Canary");
        zonasHorarias.put("Argentina", "America/Buenos_Aires");
        zonasHorarias.put("Uruguay", "America/Montevideo");
        zonasHorarias.put("Brasil", "America/Sao_Paulo");
        zonasHorarias.put("Chile", "America/Santiago");
        zonasHorarias.put("Paraguay", "America/Asuncion");
        zonasHorarias.put("Venezuela", "America/Caracas");
        zonasHorarias.put("República Dominicana", "America/Santo_Domingo");
        zonasHorarias.put("Bolivia", "America/La_Paz");
        zonasHorarias.put("Puerto Rico", "America/Puerto_Rico");
        zonasHorarias.put("Florida", "America/New_York");
        zonasHorarias.put("New York", "America/New_York");
        zonasHorarias.put("Cuba", "America/Havana");
        zonasHorarias.put("Panamá", "America/Panama");
        zonasHorarias.put("Perú", "America/Lima");
        zonasHorarias.put("Colombia", "America/Bogota");
        zonasHorarias.put("Ecuador", "America/Guayaquil");
        zonasHorarias.put("México", "SystemV/CST6");
        zonasHorarias.put("Costa Rica", "America/Costa_Rica");
        zonasHorarias.put("Honduras", "America/Tegucigalpa");
        zonasHorarias.put("El Salvador", "America/El_Salvador");
        zonasHorarias.put("Nicaragua", "America/Managua");
        zonasHorarias.put("Guatemala", "America/Guatemala");
        zonasHorarias.put("California", "America/Los_Angeles");
        zonasHorarias.put("España", "Europe/Madrid");
        
        return zonasHorarias;
    }

    /**
     * Initialize countries and its flags (hardcoded)
     * @return HashMap with countries and their flags
     */
    private static HashMap<String, String> initialiceCountriesFlags() {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("Nueva Zelanda", "\uD83C\uDDF3\uD83C\uDDFF");
        flags.put("Corea del Sur", "\uD83C\uDDF0\uD83C\uDDF7");
        flags.put("Japón", "\uD83C\uDDEF\uD83C\uDDF5");
        flags.put("Islas Canarias", "\uD83C\uDDEE\uD83C\uDDE8");
        flags.put("Argentina", "\uD83C\uDDE6\uD83C\uDDF7");
        flags.put("Uruguay", "\uD83C\uDDFA\uD83C\uDDFE");
        flags.put("Brasil", "\uD83C\uDDE7\uD83C\uDDF7");
        flags.put("Chile", "\uD83C\uDDE8\uD83C\uDDF1");
        flags.put("Paraguay", "\uD83C\uDDF5\uD83C\uDDFE");
        flags.put("Venezuela", "\uD83C\uDDFB\uD83C\uDDEA");
        flags.put("República Dominicana", "\uD83C\uDDE9\uD83C\uDDF4");
        flags.put("Bolivia", "\uD83C\uDDE7\uD83C\uDDF4");
        flags.put("Puerto Rico", "\uD83C\uDDF5\uD83C\uDDF7");
        flags.put("Florida", "\uD83C\uDDFA\uD83C\uDDF8"); // Ola: \uD83C\uDF0B
        flags.put("New York", "\uD83C\uDDFA\uD83C\uDDF8");  // Estatua de la libertad: \uD83D\uDDFD
        flags.put("Cuba", "\uD83C\uDDE8\uD83C\uDDFA");
        flags.put("Panamá", "\uD83C\uDDF5\uD83C\uDDF8");
        flags.put("Perú", "\uD83C\uDDF5\uD83C\uDDEA");
        flags.put("Colombia", "\uD83C\uDDE8\uD83C\uDDF4");
        flags.put("Ecuador", "\uD83C\uDDEA\uD83C\uDDE8");
        flags.put("México", "\uD83C\uDDF2\uD83C\uDDFD");
        flags.put("Costa Rica", "\uD83C\uDDE8\uD83C\uDDF7");
        flags.put("Honduras", "\uD83C\uDDED\uD83C\uDDF3");
        flags.put("El Salvador", "\uD83C\uDDF8\uD83C\uDDFB");
        flags.put("Nicaragua", "\uD83C\uDDF3\uD83C\uDDEE");
        flags.put("Guatemala", "\uD83C\uDDEC\uD83C\uDDF9");
        flags.put("California", "\uD83C\uDDFA\uD83C\uDDF8"); // Palmera: \uD83C\uDF34
        flags.put("España", "\uD83C\uDDEA\uD83C\uDDF8");
        return flags;
    }

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
    private static String getClockIcon(LocalDateTime ldt) {
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
     * Get ordered dates for a launch
     * @param utc UTC launch date and time
     * @param countries HashMap with countries and their timezones
     * @return TreeMap with ordered launch dates for each country
     */
    private static TreeMap<String, ZonedDateTime> getOrderedDates(ZonedDateTime utc, HashMap<String, String> countries) {
        HashMap<String, ZonedDateTime> dates = new HashMap<>();
        for (String country : countries.keySet()) {
            ZoneId local_zone_id = ZoneId.of(countries.get(country));
            ZonedDateTime local = utc.withZoneSameInstant(local_zone_id);
            dates.put(country, local);
        }
        return order(dates);
    }

    /**
     * Get country string (name plus flag) depending on whether country has name and/or flag
     * @param hasName true if country has name
     * @param hasFlag true if country has flag
     * @param countryNameString country name
     * @return country string
     */
    private static String getCountryString(boolean hasName, boolean hasFlag, String countryNameString, HashMap<String, String> countriesAndFlags) {
        String country_string = "";
        if (!hasFlag)
            country_string += countryNameString;
        else if (hasName)
            country_string += (countryNameString + " " + countriesAndFlags.get(countryNameString));
        else
            country_string += countriesAndFlags.get(countryNameString);
        return country_string;
    }

    /*
     * Update format for country text. Initialice HAS_NAME and HAS_FLAG variables
     * @param format String with format definition to update
     * @return void
     */
    private static void updateFormat(String format) {
        switch (format) {
            case "only_text" -> {
                HAS_NAME = true;
                HAS_FLAG = false;
            }
            case "only_flag" -> {
                HAS_NAME = false;
                HAS_FLAG = true;
            }
            case "text_and_flag" -> {
                HAS_NAME = true;
                HAS_FLAG = true;
            }
            default -> {
                HAS_NAME = true;
                HAS_FLAG = false;
            }
        }
    }

    /*
     * Do a SpaceXStorm LiveDescription task
     * @param args command line arguments
     */
    public static void doLiveDescription(String[] args) {
        String UTCStr = getOption(args, 3, "Error: No UTC launch time defined for SpaceXStorm LiveDescription task. Please, write UTC time in format 'dd/MM/yyyy HH:mm:ss' :");

        String format = getOption(args, 4, "No format defined for country text in SpaceXStorm LiveDescription task. Available options are 'only_text', 'only_flag' and 'text_and_flag' (default is 'only_text'):");

        updateFormat(format);

//            for (String zona : ZoneId.getAvailableZoneIds())
//                System.out.println(zona);

        DateTimeFormatter input_formatter = DateTimeFormatter.ofPattern(INPUT_FORMAT);
        DateTimeFormatter output_formatter = DateTimeFormatter.ofPattern(OUTPUT_FORMAT);
        ZonedDateTime utc = null;
        try {
            utc = ZonedDateTime.parse(UTCStr, input_formatter.withZone(ZoneId.of("UTC")));
        }
        catch (Exception e) {
            System.out.println("Error: '" + UTCStr + "' is not a valid UTC date and time.");
            return;
        }
        HashMap<String, String> countriesAndTimeZones = initializeCountriesTimeZonesFromFile("countries.txt", ';');
        HashMap<String, String> countriesAndFlags = initializeCountriesFlagsFromFile("countries.txt", ';');
        TreeMap<String, ZonedDateTime> ordered_dates = getOrderedDates(utc, countriesAndTimeZones);
        TreeMap<LocalDateTime, String> grouped_dates = new TreeMap<>();
        for (String country : ordered_dates.descendingKeySet()) {
            ZonedDateTime zdt = ordered_dates.get(country);
            String grouped_string = grouped_dates.get(zdt.toLocalDateTime());
            if (grouped_string == null)
                grouped_dates.put(zdt.toLocalDateTime(), getCountryString(HAS_NAME, HAS_FLAG, country, countriesAndFlags));
            else
                grouped_dates.put(zdt.toLocalDateTime(), grouped_string + ", " + getCountryString(HAS_NAME, HAS_FLAG, country, countriesAndFlags));
        }
        for (LocalDateTime ldt : grouped_dates.descendingKeySet())
            System.out.println(getClockIcon(ldt) + " " + ldt.format(output_formatter) + " \u2192 " + grouped_dates.get(ldt));
    }
    
    /**
     * Do a SpaceXStorm task
     * @param args command line arguments
     */
    public static void doSpaceXStormTask(String[] args) {
        String task = getOption(args, 2, "Error: No task defined for SpaceXStorm. Please, select 'LiveDescription':");
        switch (task) {
            case "LiveDescription" -> doLiveDescription(args);
            default -> System.out.println("Error: Unknown SpaceXStorm task '" + task + "'. Options: LiveDescription");
        }
    }

    /**
     * Main function checks command line arguments (or user input option) and calls the corresponding function
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        String tool = getOption(args, 1, "Error: No tool defined. Please, select tool 'SpaceXStorm' or 'CodeChef':");
        switch (tool) {
            case "SpaceXStorm" -> doSpaceXStormTask(args);
            case "CodeChef" -> solveCodeChef(args);
            default -> System.out.println("Error: Unknown task " + tool);
        }
    }
}