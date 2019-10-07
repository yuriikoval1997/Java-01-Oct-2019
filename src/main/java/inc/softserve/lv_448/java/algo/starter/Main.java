package inc.softserve.lv_448.java.algo.starter;

import inc.softserve.lv_448.java.algo.cfg.BeanCreator;
import inc.softserve.lv_448.java.algo.utils.ConsoleUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BeanCreator beanCreator = new BeanCreator();
        beanCreator.initBeans();
        Map<Integer, Startable> container = beanCreator.getContainer();
        container.forEach((k, v) -> System.out.println(k + " = " + v.getClass().getSimpleName()));
        int taskNumber;
        try(ConsoleUtil consoleUtil = new ConsoleUtil(new BufferedReader(new InputStreamReader(System.in)))){
            do {
                taskNumber = consoleUtil.readInt("Enter task number");
                if (container.containsKey(taskNumber)){
                    Startable startable = container.get(taskNumber);
                    startable.start(consoleUtil);
                } else {
                    System.out.println("Sorry, there are no such an option");
                }
            } while (true);
        }
    }
}
