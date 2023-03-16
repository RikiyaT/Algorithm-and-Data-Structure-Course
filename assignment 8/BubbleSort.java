import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int d=a[idx1];
        a[idx1]=a[idx2];
        a[idx2]=d;
    }
    static void bubbleSort(int[] a, int n) {
        for(int i=0; i<n-2; i++){
            for(int j=n-1; j>=i+1; j--){
                if(a[j-1] > a[j]){
                    swap(a, j-1, j);
                }
            }
        }
    }
    static void bubbleSort1(int[] a, int n) {
        for(int i=0; i<=n-2; i++){
            int exchg=0;
            for(int j=n-1; j>=i+1; j--){
                if(a[j-1]>a[j]){
                    swap(a, j-1, j);
                    exchg = exchg+1;
                }
            }
            if(exchg==0){
                break;
            }
        }
    }
    static void bubbleSort2(int[] a, int n) {
        int k=0;
        while(k<n-1){
            int last=n-1;
            for(int j=n-1; j>=k+1; j--){
                if(a[j-1]>a[j]){
                    swap(a, j-1, j);
                    last=j;
                }
            }
            k=last;
        }
    }
    public static void main(String[] args) {
        try{
            Path file=Paths.get("./testdata-sort-3.txt");
            List<String>stringData=Files.readAllLines(file);
            int [] x = new int[stringData.size()];
            int nx = x.length;
            for (int i = 0; i < x.length; i++) {
                x[i]=Integer.parseInt(stringData.get(i));
            }
            
            System.out.println("Bubble sort");
            long start = System.currentTimeMillis();
            bubbleSort2(x, nx);

            System.out.println("Sorted array");
            for (int i = 0; i < nx; i++){
                System.out.println("x[" + i + "]=" + x[i]);
            }
            long end = System.currentTimeMillis();
            System.out.println("Execution time: "+(end - start));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}