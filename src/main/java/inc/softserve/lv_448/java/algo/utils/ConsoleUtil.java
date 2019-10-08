package inc.softserve.lv_448.java.algo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleUtil implements AutoCloseable{

    private final BufferedReader bufferedReader;

    public ConsoleUtil(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    /**
     * Reads space separated numbers from the console. If NaN appears, the user will have to repeat.
     * If the user types 'exit', the program stops.
     * @return list of integers
     */
    public List<Integer> readIntegers(String message){
        while (true){
            System.out.println(message);
            try {
                String line = bufferedReader.readLine().trim();
                String[] numbers = line.split(" ");
                return Stream.of(numbers)
                        .filter(x -> ! x.isEmpty())
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
            } catch (NumberFormatException nfe){
                System.out.println("You entered not a number. Try again!");
            } catch (IOException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method works until a user inputs an integer. Otherwise, it asks the user to repeat.
     * @param message - prompt to be shown to a user.
     * @return - an integer.
     */
    public int readInt(String message){
        while (true){
            System.out.println(message);
            try {
                return Integer.parseInt(bufferedReader.readLine().trim());
            } catch (NumberFormatException nfe){
                System.out.println("You entered not a number. Try again!");
            } catch (IOException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param message - prompt to be shown to a user.
     * @return - a user's input as String.
     */
    public String readString(String message) {
        System.out.println(message);
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void printResult(int... result) {
        System.out.println("Your result is: " + Arrays.toString(result));
    }

    public void printLongResult(long... result){
        System.out.println("Your result is: " + Arrays.toString(result));
    }

    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }
}
