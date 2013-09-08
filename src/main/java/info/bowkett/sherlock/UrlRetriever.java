package info.bowkett.sherlock;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:35:27 AM
 *
 * Gets data from a url and reads into a url response.
 *
 * Will follow redirects (assume this is wanted, as Sergei mentioned this in
 * my first interview!)
 */
public class UrlRetriever {

  public UrlResponse getUrl(String stringUrl) {
    HttpURLConnection connection = null;
    InputStream inputStream = null;

    try {
      connection = openConnection(stringUrl);
      connection.setInstanceFollowRedirects(true);
      final int responseCode = connection.getResponseCode();

      final String responseContent = read(connection.getInputStream());
      return new UrlResponse(responseCode, responseContent, finalUrlFor(connection));
    }
    catch (IOException e) {
      return UrlResponse.cannotReadFrom(stringUrl);
    }
    finally{
      close(connection, inputStream);
    }
  }

  /**
   * @param connection
   * @return the final url that was retrieved, for instance if the connection was redirected
   */
  private String finalUrlFor(HttpURLConnection connection) {
    return connection.getURL().toString();
  }

  private HttpURLConnection openConnection(String stringUrl) throws IOException {
    final URL url = new URL(stringUrl);
    return (HttpURLConnection) url.openConnection();
  }

  private String read(InputStream inputStream) throws IOException {
    final StringBuilder response = new StringBuilder();
    final byte[] buffer = new byte[65536];
    int numRead = 0;

    while ((numRead = inputStream.read(buffer)) > 0) {
      response.append(new String(buffer, 0, numRead));
    }
    return response.toString();
  }

  private void close(HttpURLConnection connection, InputStream inputStream) {
    try{
      if(inputStream != null) inputStream.close();
      if(connection != null) connection.disconnect();
    }
    catch(Exception e){
    }
  }
}
