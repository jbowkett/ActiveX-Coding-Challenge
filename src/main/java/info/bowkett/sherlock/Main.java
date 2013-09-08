package info.bowkett.sherlock;

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

    final String inputDir = args[0];
    final String outputDir = args[1];


  }

  private static void usage() {
    System.err.println("Usage :\nMain <input directory> <output directory>");

  }

  private static boolean incorrectArgumentCount(String[] args) {
    return args.length != 2;
  }
}
