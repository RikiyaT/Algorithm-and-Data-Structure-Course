import java.util.Scanner;

public class Hanoi{
    static int move(int no, int x, int y){
        int count=0;    
        if(no>1)
            count=count+move(no-1, x, 6-x-y);
        System.out.println("move disc["+no+"] from "+x+"to"+y+"");
        count++;
        if(no>1)
            count=count+move(no-1, 6-x-y, y);
        return count;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Tower of Hanoi");
        System.out.print("The number of disc:");
        int n = stdIn.nextInt();
        int num=move(n, 1, 3);
        System.out.println(""+num+" steps are required");
    }
}