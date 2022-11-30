using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Parallel_Csharp.Parallel.MyRegex;

public class MyRegex
{
    private int files = 0, ok = 0, warns = 0, css = 0, errs = 0, overflow = 0;
    public void Scan(List<string> lines, Regex[] patterns, SortedDictionary<Regex, int> counts)
    {
        Regex okPattern = 
            new Regex("No warnings or errors were found.", 
                RegexOptions.Compiled);
        Regex countPattern =
            new Regex("([0-9]+) warnings, ([0-9]+) errors were found!.*?(Not all warnings/errors were shown.)?",
                RegexOptions.Compiled);
        Regex countPattern2 =
            new Regex(
                "Tidy found ([0-9]+) warning[s]? and ([0-9]+) error[s]?!.*?(Not all warnings/errors were shown.)?",
                RegexOptions.Compiled);
        Regex cssPattern = new Regex("You are recommended to use CSS.*", RegexOptions.Compiled);
        Regex guardPattern = new Regex("line [0-9]+ column [0-9]+ - (Error|Warning):.*", RegexOptions.Compiled);
        Match m;
        files++;
        foreach (string line in lines)
        {
            if (okPattern.IsMatch(line))
            {
                ok++;
            }
            else if ((m = countPattern.Match(line)).Success)
            {
                warns += Convert.ToInt32(m.Groups[1].Value);
                errs += Convert.ToInt32(m.Groups[2].Value);
                if (m.Groups[3].Success)
                    overflow++;
            }
            else if ((m = countPattern2.Match(line)).Success)
            {
                warns += Convert.ToInt32(m.Groups[1].Value);
                errs += Convert.ToInt32(m.Groups[2].Value);
                if (m.Groups[3].Success)
                    overflow++;
            }
            else if ((m = guardPattern.Match(line)).Success)
            {
                bool found = false;
                foreach (Regex p in patterns)
                {
                    if ((m = p.Match(line)).Success)
                    {
                        found = true;
                        int i = counts.GetValueOrDefault(p, 0);
                        counts[p] = i + 1;
                        break;
                    }
                }

                if (!found)
                    Console.Error.WriteLine("Unrecognized line: " + line);
            }
            else if (cssPattern.Match(line).Success)
            {
                css++;
            }
        }
    }
}