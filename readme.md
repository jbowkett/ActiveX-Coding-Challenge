# Readme for ActiveX Coding Challenge by James Bowkett #


## Notes on unpacking ##

 * I used Git for source control, and all .git meta data should be present,
 this should also work once the tarball is unpacked.
 * I used Maven 3 to prepare the builds, see the pom.xml for details.
 * The released jar is in target/sherlock-1.0.jar.
 * To run the solution, type : `java -jar sherlock-1.0.jar`
 (from the target directory)

## Notes on Implementation ##

 * This code was implemented using Java 7, running under intelli-j (so as this
 tarball is unpacked, the project should be ready to go).
 * I used cucumber-JVM for BDD. See `src/test/features/filechecker.feature`
 * I used Junit for TDD
 * My main principles for coding were based on Uncle Bob's "Clean Code" hence,
 the numerous private helper methods and sparse commenting.
 * Outputs the ultimate redirected-to url, not the original url, this is easily
 changed though on line 36 of FileChecker
 * I researched ways to detect the actual content of the file to see if it is
 activeX, but doesn't seem like a nice way to do this as it seems it is a
 compiled format.  So I had to detect it using the parent HTML request, to look
 for <object..> or <embed...>.  It would be trivial to inspection of the the url
 for .exe/.cab/.ocx/.ctl/.alx in the filename being requested.
 * Given more time, it would be straightforward to write cucumber scenarios that 
 test the whole application by writing out an input file within the test and
 detecting the contents of the output file.


## Original challenge ##


Problem:

Create Java SE application to be run in Linux environment. Application should determine if attempt
to download ActiveX component occured based on single HTTP response received from server.

1. Application takes two filesystem paths as parameters: <input_dir> and <output_dir>.
2. Application reads all files in <input_dir> matching following wildcard: 'XXXXXXXX'. ( where X is
any digit 0-9, filename length is 8 symbols)
3. Every file contains 0 or more URLs delimited by '\n'.
4. Application performs HTTP requests to URLs fetched from input file.
5. Application writes <TAB> separated line for every URL to corresponding log file 'XXXXXXXX.log' in
<output_dir>.

'XXXXXXXX' format:
<url1>\n
<url2>\n
<url3>\n

'XXXXXXXX.log' format:
<datetime>\t<http_status_code>\t<url1>\t<is_activex>\n
<datetime>\t<http_status_code>\t<url2>\t<is_activex>\n
<datetime>\t<http_status_code>\t<url3>\t<is_activex>\n

<datetime> - timestamp, YYYY-MM-DD HH:MM:SS
<http_status_code> - HTTP response code
<url> - URL (taken from input file)
<is_activex> - flag indicating whether ActiveX component download or download attempt occured,
in both cases <is_activex> should be set to 1, in ALL other cases should be set to 0.

NOTES:
- Do not write line to resulting log file in case you don't receive response from server (i.e. HTTP 4XX and 5XX responses
are also valid and should be logged).
- Make sure that log files are written in atomic way i.e. resulting log file contains consistent results for all URLs listed in
corresponding input file at any given time.
- Treat ActiveX specific HTML as attempt to download actual ActiveX component.
- Please note that there are two more ways to detect if ActiveX component itself was downloaded after HTTP GET request.
It will be a plus if you can implement those checks as well.
- Please don't forget to include sources and instructions on how to run your application.
- Please don't ask about ActiveX detection methods, research is the part of the task.

