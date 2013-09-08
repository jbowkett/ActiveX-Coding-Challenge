package info.bowkett.sherlock;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:38:20 AM
 *
 * Immutable class to represent a response from a url
 *
 */
public class UrlResponse {
  private final int httpResponseCode;
  private final String urlContent;

  public UrlResponse(int httpResponseCode, String urlContent) {
    this.httpResponseCode = httpResponseCode;
    this.urlContent = urlContent;
  }

  public int getHttpResponseCode() {
    return httpResponseCode;
  }

  public String getUrlContent() {
    return urlContent;
  }

  public boolean wasFound(){
    return httpResponseCode == 200;
  }

}
