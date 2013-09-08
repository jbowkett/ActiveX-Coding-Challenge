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
  private final String url;

  public UrlResponse(int httpResponseCode, String urlContent, String url) {
    this.httpResponseCode = httpResponseCode;
    this.urlContent = urlContent;
    this.url = url;
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

  public String getUrl() {
    return url;
  }

  /**
   * @return a urlresponse from a url that cannot be read from.
   * see: Uncle Bob
   */
  public static UrlResponse cannotReadFrom(String url) {
    return new UrlResponse(-1, "", url);
  }
}
