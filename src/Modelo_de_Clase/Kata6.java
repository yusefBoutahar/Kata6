package Modelo_de_Clase;

import java.io.File;
import java.util.Iterator;

/**
 * 
 * @author Yusef Boutahar
 *
 */
public class Kata6 {
	
    public static void main(String[] args) {
        File root = new File("/");
        
        for (File f : root.listFiles()) {
            System.out.println(f);
        }
        long time1 = System.currentTimeMillis();
        Histogram hist = new Histogram<>(megabytes(length(iteratorOf(root.listFiles()))));
        System.out.println("El histograma resulta: " + hist.keySet());
        long time2 = System.currentTimeMillis();
        System.out.println("El tiempo de ejecucion es: " + (time2-time1) + " miliseconds");

    }

    private static <T> Iterator<T> iteratorOf(T[] files) {
        return new Iterator<T>(){
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < files.length;
            }

            @Override
            public T next() {
                return files[index++];
            }
        };
    }

    private static Iterator<Long> length(Iterator<File> iterator) {
        return new Iterator<Long>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }

    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
        };
    }
}
