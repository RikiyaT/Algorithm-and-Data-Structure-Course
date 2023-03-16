import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BruteForceStringSearch {
static int bfSearch (String txt, String pattern) {
    int pp=0;
    int pt=0;
    while(pt!=txt.length()&&pp!=pattern.length()){
        if(txt.charAt(pt)==pattern.charAt(pp)){
            pt++;
            pp++;
        }else{
            pt=pt-pp+1;
            pp=0;
        }
    }
    if(pp==pattern.length()){
        return pt-pp;
    }
    return -1;
}
public static void main(String[] args) throws IOException {
    Path file=Paths.get("./testdata-stringsearch.txt");
    List<String> stringData=Files.readAllLines(file);
    String[] array=new String[stringData.size()];
    for (int i = 0; i < array.length; i++){
        array[i]=stringData.get(i);
    }

    int num=array.length;
    System.out.print("pattern:");
    String str = stdIn.nextLine();
    int index=-1;

    for(int i=0; i < array.length; i++){
        index=bfSearch(array[i], str);
        if(index!=-1){
            System.out.println("Found at index"+(index+1)+"in line "+(i+1));
            break;
        }
    }

    if(index==-1){
        System.out.println("Not found");
    }
    
    /* 
    if (idx == -1){
        System.out.println("There is no pattern in text.");
    }
    else {
        int len = 0;
        for (int i = 0; i < idx; i++)
            len += s1.substring(i, i + 1).getBytes().length;
        len += s2.length();
        System.out.println("match at " + (idx + 1));
        System.out.println(s1);
        System.out.printf(String.format("%%%ds¥n", len), s2);
    }
    */
}
}