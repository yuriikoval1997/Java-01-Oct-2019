package inc.softserve.lv_448.java.algo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleReader implements AutoCloseable{

    private final BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Reads space separated numbers from the console. If NaN appears, the user will have to repeat.
     * If the user types 'exit', the program stops.
     * @return list of integers
     */
    public List<Integer> readIntegers(){
        while (true){
            System.out.println("Please, enter space separated integers:");
            try {
                String line = bufferedReader.readLine().trim();
                if (line.equals("exit")){
                    System.out.println("Thanks for using our program");
                    System.exit(0);
                }
                String[] numbers = line.split(" ");
                return Stream.of(numbers)
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
     * Reads an integer from the console. If NaN appears, the user have to repeat.
     * If the user types 'exit', the program stops.
     * @return an integer
     */
    public int readInt(){
        while (true){
            System.out.println("Please, enter an integer:");
            try {
                return Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException nfe){
                System.out.println("You entered not a number. Try again!");
            } catch (IOException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * If the user types 'exit', the program stops.
     * @return string read from the console.
     */
    public String readString(){
        try {
            String line = bufferedReader.readLine().trim();
            if (line.equals("exit")){
                System.out.println("Thanks for using our program");
                System.exit(0);
            }
            return line;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }
}