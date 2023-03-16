import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ShellSort{
    static void shellSort(int[] a, int n){
        for(int h=n/2; h>0; h/=2){
            for(int i=h; i<n; i++){
                int tmp=a[i];
                int j;
                for(j=i-h; (j>=0)&&(a[j]>tmp);j=j-h){
                    a[j+h]=a[j];
                }
                a[j+h]=tmp;
            }
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
            System.out.print("The number of elements?: 100000\n");
            int nx = 100000;
            int[] x = new int[nx];
            for (int i = 0; i < nx; i++) {
                System.out.print("x[" + i + "] : "+array[i]+"\n");
                x[i] = array[i];
            }

            System.out.println("Shell sort");

            long start = System.currentTimeMillis();
            shellSort(x, nx);

            System.out.println("Sorted array");
            for (int i = 0; i < nx; i++){
                System.out.println("x[" + i + "]=" + x[i]);
            }
            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - start));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}