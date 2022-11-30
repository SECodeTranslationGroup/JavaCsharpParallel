package parallel.myregex;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    void scan(List<String> lines, Pattern[] patterns, Map<Pattern, Integer> counts) {
        int files = 0, ok = 0, warns = 0, css = 0, errs = 0, overflow=0;

        Pattern okPattern = Pattern.compile("No warnings or errors were found.");
        Pattern countPattern = Pattern.compile("([0-9]+) warnings, ([0-9]+) errors were found!.*?(Not all warnings/errors were shown.)?");
        Pattern countPattern2 = Pattern.compile("Tidy found ([0-9]+) warning[s]? and ([0-9]+) error[s]?!.*?(Not all warnings/errors were shown.)?");
        Pattern cssPattern = Pattern.compile("You are recommended to use CSS.*");
        Pattern guardPattern = Pattern.compile("line [0-9]+ column [0-9]+ - (Error|Warning):.*");
        Matcher m;
        files++;
        for (String line: lines) {
            if (okPattern.matcher(line).matches()) {
                ok++;
            } else if ((m = countPattern.matcher(line)).matches()) {
                warns += Integer.parseInt(m.group(1));
                errs += Integer.parseInt(m.group(2));
                if (m.group(3) != null)
                    overflow++;
            } else if ((m = countPattern2.matcher(line)).matches()) {
                warns += Integer.parseInt(m.group(1));
                errs += Integer.parseInt(m.group(2));
                if (m.group(3) != null)
                    overflow++;
            } else if ((m = guardPattern.matcher(line)).matches()) {
                boolean found = false;
                for (Pattern p: patterns) {
                    if ((m = p.matcher(line)).matches()) {
                        found = true;
                        Integer i = counts.get(p);
                        counts.put(p, (i == null) ? 1 : i + 1);
                        break;
                    }
                }
                if (!found)
                    System.err.println("Unrecognized line: " + line);
            } else if (cssPattern.matcher(line).matches()) {
                css++;
            }
        }
    }
}
