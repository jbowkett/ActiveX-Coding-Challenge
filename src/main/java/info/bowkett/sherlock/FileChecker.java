package info.bowkett.sherlock;

import java.io.File;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:08:41 AM
 *
 * Checks a file of urls and logs the activeX status of each url in an output file
 *
 */
public class FileChecker {
  private InputFileReader inputFileReader;
  private UrlRetriever urlRetriever;
  private ActiveXDetector activeXDetector;
  private final DetectionLogger detectionLogger;

  public FileChecker(InputFileReader inputFileReader, UrlRetriever urlRetriever, ActiveXDetector activeXDetector, DetectionLogger detectionLogger) {
    this.inputFileReader = inputFileReader;
    this.urlRetriever = urlRetriever;
    this.activeXDetector = activeXDetector;
    this.detectionLogger = detectionLogger;
  }


  public void checkFile(File inputFile, File outputFile) {
    detectionLogger.openFile(outputFile);
    final Iterator<String> urls = inputFileReader.readFile(inputFile);

    while(urls.hasNext()){
      final UrlResponse response = urlRetriever.getUrl(urls.next());
      // todo/note: outputs the ultimate url, not the original url     
      detectionLogger.log(response.getHttpResponseCode(), response.getUrl(), isActiveX(response));
    }
    detectionLogger.closeFile(outputFile);
  }

  private boolean isActiveX(UrlResponse response) {
    return response.wasFound() && activeXDetector.willRequestActiveX(response.getUrlContent());
  }
}
