package inc.softserve.lv_448.java.algo.starter;

import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

public class Starter {

    public static void main(String[] args) throws Exception {
        try(ConsoleReader consoleReader = new ConsoleReader()) {
            String command;
            do {
                greeting();
                command = consoleReader.readString();
                switch (command) {
                    case "sort":
                        Sorter.input(consoleReader);
                        break;
                    case "calc":
                        DP.input(consoleReader);
                        break;
                    default:
                        System.out.println("There is no such an option! Try again.");
                }
            } while (true);
        }
    }

    private static void greeting(){
        System.out.println("\nWe welcome you to our program! Choose what you want to do:\n"
                + "enter 'sort' if you want to sort an array;\n"
                + "enter 'calc' if you want to use dynamic programming to calculate;\n"
                + "enter 'exit' if you want to exit."
        );
    }
}
