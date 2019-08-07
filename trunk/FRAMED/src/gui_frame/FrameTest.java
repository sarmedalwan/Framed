package gui_frame;

import static org.junit.Assert.*;

public class FrameTest {

    @org.junit.Test
    public void creation() {
        Frame testFrame = new Frame();
        assertEquals(testFrame.isVisible(),true);
    }
}