import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SelectionSort{
    static void swap(int[] a, int idx1, int idx2){
        int smallernumber=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=smallernumber;
    }
    static void selectionSort(int[] a, int n){
        for(int i=0; i<n-1; i++){
            int min =i;
            for(int j=i+1; j<n; j++){
                if(a[j]<a[min]){
                    min =j;
                }
            }
            swap(a, i, min);
        }
    }
    public static void main(String[] args){
        try{
            Path file=Paths.get("./testdata-sort-2.txt");
            List<String>stringData=Files.readAllLines(file);
            
            int[] array=new int[stringData.size()];
            for(int i=0; i<array.length; i++){
                array[i]=Integer.parseInt(stringData.get(i));
            }
            Scanner stdIn = new Scanner(System.in);
            int[] x = new int[100000];
            for (int i = 0; i < 100000; i++) {
                System.out.print("x[" + i + "] : "+ array[i]+"\n");
                x[i] = array[i];
            }

            System.out.println("selection sort");
            long start = System.currentTimeMillis();
            selectionSort(x, 100000);
            System.out.println("Sorted array");
            for (int i = 0; i < 100000; i++)
                System.out.println("x[" + i + "]=" + x[i]);
            
            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - start));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}