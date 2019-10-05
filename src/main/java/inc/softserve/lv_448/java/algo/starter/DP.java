package inc.softserve.lv_448.java.algo.starter;

import inc.softserve.lv_448.java.algo.dynamic_programming.DifferenceOne;
import inc.softserve.lv_448.java.algo.dynamic_programming.sequnences.Extractor;
import inc.softserve.lv_448.java.algo.dynamic_programming.sequnences.Fibonacci;
import inc.softserve.lv_448.java.algo.dynamic_programming.sequnences.ModifiedFibonacci;
import inc.softserve.lv_448.java.algo.utils.ConsoleReader;

class DP {

    static void input(ConsoleReader consoleReader){
        showOptions();
        String command;
        Object result = null;
        Extractor extractor;
        label:
        do {
            command = consoleReader.readString();
            switch (command) {
                case "1":
                    extractor = new Extractor(new Fibonacci());
                    result = extractor.extract(consoleReader.readInt());
                    break label;
                case "2":
                    extractor = new Extractor(new ModifiedFibonacci());
                    result = extractor.extract(consoleReader.readInt());
                    break label;
                case "3":
                    result = DifferenceOne.longestSubSeq(consoleReader.readIntegers());
                    break label;
                case "4":
                    //todo - cases
                    break label;
                default:
                    System.out.println("There is no such an option! Try again.");
                    break;
            }
        } while (true);
        System.out.println("The result is: " + result);
    }

    private static void showOptions() {
        System.out.println("Choose what you want to do:\n"
                + "1 = fibonacci number;\n"
                + "2 = modified;\n"
                + "3 = difference one;\n"
                //todo - options
        );
    }
}
