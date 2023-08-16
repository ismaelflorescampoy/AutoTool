import java.io.*;
import java.lang.reflect.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

/**
 *
 * @author ismael.flores
 * 
 * Multipurpose tool:
 * 
 * 1.- CodeChef solver
 * 
 *   1.a.- java -jar .\HelloWorld.jar CodeChef
 * 
 * 2.- SpaceXStorm tool
 * 
 *   2.a.- java .jar .\HelloWorls.jar SpaceXStorm LiveDescription "dd/MM/yyyy HH:mm:ss"
 * 
 */
public class Main {

    public static final String INPUT_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String OUTPUT_FORMAT = "dd/MM HH:mm";

    public static final HashMap<String, Method> CODECHEF_FUNCTIONS = new HashMap<>();
    
    public static void solveCodeChefXOREQUAL() {
        Scanner scn = new Scanner(System.in);

        // Precalculate all 2^N [0 <= N < 100000]
        long[] p = new long [100000];
        p[0] = 1;
        for (int i = 1; i < 100000; i++)
            p[i] = (p[i - 1] * 2) % 1000000007;

        long T = scn.nextLong(); 
        while (T-- > 0) {
            int N = scn.nextInt();
            System.out.println(p[N - 1]);
        }
    }

    public static void solveCodeChefLUCKYFR() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            long count4s = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '4')
                    count4s++;
            }
            System.out.println(count4s);
        }
    }

    public static void solveCodeChefAVG() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long V = scn.nextLong();
            long sum = 0;
            for (long i = 0; i < N; i++)
                sum += scn.nextLong();
            // (sum + K * n) / (K + N) = V
            long remain = V * (K + N) - sum;
            System.out.println(((remain % K) != 0 || remain <= 0) ? -1 : remain / K);
        }
    }

    public static void solveCodeChefMAXFUN() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong() - 3;
            long Ax = scn.nextLong();
            long Ay = scn.nextLong();
            long Az = scn.nextLong();
            long actual = Math.abs(Ax - Ay) + Math.abs(Ax - Az) + Math.abs(Ay - Az);
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long nActual = Math.abs(Ai - Ay) + Math.abs(Ai - Az) + Math.abs(Ay - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ax = Ai;
                }
                nActual = Math.abs(Ax - Ai) + Math.abs(Ax - Az) + Math.abs(Ai - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ay = Ai;
                }
                nActual = Math.abs(Ax - Ay) + Math.abs(Ax - Ai) + Math.abs(Ay - Ai);
                if (nActual > actual) {
                    actual = nActual;
                    Az = Ai;
                }
            }
            System.out.println(actual);
        }
    }
    
    /**
     * Code to solve codeChef problem
     */
    public static void solveCodeChef(String[] args) throws Exception {
        
        //Added solutions
        CODECHEF_FUNCTIONS.put("XOREQUAL", Main.class.getDeclaredMethod("solveCodeChefXOREQUAL"));
        CODECHEF_FUNCTIONS.put("LUCKYFR", Main.class.getDeclaredMethod("solveCodeChefLUCKYFR"));
        CODECHEF_FUNCTIONS.put("AVG", Main.class.getDeclaredMethod("solveCodeChefAVG"));
        CODECHEF_FUNCTIONS.put("MAXFUN", Main.class.getDeclaredMethod("solveCodeChefMAXFUN"));
        
        if (args.length != 2) {
            // with 'T' test cases
            Scanner scn = new Scanner(System.in);
            long T = scn.nextLong(); 
            // long T = 1;
            long[] p = new long [100000];
            p[0] = 1;
            for (int i = 1; i < 100000; i++)
                p[i] = (p[i - 1] * 2) % 1000000007;
            while (T-- > 0) {
                int N = scn.nextInt();
                System.out.println(p[N - 1]);
            }
        }
        else {
            if (!CODECHEF_FUNCTIONS.containsKey(args[1]))
                System.out.println("Error: solution for CodeChef problem '" + args[1] + "' not found!");
            else
                CODECHEF_FUNCTIONS.get(args[1]).invoke(null);
        }
    }

    public static HashMap<String, String> initialiceCountries() {
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

    public static TreeMap<String, ZonedDateTime> order(HashMap<String, ZonedDateTime> dates) {
        TreeMap<String, ZonedDateTime> sorted = new TreeMap<>(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                if (dates.get(o1).compareTo(dates.get(o2)) == 0)
                    return o1.compareTo(o2);
                return dates.get(o1).compareTo(dates.get(o2));
            }
        });
        sorted.putAll(dates);
        return sorted;
    }

    /*
    U+1F550	🕐	Uno en punto
    U+1F551	🕑	Dos en punto
    U+1F553	🕓	Cuatro en punto
    U+1F554	🕔	Cinco en punto
    U+1F555	🕕	Seis en punto
    U+1F556	🕖	Siete en punto
    U+1F557	🕗	Ocho en punto
    U+1F558	🕘	Nueve en punto
    U+1F559	🕙	Diez en punto
    U+1F55A	🕚	Once en punto
    U+1F55B	🕛	Doce en punto
    U+1F55C	🕜	Uno y media
    U+1F55D	🕝	Dos y media
    U+1F55E	🕞	Tres y media
    U+1F55F	🕟	Cuatro y media
    U+1F560	🕠	Cinco y media
    U+1F561	?	Seis y media
    U+1F562	🕢	Siete y media
    U+1F563	🕣	Ocho y media
    U+1F564	🕤	Nueve y media
    U+1F565	🕥	Diez y media
    U+1F566	🕦	Once y media
    U+1F567	🕧	Doce y media        
    */
    public static String get_clock_icon(LocalDateTime ldt) {
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

    public static void doLiveDescription(String[] args) {
        if (args.length <= 2)
            System.out.println("Error: Missing launch time in UTC format");
        else {
          
//            for (String zona : ZoneId.getAvailableZoneIds())
//                System.out.println(zona);

            DateTimeFormatter input_formatter = DateTimeFormatter.ofPattern(INPUT_FORMAT);
            DateTimeFormatter output_formatter = DateTimeFormatter.ofPattern(OUTPUT_FORMAT);
            ZonedDateTime utc = ZonedDateTime.parse(args[2], input_formatter.withZone(ZoneId.of("UTC")));
            HashMap<String, String> countries = initialiceCountries();
            HashMap<String, ZonedDateTime> dates = new HashMap<>();
            dates.put("UTC", utc);
//            System.out.println("La fecha UTC a considerar es : " + args[2] + " (" + utc.format(output_formatter) + ")");
            for (String country : countries.keySet()) {
                ZoneId local_zone_id = ZoneId.of(countries.get(country));
                ZonedDateTime local = utc.withZoneSameInstant(local_zone_id);
                dates.put(country, local);
            }
            TreeMap<String, ZonedDateTime> ordered_dates = order(dates);
            TreeMap<LocalDateTime, String> grouped_dates = new TreeMap<>();
            for (String country : ordered_dates.descendingKeySet()) {
                ZonedDateTime zdt = ordered_dates.get(country);
//                System.out.println(country + " está en la zona " + zdt.getZone().toString() + " y la fecha local es: " + zdt.format(output_formatter));
                String grouped_string = grouped_dates.get(zdt.toLocalDateTime());
                if (grouped_string == null)
                    grouped_dates.put(zdt.toLocalDateTime(), country);
                else
                    grouped_dates.put(zdt.toLocalDateTime(), grouped_string + ", " + country);
            }
            for (LocalDateTime ldt : grouped_dates.descendingKeySet())
                System.out.println(get_clock_icon(ldt) + " " + ldt.format(output_formatter) + " \u2192 " + grouped_dates.get(ldt));
        }
    }
    
    public static void doSpaceXStormTask(String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "LiveDescription" -> doLiveDescription(args);
                default -> System.out.println("Error: Unknown SpaceXStorm task '" + args[1] + "'. Options: LiveDescription");
            }
        }
        else
            System.out.println("Error: SpaceXStorm task needs extra parameters. Options: LiveDescription");
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        if (args.length == 0)
            System.out.println("Error: No tool defined. First param must be 'SpaceXStorm' or 'CodeChef'");
        else {
            switch (args[0]) {
                case "SpaceXStorm" -> doSpaceXStormTask(args);
                case "CodeChef" -> solveCodeChef(args);
                default -> System.out.println("Error: Unknown task " + args[0]);
            }
        }
    }
}