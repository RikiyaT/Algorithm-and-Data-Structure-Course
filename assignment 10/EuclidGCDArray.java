import java.util.Scanner;

public class EuclidGCDArray{
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }else{
            return gcd(y, x % y);
        }
    }

    static int gcdArray(int a[], int start, int no){
        if (no==1){Ar
            return a[start];
        }else if (no==2){
            return gcd(a[start], a[start+1]);
        }else{
            return gcd(a[start], gcdArray(a, start+1, no-1));
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("How many integers:");
        int num = stdIn.nextInt();
        int[] x = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }
        System.out.println("GCD is " + gcdArray(x, 0, num));
    }
}