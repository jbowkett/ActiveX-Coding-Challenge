package info.bowkett.sherlock;

import sun.font.Type1Font;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 11:08:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileChecker {
  private InputFileReader inputFileReader;

  public FileChecker(InputFileReader inputFileReader) {
    this.inputFileReader = inputFileReader;
  }


  public void checkFile(File inputFile, File outputFile) {
    //read each line in the input file
    final Iterator<String> urls = inputFileReader.readFile(inputFile);
    //open url
    //hand url to the active x detector
    //write result to output file

  }

}
