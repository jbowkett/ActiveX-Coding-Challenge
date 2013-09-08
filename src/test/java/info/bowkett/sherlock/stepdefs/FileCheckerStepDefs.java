package info.bowkett.sherlock.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import info.bowkett.sherlock.*;
import org.junit.Assert;

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
  private DetectionLogger stubbedLogger;
  private List<Response> responses = new ArrayList<Response>();

  @Given("^a Filechecker that will check the following urls:$")
  public void a_Filechecker_that_will_check_the_following_urls(DataTable table) throws Throwable {

    final List<String> urls = new ArrayList<String>();
    final List<DataTableRow> dataTableRows = table.getGherkinRows();
    for (DataTableRow dataTableRow : dataTableRows) {
      final List<String> row = dataTableRow.getCells();
      urls.add(row.get(0));
    }
    checker = new FileChecker(stubInputFileReader(urls), new UrlRetriever(), new ActiveXDetector(), stubLogger());
  }

  private DetectionLogger stubLogger() {
    return new DetectionLogger(){
      @Override
      public void openFile(File outputFile) {
      }

      @Override
      public void log(int httpResponseCode, String url, boolean activeX){
        responses.add(new Response(httpResponseCode, url, activeX));
      }
    };
  }

  private InputFileReader stubInputFileReader(final List<String> urls) {
    return new InputFileReader(){
      @Override
      public Iterator<String> readFile(File inputFile) {
        return urls.iterator();
      }
    };
  }

  @When("^the file checker is run$")
  public void the_file_checker_is_run() throws Throwable {
    checker.checkFile(new File(""), new File(""));
  }

  @Then("^the output log will contain:$")
  public void output_log_will_contain(DataTable table) throws Throwable {
    final List<DataTableRow> dataTableRows = table.getGherkinRows();
    for (DataTableRow dataTableRow : dataTableRows) {
      final List<String> row = dataTableRow.getCells();
      final Response toAssert = new Response(Integer.parseInt(row.get(0)), row.get(1), row.get(2).equalsIgnoreCase("true"));
      Assert.assertTrue(responses.contains(toAssert));
    }
  }


  private static class Response{
    private final int httpResponseCode;
    private final String url;
    private final boolean activeX;

    public Response(int httpResponseCode, String url, boolean activeX) {
      this.httpResponseCode = httpResponseCode;
      this.url = url;
      this.activeX = activeX;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Response response = (Response) o;

      if (activeX != response.activeX) return false;
      if (httpResponseCode != response.httpResponseCode) return false;
      if (!url.equals(response.url)) return false;

      return true;
    }

    @Override
    public int hashCode() {
      int result = httpResponseCode;
      result = 31 * result + url.hashCode();
      result = 31 * result + (activeX ? 1 : 0);
      return result;
    }
  }
}
