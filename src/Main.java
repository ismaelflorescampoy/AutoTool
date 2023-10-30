import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import utilities.AdventOfCode;
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
        String problem = getOption(args, 2, "Enter 'CodeChef' code problem to solve :");
        if (problem.length() == 0) {
            System.out.println("Error: No problem provided! Available solutions:");
            CodeChef.showCodeChefSolvedProblems();
            return;
        }
        try {
            Method procedure = CodeChef.class.getDeclaredMethod("solveCodeChef" + problem);
            procedure.invoke(null);
        } catch (NoSuchMethodException e) {
            System.out.println("Error: solution for CodeChef problem '" + problem + "' not found! Available solutions:");
            CodeChef.showCodeChefSolvedProblems();
            return;
        }
    }

    /**
     * Code to solve Advent Of Code problems
     * @param args command line arguments
     */
    public static void solveAdventOfCode(String[] args) throws Exception {
        String problem = getOption(args, 2, "Enter 'AdventOfCode' code problem to solve (URL after 'https://adventofcode.com/' without '/'. i.e: 2015day1 for 'https://adventofcode.com/2015/day/1') :");
        if (problem.length() == 0) {
            System.out.println("Error: No problem provided! Available solutions:");
            AdventOfCode.showAdventOfCodeSolvedProblems();
            return;
        }
        try {
            String part = getOption(args, 3, "Enter 'AdventOfCode' part for problem " + problem + " to solve to (by default is '1', the first part):");
            if (part.length() == 0)
                part = "1";
            Method procedure = AdventOfCode.class.getDeclaredMethod("solveAdventOfCode" + problem, String.class);
            procedure.invoke(null, part);
        } catch (NoSuchMethodException e) {
            System.out.println("Error: solution for Advent Of Code problem '" + problem + "' not found! Available solutions:");
            AdventOfCode.showAdventOfCodeSolvedProblems();
            return;
        }
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
        String tool = getOption(args, 1, "Error: No tool defined. Please, select tool 'SpaceXStorm', 'CodeChef' or 'AdventOfCode':");
        switch (tool) {
            case "SpaceXStorm" -> doSpaceXStormTask(args);
            case "CodeChef" -> solveCodeChef(args);
            case "AdventOfCode" -> solveAdventOfCode(args);
            default -> System.out.println("Error: Unknown task " + tool);
        }
    }
}