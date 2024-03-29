package gui_frame;

import compute_similarities.PDF;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FrameTest {
    private Frame testFrame;

    @Before
    public void setUp() {
        testFrame = new Frame();
    }

    @Test
    public void main() {
    }

    @Test
    public void testFrameIsVisible() {
        assertEquals(testFrame.isVisible(), true);
    }

    @Test
    public void testFrameNotResizable() {
        assertEquals(testFrame.isResizable(), false);
    }

    @Test
    public void testFrameExitsOnClose() {
        assertEquals(testFrame.getDefaultCloseOperation(), 3);
    }

    //There is no way to quantitatively test whether something is rendered to a display without using complex
    //computer vision libraries
    @Test
    public void testDrawingPDFIcons() {
        testFrame.pdfs.add(new PDF());
        testFrame.pdfs.get(0).name = "TestPDF1";

        testFrame.pdfs.add(new PDF());
        testFrame.pdfs.get(1).name = "TestPDF1";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBrowseFunctions() {
        testFrame.displaySimilaritiesForFilesInFolder("src/resources/");
        testFrame.browseFunctions(3);
        assertTrue(testFrame.calculatedSize > 300 && testFrame.calculatedSize < 1200);
    }

}
