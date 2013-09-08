package info.bowkett.sherlock;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:29:11 AM
 *
 * Denotes an exception when writing to the output file.
 *
 * Extends RuntimeException, to remove the need for checked exceptions
 * (See Uncle Bob)
 *
 */
public class OutputFileException extends RuntimeException {
  public OutputFileException(IOException parent) {
    super(parent);
  }
}
