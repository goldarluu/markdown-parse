import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testNewFile() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Testing for test-file.md", List.of("https://something.com", "some-page.html"), links);
    }

    @Test 
    public void testnewFile() throws IOException{
        Path fileName = Path.of("new-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Testing for new_file.md", List.of("googledoc.com"), links);
    }

    @Test 
    public void testlinkfirstFile() throws IOException{
        Path fileName = Path.of("link_first.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertNotEquals("Testing for link_first.md", List.of("googledoc.com"), links);
    }

    @Test 
    public void testincorrectlinkFile() throws IOException{
        Path fileName = Path.of("incorrectlink.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Testing for incorrectlink.md", List.of(), links);
    }
    

}