package inc.softserve.lv_448.java.algo.dynamic_programming.sequences;

import inc.softserve.lv_448.java.algo.starter.Startable;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModifiedFibonacci implements SeqGenerator, Startable {

    @Override
    public void start(ConsoleUtil consoleUtil) {
    }

    private final List<Integer> seq = new ArrayList<>();

    public ModifiedFibonacci(){
        seq.add(0);
        seq.add(1);
        seq.add(1);
    }

    /**
     * Generates Modified Fibonacci sequence and caches the previous solution<br/>
     * 0 is 0th element, 1 is 1th element, 1 is 2d element,
     * fib(n) = fib(n-3) + fib(n-2) + fib(n-1) is a function that gives n-th element.<br/>
     * Then the sequence has the next appearance: 0, 1, 1, 2, 4, ... fib(n-3)+fib(n-2)+fib(n-1)<br/>
     * @param number - end of the sequence, inclusive
     * @return - modified fibonacci sequence or empty list if number is less than 0.
     */
    @Override
    public List<Integer> apply(int number) {
        if (number < 0){
            return Collections.emptyList();
        }
        if (number < seq.size()){
            return Collections.unmodifiableList(seq);
        }
        for (int i = seq.size() - 1; i < number; i++) {
            seq.add(seq.get(i-2) + seq.get(i-1) + seq.get(i));
        }
        return Collections.unmodifiableList(seq);
    }
}
