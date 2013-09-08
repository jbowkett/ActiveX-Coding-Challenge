package info.bowkett.sherlock;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 10:25:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {


  public static void main(String [] args){

    if(incorrectArgumentCount(args)){
      usage();
      System.exit(-1);
    }

    final File inputDir = new File(args[0]);
    final File outputDir = new File(args[1]);

    final File[] inputFiles = inputDir.listFiles(new EightDigitsOnlyFilenameFilter());



  }

  private static void usage() {
    System.err.println("Usage :\nMain <input directory> <output directory>");

  }

  private static boolean incorrectArgumentCount(String[] args) {
    return args.length != 2;
  }
}
