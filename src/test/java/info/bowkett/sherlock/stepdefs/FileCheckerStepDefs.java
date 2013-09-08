package info.bowkett.sherlock.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import info.bowkett.sherlock.ActiveXDetector;
import info.bowkett.sherlock.FileChecker;
import info.bowkett.sherlock.InputFileReader;
import info.bowkett.sherlock.UrlRetriever;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbowkett
 * Date: Sep 8, 2013
 * Time: 12:26:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileCheckerStepDefs {
  private FileChecker checker;

  @Given("^a Filechecker that will check the following urls:$")
  public void a_Filechecker_that_will_check_the_following_urls(DataTable table) throws Throwable {

    final List<String> urls = new ArrayList<String>();
    final List<DataTableRow> dataTableRows = table.getGherkinRows();
    for (DataTableRow dataTableRow : dataTableRows) {
      final List<String> row = dataTableRow.getCells();
      urls.add(row.get(0));
    }
    checker = new FileChecker(stubInputFileReader(urls), new UrlRetriever(), new ActiveXDetector());
  }

  private InputFileReader stubInputFileReader(final List<String> urls) {
    return new InputFileReader(){
      public Iterator<String> readFile(File inputFile) {
        return urls.iterator();
      }
    };
  }

  @When("^the file checker is run$")
  public void the_file_checker_is_run() throws Throwable {
    checker.checkFile(new File(""), new File("output.txt"));
  }

  @Then("^the output log will contain:$")
  public void output_log_will_contain(DataTable arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
    // For automatic conversion, change DataTable to List<YourType>
    throw new PendingException();
  }

}
