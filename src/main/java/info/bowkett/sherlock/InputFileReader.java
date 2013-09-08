package info.bowkett.sherlock;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:23:13 AM
 *
 * Reads a file of urls with one url per line and returns them all as an iterator
 */
public class InputFileReader {


  /**
   * Reads input file and throws a runtime input file exception if the file
   * cannot be read
   * @param inputFile
   * @return
   */
  public Iterator<String> readFile(File inputFile) {
    try {
      final LineNumberReader lnr = new LineNumberReader(new FileReader(inputFile));
      final List<String> lines = new ArrayList<String>();
      String line = null;

      while ((line = lnr.readLine ()) != null) {
        lines.add(line);
      }
      return lines.iterator();
    }
    catch (IOException e) {
      System.err.println("Cannot read input file:");
      e.printStackTrace(System.err);
      throw new InputFileException(e);
    }
  }
}
