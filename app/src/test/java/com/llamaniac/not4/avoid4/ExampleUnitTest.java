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
        testGrid.setActivePlayer(1);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGridConstructor() throws Exception {
        assertTrue(testGrid.getBoard()[0][0]==0);
        testGrid.printGrid();

    }

    @Test
    public void testGetNextRow(){
        assertEquals(testGrid.getNextRow(0),4);
    }

    @Test
    public void testAdd(){
        testGrid.add(0);
        testGrid.printGrid();
        assertEquals(testGrid.getNextRow(0),3);
    }



}