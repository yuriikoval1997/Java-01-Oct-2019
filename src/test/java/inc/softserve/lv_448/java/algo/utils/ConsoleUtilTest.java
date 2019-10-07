package inc.softserve.lv_448.java.algo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.opentest4j.AssertionFailedError;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ConsoleUtilTest {

    @Mock
    BufferedReader bufferedReader;

    private ConsoleUtil consoleUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        consoleUtil = new ConsoleUtil(bufferedReader);
    }

    @Test
    void readIntegers() throws IOException {
        String input = "   10 38 17   121 123   8281 1 22 17 22    ";
        when(bufferedReader.readLine()).thenReturn(input);
        List<Integer> actual = consoleUtil.readIntegers("a message");
        List<Integer> expected = Stream.of(input.split(" "))
                .filter(x -> !x.isEmpty())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test
    void readIntegersWithTimeout() throws IOException {
        String input = "   10 38 17   I'm an Integer 123   8281 1 22 17 22    ";
        when(bufferedReader.readLine()).thenReturn(input);
        try{
            assertTimeoutPreemptively(ofMillis(100), () -> consoleUtil.readIntegers("a message"));
        } catch (AssertionFailedError ignored){
            return;
        }
        fail();
    }

    @Test
    void readInt() throws IOException {
        String input = "    291";
        when(bufferedReader.readLine()).thenReturn(input);
        int actual = consoleUtil.readInt("a message");
        int expected = Integer.parseInt(input.trim());
        assertEquals(expected, actual);
    }

    @Test
    void readIntWithTimeOut() throws IOException {
        String input = "    Believe me! I'm an 88";
        when(bufferedReader.readLine()).thenReturn(input);
        try {
            assertTimeoutPreemptively(ofMillis(100), () -> consoleUtil.readInt("a message"));
        } catch (AssertionFailedError ignored){
            return;
        }
        fail();
    }

    @Test
    void readString() throws IOException {
        String input = "And I will strike you down with grate vengeance and furious anger. " +
                "And you will know my name is a Lord when I lay my vengeance upon you.";
        when(bufferedReader.readLine()).thenReturn(input);
        String actual = consoleUtil.readString("a message");
        String expected = input.trim();
        assertEquals(expected, actual);
    }
}