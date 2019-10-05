package inc.softserve.lv_448.java.algo.starter;

import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

public class Starter {

    public static void main(String[] args) throws Exception {
        greeting();
        try(ConsoleReader consoleReader = new ConsoleReader()) {
            String command;
            do {
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
        System.out.println("We welcome you ar out program! Choose what you want to do:\n"
                + "enter 1 if you want to sort an array;\n"
                + "enter 2 if you want to use dynamic programming to calculate;\n"
                + "enter 'exit' if you want to exit."
        );
    }
}
