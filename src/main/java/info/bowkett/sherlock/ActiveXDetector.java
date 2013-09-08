package info.bowkett.sherlock;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:47:02 AM
 *
 * Detects if the url content will request activeX components
 *
 */
public class ActiveXDetector {
  public boolean willRequestActiveX(String urlContent) {

    return removeLineBreaks(urlContent.toLowerCase()).matches(".*<embed .*|.*<object .*");
  }

  private String removeLineBreaks(String urlContent) {
    return urlContent.replaceAll("\n", " ");
  }
}
