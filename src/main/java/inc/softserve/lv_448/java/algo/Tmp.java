package inc.softserve.lv_448.java.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tmp {
    public static void main(String[] args) {
        String s = "This is a  string";
        System.out.println(Arrays.toString(s.split(" ")));
        List<String> list = Stream.of(s.split(" "))
                .filter((i) -> ! i.isEmpty())
                .collect(Collectors.toList());

    }
}
