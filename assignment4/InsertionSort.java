import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



public class InsertionSort{
    static void insertionSort(int[] a, int n){
        for(int i=1; i<n; i++){
            int tmp=a[i];
            int j;
            for(j=i-1; j>=0&&a[j]>tmp; j--){
                a[j+1]=a[j];
            }
            a[j+1]=tmp;
        }
    }

    public static void main(String[] args){
        try{
            Path file=Paths.get("./testdata-sort-4.txt");
            List<String>stringData=Files.readAllLines(file);
            
            int[] array=new int[stringData.size()];
            for(int i=0; i<array.length; i++){
                array[i]=Integer.parseInt(stringData.get(i));
            }
            Scanner stdIn = new Scanner(System.in);
            int[] x = new int[1000000];
            for (int i = 0; i < 1000000; i++) {
                System.out.print("x[" + i + "] : "+ array[i]+"\n");
                x[i] = array[i];
            }

            System.out.println("insertion sort");
            long start = System.currentTimeMillis();
            insertionSort(x, 1000000);
            System.out.println("Sorted array");
            for (int i = 0; i < 1000000; i++)
                System.out.println("x[" + i + "]=" + x[i]);

            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - start));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}