package info.bowkett.sherlock;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:29:11 AM
 *
 * Denotes an exception when reading the input file.
 *
 * Extends RuntimeException, to remove the need for checked exceptions
 * (See Uncle Bob)
 *
 */
public class InputFileException extends RuntimeException {
  public InputFileException(IOException parent) {
    super(parent);
  }
}
