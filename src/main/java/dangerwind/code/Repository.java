package dangerwind.code;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

//@NoArgsConstructor
//@ArgsConstructor
//@Getter
public class Repository {

    @Getter
    private static String mainString;
    @Getter
    private static StringBuilder logOperation = new StringBuilder();


    public static void changeString(String oldString, String newString) {
        mainString = mainString.replaceFirst(Pattern.quote(oldString), newString);
    }

    public static void setMainString(String oldString) {
        mainString = oldString.replaceAll(" ", "");
    }

    public static void LogAdd(String oldString) {
        logOperation.append(oldString).append("\n");
    }
    public static void LogAddP(String oldString) {
        logOperation.append(oldString);
    }
    public static void LogClear() {
        logOperation.delete(0, logOperation.length());
    }

}
