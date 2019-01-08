package Modelo_de_Clase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Yusef Boutahar
 *
 * @param <T>
 */
public class Histogram<T> {

    private Map<T,Integer> map = new HashMap<>();

    public Histogram(Iterator<T> iterator){
        this(iterableOf(iterator));
    }

    public Histogram(Iterable<T> iterable){
        for (T obj : iterable) increment(obj);
    }

    private static <T> Iterable<T> iterableOf(Iterator<T> iterator){
        return new Iterable<T>(){
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }
    
    public Set<Map.Entry<T,Integer>> keySet(){
    	return map.entrySet();
    }

    public void increment(T key){
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }

    public Integer get(T key){
        return map.get(key);
    }
    
}