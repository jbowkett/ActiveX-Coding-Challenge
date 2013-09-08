package info.bowkett.sherlock;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 10:58:52 AM
 *
 * Checks all files in an input directory
 */
public class InputDirectoryChecker {
  private final File inputDir;
  private final File outputDir;
  private EightDigitsOnlyFilenameFilter filter;

  public InputDirectoryChecker(File inputDir, File outputDir, EightDigitsOnlyFilenameFilter filter) {
    this.inputDir = inputDir;
    this.outputDir = outputDir;
    this.filter = filter;
  }

  public void checkAllFiles() {
    final File[] inputFiles = inputDir.listFiles(filter);

    for (File inputFile : inputFiles) {
      final String outputFileName = getLogFileFor(inputFile);
      final File outputFile = new File(outputDir, outputFileName);
      checkFile(inputFile, outputFile);
    }
  }

  private String getLogFileFor(File inputFile) {
    final String inputFileName = inputFile.getName();
    return inputFileName + ".log";
  }

  private void checkFile(File inputFile, File outputFile) {


  }


}
