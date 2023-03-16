import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuickSort {
static void swap(int[] a, int idx1, int idx2) {
    int d=a[idx1];
    a[idx1]=a[idx2];
    a[idx2]=d;
}
static void quickSort(int[] a, int left, int right) {
    int pl=left;
    int pr=right;
    int pivot=a[(pl+pr)/2];
    while(pl<=pr){
        while(a[pl]<pivot){
            pl=pl+1;
        }while(a[pr]>pivot){
            pr=pr-1;
        }if(pl<=pr){
            swap(a, pl, pr);
            pl=pl+1;
            pr=pr-1;
        }
    }
    if(left<pr){
        quickSort(a, left, pr);
    }if(pl<right){
        quickSort(a, pl, right);
    }

}
public static void main(String[] args) throws IOException {
    Path file=Paths.get("./testdata-sort-4.txt");
    List<String> stringData=Files.readAllLines(file);

    int[] x = new int[stringData.size()];
    int nx=x.length;
    for (int i = 0; i < x.length; i++) {
        x[i]=Integer.parseInt(stringData.get(i));
    }

    System.out.println("quick sort");
    long start=System.currentTimeMillis();
    quickSort(x, 0, x.length-1);
    for (int i = 0; i < nx; i++){
        System.out.println("x[" + i + "]=" + x[i]); 
    }

    long end=System.currentTimeMillis();
    System.out.println("Execution time: "+ (end-start));
}
}