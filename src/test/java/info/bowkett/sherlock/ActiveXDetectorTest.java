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
  public void testHtmlContainingEmbedIsDetected(){

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
  public void testHtmlContainingObjectIsDetected(){

    final String content = "<HTML>" +
      "<BODY>" +
      "<P>" +
      "</P>" +
      "<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" width=\"100\" height=\"100\" codebase=\"http://active.macromedia.com/flash7/cabs/ swflash.cab#version=9,0,0,0\">\n" +
      "    <param name=\"movie\" value=\"moviename.swf\">\n" +
      "    <param name=\"play\" value=\"true\">\n" +
      "    <param name=\"loop\" value=\"true\">\n" +
      "    <param name=\"quality\" value=\"high\">\n" +
      "</object>" +
      "</BODY>" +
      "</HTML>";

    final boolean result = new ActiveXDetector().willRequestActiveX(content);
    Assert.assertTrue(result);
  }

  @Test
  public void testHtmlContainingObjectInUppercaseIsDetected(){

    final String content = "<HTML>" +
      "<BODY>" +
      "<P>" +
      "</P>" +
      "<OBJECT classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" width=\"100\" height=\"100\" codebase=\"http://active.macromedia.com/flash7/cabs/ swflash.cab#version=9,0,0,0\">\n" +
      "    <param name=\"movie\" value=\"moviename.swf\">\n" +
      "    <param name=\"play\" value=\"true\">\n" +
      "    <param name=\"loop\" value=\"true\">\n" +
      "    <param name=\"quality\" value=\"high\">\n" +
      "</OBJECT>" +
      "</BODY>" +
      "</HTML>";

    final boolean result = new ActiveXDetector().willRequestActiveX(content);
    Assert.assertTrue(result);
  }

  @Test
  public void testHtmlContainingEmbedInUppercaseIsDetected(){

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
