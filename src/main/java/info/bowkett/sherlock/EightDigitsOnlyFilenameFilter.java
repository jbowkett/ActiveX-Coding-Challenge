package info.bowkett.sherlock;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 10:43:46 AM
 * Only accept filenames in format: 'XXXXXXXX'. ( where X is  any digit 0-9,
 * filename length is 8 symbols)
 */
public class EightDigitsOnlyFilenameFilter implements FilenameFilter{

  public boolean accept(File dir, String name) {
    return name.matches("[0-9]{8}");
  }

}




