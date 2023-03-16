import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BinarySearch {
static int binarySearch(int[] a, int pl, int pr, int key) {
    if(pl<=pr){
        int pc=(pl+pr)/2;
        if(a[pc]<key){
            return binarySearch(a, pc+1, pr, key);
        }else if(a[pc]>key){
            return binarySearch(a, pl, pc-1, key);
        }else{
            return pc;
        }
    }
    return -1;
}
public static void main(String[] args) throws IOException {
    Path file=Paths.get("./testdata-search.txt");
    List<String> stringData=Files.readAllLines(file);

    int[] x=new int[stringData.size()];
    int num = x.length;
    for (int i = 0; i < x.length; i++) {
        x[i]=Integer.parseInt(stringData.get(i));
    }
    System.out.print("Key: ");
    Scanner stdIn = new Scanner(System.in);
    int key = stdIn.nextInt();
    int index = binarySearch(x, 0, x.length-1, key);
    if(index == -1){
        System.out.println("Not found");
    }
    else{
        System.out.println("Found in array[" + index + "]");
    }
}
}