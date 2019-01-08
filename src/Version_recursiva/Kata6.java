package Version_recursiva;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Yusef Boutahar
 *
 */
public class Kata6 {
	
	private static List<File> ListOfFiles = new ArrayList<>();

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        getAll(new File("/"));

        for (File f : ListOfFiles) {
            System.out.println(f);
        }
        Histogram histo = new Histogram<>(megabytes(length(iteratorOf(ListOfFiles))));
        System.out.println("El histograma resulta: " + histo.keySet());
        long time2 = System.currentTimeMillis();
        System.out.println("\nEl tiempo de ejecucion es: " + (time2-time1) + " miliseconds");

    }
    
    /**
     * Metodo recursivo que se encarga de recorrer todos las carpetas
     * 
     * @param file, ruta a recorrer
     */
    private static void getAll(File file){
        File[] files = file.listFiles();   
        if (files != null){
        	Arrays.asList(files).forEach((f)->{
        		ListOfFiles.add(f);
                getAll(f);
        	});
        }
    }

    
    private static <T> Iterator<T> iteratorOf(List<T> files) {
        return new Iterator<T>(){
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < files.size();
            }

            @Override
            public T next() {
                return files.get(index++);
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
