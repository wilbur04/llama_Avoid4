package com.llamaniac.not4.avoid4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Grid testGrid;
    @Before
    public void executedBeforeEach() {
        testGrid = new Grid();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGridConstructor() throws Exception {
        assertTrue(testGrid.getBoard()[0][0]==0);
    }
}