package de.britter.beyondstringutils.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import static org.apache.commons.cli.Option.builder;

public class Main {

    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("h", "help", false, "display the help");
        options.addOption(builder("l")
                            .longOpt("logfile")
                            .hasArg()
                            .argName("file")
                            .desc("use given file for log")
                            .build());

        CommandLineParser parser = new DefaultParser();
        final CommandLine line = parser.parse(options, args);

        if (line.hasOption("help")) {
            new HelpFormatter().printHelp("cool-cli", options);
        } else if (line.hasOption("logfile")) {
            System.out.println("Writing to log file " + line.getOptionValue("logfile"));
        }
    }
}
