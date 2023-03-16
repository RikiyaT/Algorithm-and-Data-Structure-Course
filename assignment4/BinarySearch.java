import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BinarySearch{
    public static int binarySearch(int[] a, int n, int key){
        int pl=0;
        int pr=n-1;
        int pc;
        while(pl<=pr){
            pc=(pl+pr)/2;
            if(a[pc]<key){
                pl=pc+1;
            }else if(a[pc]>key){
                pr=pc-1;
            }else{
                return pc;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        try{
            Path file=Paths.get("./testdata-search.txt");
            List<String>stringData=Files.readAllLines(file);
            
            int[] array=new int[stringData.size()];
            for(int i=0; i<array.length; i++){
                array[i]=Integer.parseInt(stringData.get(i));
            }
        
            int num = array.length;
            System.out.print("Key: 799829\n");
            int key = 799829;
            int index = binarySearch(array, num, key);
            if(index == -1)
                System.out.println("Not found");
            else
                System.out.println("Found in array[" + index + "]");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}