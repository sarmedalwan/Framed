import static org.junit.Assert.*;

public class URLparserTest {

    @org.junit.Test
    public void test_basic_http_protocol() {
        // passes URL through the parser at construction time
        URLparser p = new URLparser("http://www.essex.ac.uk");
        // get method accesses the URL components
        assertTrue(p.getProtocol().equals("http"));
    }

    @org.junit.Test
    public void test_basic_ftp_protocol() {
        URLparser p = new URLparser("ftp://ftp.essex.ac.uk");
        assertTrue(p.getProtocol().equals("ftp"));
    }

    @org.junit.Test
    public void test_generic_protocol() {
        URLparser p = new URLparser("xyz://www.abc.com");
        assertTrue(p.getProtocol().equals("xyz"));
    }

    // after testing protocols
    // test for site addresses
    @org.junit.Test
    public void test_simple_site() {
        URLparser p = new URLparser("http://www.essex.ac.uk");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @org.junit.Test
    public void test_simple_site_with_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/index.html");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @org.junit.Test
    public void test_simple_site_with_slash() {
        URLparser p = new URLparser("http://www.essex.ac.uk/");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @org.junit.Test
    public void test_simple_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/csee");
        assertTrue(p.getPathname().equals("csee"));
    }

    @org.junit.Test
    public void test_complex_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/csee/staff/rpoli.html");
        assertArrayEquals("csee/staff/rpoli.html".getBytes(), p.getPathname().getBytes());
    }

    // limit cases
    @org.junit.Test
    public void test_simple_empty_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk");
        assertTrue(p.getPathname().equals(""));
    }

    @org.junit.Test
    public void test_simple_single_slash_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/");
        assertTrue(p.getPathname().equals(""));
    }
}