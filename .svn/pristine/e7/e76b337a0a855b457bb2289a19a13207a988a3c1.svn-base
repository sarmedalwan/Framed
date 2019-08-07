// TDD means we write a test before the code that passes it
// and iteratively keeps adding tests and code
// until we are satisfied with the functionality of the class
// In TDD, code enough for the program to compile and to pass the tests
// ctrl-shift-T to create test class

public class URLparser {

    private String protocol;
    private String site;
    private String pathname;

    // constructor to pass urls
    public URLparser(String url) {
        String[] protocol_site = url.split("://");
        protocol = protocol_site[0];
        String[] site_pathname = protocol_site[1].split("/, 2");
        site = site_pathname[0];
        if (site_pathname.length > 1)
            pathname = site_pathname[1];
        else
            pathname = "";
    }

    public String getProtocol() {
        return protocol;
    }

    public String getSite() {
        return site;
    }

    public String getPathname() {
        return pathname;
    }
}
