package quotes;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void test_toString1() {
        Quote quote = new Quote(new ArrayList<String>(), "Ricky Bobby", "1", "I'm too drunk to taste this chicken");
        assertEquals("quotes should match",
                "Author: Ricky Bobby\n" +
                "Quote: I'm too drunk to taste this chicken",
                quote.toString() );
    }

    @Test(expected = IOException.class)
    public void test_bad_file_throws_IO() throws IOException {
        App.readFromJson("/thisisabadname");
    }

    @Test
    public void test_file_reads_properly() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("Size of array is 138", 138, test.length);
    }

    @Test
    public void test_file_reads_properly2() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("First quote is from Marilyn Monroe", "Marilyn Monroe", test[0].author);
    }

    @Test
    public void test_file_reads_properly3() throws IOException {
        Quote[] test = App.readFromJson("src/main/resources/recentquotes.json");
        assertEquals("Last quote is from 办理明尼苏达大学双城分校毕业证[学历认证University of Minnesota Twin Cities",
                "办理明尼苏达大学双城分校毕业证[学历认证University of Minnesota Twin Cities",
                test[137].author);
    }

    @Test
    public void test_app_reads_from_url() throws IOException {
        String url = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
        Quote q = App.readFromUrl(url);
        assertTrue("Returned value should not be null", q != null);
    }

    @Test
    public void test_addToFileWorks() throws IOException {
        String url = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
        Quote q = App.readFromUrl(url);
        String sampleText = "I am one with the Force, the Force is with me";
        App.addToQuoteFile("src/main/resources/testQuotes.txt" , sampleText);
        assertTrue("Added string should be in the file", checkFileForSubstring(sampleText));
    }

    private static Boolean checkFileForSubstring(String sampleText) throws IOException {
        Scanner sc = new Scanner(new File("src/main/resources/testQuotes.txt"));
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.contains(sampleText)){
                return true;
            }
        }
        return false;
    }
}