package leetcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author yitian
 * @date 2020/6/20 20:11
 */
public class FooPay {


    public static void main(String[] args) {
        ConcurrentHashMap<Integer,AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger1 = new AtomicInteger(1);
        AtomicInteger atomicInteger2 = new AtomicInteger(2);
        concurrentHashMap.put(1,atomicInteger1);
        concurrentHashMap.put(2,atomicInteger2);
        concurrentHashMap.get(1).incrementAndGet();
        System.out.println(atomicInteger1.get());





    }


}
