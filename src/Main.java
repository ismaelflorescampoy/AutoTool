import java.io.*;
import java.lang.reflect.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import utilities.CodeChef;
import utilities.LiveDescription;

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
 *   2.a.- java -jar .\HelloWorls.jar SpaceXStorm LiveDescription "dd/MM/yyyy HH:mm:ss" [format]
 * 
 */
public class Main {

    public static final String OUTPUT_FORMAT = "dd/MM HH:mm";
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

    /*
     * Do a SpaceXStorm LiveDescription task
     * @param args command line arguments
     */
    public static void doLiveDescription(String[] args) {
        String UTCStr = getOption(args, 3, "Error: No UTC launch time defined for SpaceXStorm LiveDescription task. Please, write UTC time in format 'dd/MM/yyyy HH:mm:ss' :");

        String format = getOption(args, 4, "No format defined for country text in SpaceXStorm LiveDescription task. Available options are 'only_text', 'only_flag' and 'text_and_flag' (default is 'only_text'):");

        LiveDescription liveDescription = new LiveDescription();
        liveDescription.setUTC(UTCStr);
        liveDescription.setFormat(format);

//            for (String zona : ZoneId.getAvailableZoneIds())
//                System.out.println(zona);

        DateTimeFormatter output_formatter = DateTimeFormatter.ofPattern(OUTPUT_FORMAT);

        liveDescription.initializeCountriesInfoFromFile("countries.txt", ';');
        TreeMap<LocalDateTime, String> grouped_dates = liveDescription.getOrderedGroupedDates();
        for (LocalDateTime ldt : grouped_dates.descendingKeySet())
            System.out.println(liveDescription.getClockIcon(ldt) + " " + ldt.format(output_formatter) + " \u2192 " + grouped_dates.get(ldt));
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