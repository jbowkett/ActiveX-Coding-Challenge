package info.bowkett.sherlock;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 10:25:51 AM
 * Main entry point for application to check all the files in an input directory
 */
public class Main {


  public static void main(String[] args) {

    if (incorrectArgumentCount(args)) {
      usage();
      System.exit(-1);
    }

    final File inputDir = new File(args[0]);
    final File outputDir = new File(args[1]);
    final EightDigitsOnlyFilenameFilter fileFilter = new EightDigitsOnlyFilenameFilter();

    final FileChecker checker = new FileChecker(new InputFileReader());

    final InputDirectoryChecker dirChecker = new InputDirectoryChecker(inputDir,
      outputDir, fileFilter,
      checker);

    dirChecker.checkAllFiles();
  }


  private static void usage() {
    System.err.println("Usage :\nMain <input directory> <output directory>");

  }

  private static boolean incorrectArgumentCount(String[] args) {
    return args.length != 2;
  }
}
