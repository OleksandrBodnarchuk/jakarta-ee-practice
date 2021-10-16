package pl.alex.lotterygame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumberHelper {

    static List<Integer> generateRandomNumbers(){
        List<Integer> integers = IntStream.rangeClosed(1,49)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.subList(0,6);
    }
    static List<Integer> getCommonNumbers(List<Integer>source,List<Integer>target){
        List<Integer>sourceCopy = new ArrayList<>(source);
        sourceCopy.retainAll(target);
        return sourceCopy;
    }
}
