package info.bowkett.sherlock;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 1:17:54 PM
 *
 */
public class ActiveXDetectorTest {

  @Test
  public void testHtmlContainingEmbedReturnsTrue(){

    final String content = "<HTML>" +
      "<BODY>" +
      "<P>" +
      "</P>" +
      "<embed src=\"moviename.swf\" width=\"100\" height=\"100\" quality=\"high\" pluginspage=\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\">\n" +
      "</embed>" +
      "</BODY>" +
      "</HTML>";

    final boolean result = new ActiveXDetector().willRequestActiveX(content);

    Assert.assertTrue(result);
  }

  @Test
  public void testHtmlContainingEmbedInUppercaseReturnsTrue(){

    final String content = "<HTML>" +
      "<BODY>" +
      "<P>" +
      "</P>" +
      "<EMBED src=\"moviename.swf\" width=\"100\" height=\"100\" quality=\"high\" pluginspage=\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\">\n" +
      "</EMBED>" +
      "</BODY>" +
      "</HTML>";

    final boolean result = new ActiveXDetector().willRequestActiveX(content);

    Assert.assertTrue(result);
  }

  @Test
  public void testHtmlWithoutEmbedReturnsFalse(){

    final String content = "<HTML>" +
      "<BODY>" +
      "<P>" +
      "</P>" +
      "<other-tag src=\"moviename.swf\" width=\"100\" height=\"100\" quality=\"high\" pluginspage=\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\">\n" +
//      "<embed src>" +
      "</other-tag>" +
      "</BODY>" +
      "</HTML>";

    final boolean result = new ActiveXDetector().willRequestActiveX(content);

    Assert.assertFalse(result);
  }

}
