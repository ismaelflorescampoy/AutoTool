import java.io.*;
import java.lang.reflect.*;
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
 *         Example: SpaceXStorm LiveDescription "08/09/2023 23:45:00" only_text
 * 
 */
public class Main {

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
        CODECHEF_FUNCTIONS.put("VACCINE2", CodeChef.class.getDeclaredMethod("solveCodeChefVACCINE2"));
        CODECHEF_FUNCTIONS.put("NEWCC", CodeChef.class.getDeclaredMethod("solveCodeChefNEWCC"));
        CODECHEF_FUNCTIONS.put("AMBIDEXTROUS", CodeChef.class.getDeclaredMethod("solveCodeChefAMBIDEXTROUS"));
        CODECHEF_FUNCTIONS.put("KDELI", CodeChef.class.getDeclaredMethod("solveCodeChefKDELI"));
        CODECHEF_FUNCTIONS.put("CC_COPY", CodeChef.class.getDeclaredMethod("solveCodeChefCC_COPY"));
        CODECHEF_FUNCTIONS.put("BROKPHON", CodeChef.class.getDeclaredMethod("solveCodeChefBROKPHON"));
        CODECHEF_FUNCTIONS.put("LUCKYSEVEN", CodeChef.class.getDeclaredMethod("solveCodeChefLUCKYSEVEN"));
        CODECHEF_FUNCTIONS.put("SLOWSTART", CodeChef.class.getDeclaredMethod("solveCodeChefSLOWSTART"));
        CODECHEF_FUNCTIONS.put("CRDGAME3", CodeChef.class.getDeclaredMethod("solveCodeChefCRDGAME3"));
        CODECHEF_FUNCTIONS.put("AIRINDEX", CodeChef.class.getDeclaredMethod("solveCodeChefAIRINDEX"));
        CODECHEF_FUNCTIONS.put("SURPLUS", CodeChef.class.getDeclaredMethod("solveCodeChefSURPLUS"));
        CODECHEF_FUNCTIONS.put("POTATOES", CodeChef.class.getDeclaredMethod("solveCodeChefPOTATOES"));
        CODECHEF_FUNCTIONS.put("APPLEORANGE", CodeChef.class.getDeclaredMethod("solveCodeChefAPPLEORANGE"));
        CODECHEF_FUNCTIONS.put("CHFICRM", CodeChef.class.getDeclaredMethod("solveCodeChefCHFICRM"));
        CODECHEF_FUNCTIONS.put("OFFBY1", CodeChef.class.getDeclaredMethod("solveCodeChefOFFBY1"));
        CODECHEF_FUNCTIONS.put("SMARTER", CodeChef.class.getDeclaredMethod("solveCodeChefSMARTER"));
        CODECHEF_FUNCTIONS.put("LPC", CodeChef.class.getDeclaredMethod("solveCodeChefLPC"));
        CODECHEF_FUNCTIONS.put("WARRIORCHEF", CodeChef.class.getDeclaredMethod("solveCodeChefWARRIORCHEF"));
        CODECHEF_FUNCTIONS.put("CHFHEIST", CodeChef.class.getDeclaredMethod("solveCodeChefCHFHEIST"));
        CODECHEF_FUNCTIONS.put("AGENTCHEF", CodeChef.class.getDeclaredMethod("solveCodeChefAGENTCHEF"));
        CODECHEF_FUNCTIONS.put("STOCKMARKET", CodeChef.class.getDeclaredMethod("solveCodeChefSTOCKMARKET"));
        CODECHEF_FUNCTIONS.put("NEWSPAPER", CodeChef.class.getDeclaredMethod("solveCodeChefNEWSPAPER"));
        CODECHEF_FUNCTIONS.put("EVENTUAL", CodeChef.class.getDeclaredMethod("solveCodeChefEVENTUAL"));
        CODECHEF_FUNCTIONS.put("GROUPS", CodeChef.class.getDeclaredMethod("solveCodeChefGROUPS"));
        CODECHEF_FUNCTIONS.put("PLAYSTR", CodeChef.class.getDeclaredMethod("solveCodeChefPLAYSTR"));
        CODECHEF_FUNCTIONS.put("CHEFARRP", CodeChef.class.getDeclaredMethod("solveCodeChefCHEFARRP"));
        
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

        String countryTextFormat = getOption(args, 4, "No format defined for country text in SpaceXStorm LiveDescription task. Available options are 'only_text', 'only_flag' and 'text_and_flag' (default is 'only_text'):");

        LiveDescription liveDescription = new LiveDescription();
        if (!liveDescription.setUTC(UTCStr))
            return;
        liveDescription.setCountryTextFormat(countryTextFormat);

//            for (String zona : ZoneId.getAvailableZoneIds())
//                System.out.println(zona);

        liveDescription.initializeCountriesInfoFromFile("countries.txt", ';');
        liveDescription.writeLiveDescription("\u2192", true);
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