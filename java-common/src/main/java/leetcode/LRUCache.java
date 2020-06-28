package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 最近最少使用”缓存
 *
 * @author yitian
 * @date 2020/6/22 16:47
 */
public class LRUCache {

    private ConcurrentHashMap<Integer,AtomicInteger> cacheAtomicInteger = new ConcurrentHashMap<>();

    private ConcurrentHashMap<Integer,Integer> cache = new ConcurrentHashMap<>();

    private Object lock = new Object();

    Map<Integer,Integer> cache1 = null;

    private int capacity;

    public LRUCache(int capacity) {

        cache1 = new LinkedHashMap(capacity,0.75f,true){
            private static final long serialVersionUID = -7992526534668166440L;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if(this.size() > capacity){
                    return true;
                }
                return false;
            }

        };

    }

    public int get(int key) {
        Integer v = this.cache1.get(key);
        return v==null?-1:v.intValue();
    }

    public void put(int key, int value) {
        this.cache1.put(key,value);
    }

}
