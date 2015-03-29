package com.nomscon.lib.utils;

import org.junit.*;
import static org.junit.Assert.*;

public class StringUtilsTest {

    public StringUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsNullOrEmpty() {
        System.out.println("isNullOrEmpty");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPadCenter() {
        System.out.println("padCenter");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPadRight() {
        System.out.println("padRight");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPadLeft() {
        System.out.println("padLeft");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRepeat_char_int() {
        System.out.println("repeat");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
    * Test of repeat method, of class StringUtil.
    */
    @Test
    public void testRepeat_String_int() {
        System.out.println("repeat");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTrimRight() {
        System.out.println("trimRight");
        assertEquals("", StringUtils.trimRight(null));
        assertEquals("", StringUtils.trimRight(""));
        assertEquals("abcde", StringUtils.trimRight("abcde"));
        assertEquals("abcde", StringUtils.trimRight("abcde "));
        assertEquals(" abcde", StringUtils.trimRight(" abcde"));
        assertEquals(" abcde", StringUtils.trimRight(" abcde "));
    }

    @Test
    public void testTrimLeft() {
        System.out.println("trimLeft");
        assertEquals("", StringUtils.trimLeft(null));
        assertEquals("", StringUtils.trimLeft(""));
        assertEquals("abcde", StringUtils.trimLeft("abcde"));
        assertEquals("abcde ", StringUtils.trimLeft("abcde "));
        assertEquals("abcde", StringUtils.trimLeft(" abcde"));
        assertEquals("abcde ", StringUtils.trimLeft(" abcde "));
    }

    @Test
    public void testTruncateCenter() {
        System.out.println("truncateCenter");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTruncateRight() {
        System.out.println("truncateRight");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTruncateLeft() {
        System.out.println("truncateLeft");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
