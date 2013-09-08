package info.bowkett.sherlock;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 10:45:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class InputFileFilterTest {

  @Test
  public void testCorrectFormatIsAccepted(){
    final boolean accepted = new InputFileFilter().accept(new File("."), "12345678");
    assertTrue(accepted);
  }

  @Test
  public void testTooLongFormatIsRejected(){
    final boolean accepted = new InputFileFilter().accept(new File("."), "123456789");
    Assert.assertFalse(accepted);

  }

  @Test
  public void testTooShortFormatIsRejected(){
    final boolean accepted = new InputFileFilter().accept(new File("."), "1234567");
    Assert.assertFalse(accepted);
  }

  @Test
  public void testCharacterFilenameIsRejected(){
    final boolean accepted = new InputFileFilter().accept(new File("."), "1234567a");
    Assert.assertFalse(accepted);
  }

}
