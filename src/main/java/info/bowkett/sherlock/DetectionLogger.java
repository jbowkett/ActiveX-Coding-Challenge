package info.bowkett.sherlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 12:46:34 PM
 *
 * Logs the responses to the output file in the required format
 *
 */
public class DetectionLogger {
  private PrintWriter writer = null;

  private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

  public void openFile(File outputFile) {
    try {
      writer = new PrintWriter(outputFile);
    }
    catch (FileNotFoundException e) {
      throw new OutputFileException(e);
    }
  }

  public void closeFile(File outputFile) {
    if(writer != null) writer.close();
  }

  public void log(int httpResponseCode, String url, boolean activeX) {
    writer.print(format.format(new Date()));
    delimiter();
    writer.print(httpResponseCode);
    delimiter();
    writer.print(url);
    delimiter();
    writer.println(activeX);
  }

  private void delimiter() {
    writer.print("\t");
  }
}
