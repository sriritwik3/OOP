                                                                            
import java.lang.Math;
import java.util.Scanner;

class point{
    int x;
    int y;
}

class Line{
    point start;
    point end;
    int linewidth;
    int linecolor;
}

class Square{
    point tl,tr,bl,br;
    int length;
}

class rectangle{
    point tl,tr,bl,br;
    int length,breadth;
    public static int perimeter(int l,int b){
        return 2*(l+b);
    }
    public static int area(int l,int b){
        return l*b;
    }
}

class pascalTriangle {
    public static int nCr(int n,int r){
        r = (r<n-r)?r:n-r;
        int coef=1;
        for(int i=0;i<r;i++) {
        coef*=(n-i);
        coef/=(i+1);
        }
        return coef;
    }

    public static void printTriangle(int n){
        for(int i1=0;i1<n;i1++){
            System.out.print(" ");
            for(int j1=0;j1<=i1;j1++){
               System.out.print(nCr(i1,j1) + "  ");
            }
            System.out.println();
        }
    }

    public static int fiboRecurse(int n,int r){
        if(n>0 && r>0) return nCr(n,r) + fiboRecurse(n+1, r-1);
        else return nCr(n,r);
    }

    public static void printFibonacci(int n){
        //printing fibonacci numbers from pascal's triangle
        int temp=0;
        int count=1;
        int temp1=0,count1=0;
        for(int i=1;i<=n;i++) {
            System.out.print(fiboRecurse(temp1,temp) + "  ");
            count++;
            count1++;
            if(count1>=2){
                temp++;
                count1=0;
            }
            if(count>=2){
                temp1++;
                count=0;
            }
        }
    }

}

public class Assign0519032 {
    static void printRecurse(float[] arr,int index,int len){
        System.out.print(arr[index] + "   ");
        if(index<len-1) printRecurse(arr,index+1,len);
    }

    static void consecutiveRecurse(float[] arr,int index,float average,int len){
        if(arr[index] + arr[index+1] < average) System.out.println(arr[index] + "  " + arr[index+1]);
        if(index<len-2) consecutiveRecurse(arr, index+1, average, len);
    }

    static int isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }

    static void bubbleSort(int a[][],int N,int K){
        for (int i=0;i<N-1;i++){
            for (int j=0;j<N-i-1;j++){
                if (a[K][j]>a[K][j+1]){
                    int temp=a[K][j];
                    a[K][j]=a[K][j+1];
                    a[K][j+1]=temp;
                }
            }
        }
    }

    static void lineSegment(point p1,point p2){
        double distance = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
        System.out.println("first point - " + p1.x + ", " + p1.y);
        System.out.println("second point - " + p2.x + ", " + p2.y);
        System.out.println("Distance between them :" + distance);
    }

    static int formSR(point p1,point p2,point p3,point p4){
        double d1 = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
        double d2 = Math.sqrt((p2.x-p3.x)*(p2.x-p3.x) + (p2.y-p3.y)*(p2.y-p3.y));
        double d3 = Math.sqrt((p3.x-p4.x)*(p3.x-p4.x) + (p3.y-p4.y)*(p3.y-p4.y));
        double d4 = Math.sqrt((p1.x-p4.x)*(p1.x-p4.x) + (p1.y-p4.y)*(p1.y-p4.y));
        if(d1==d2 && d2==d3 && d1==d3) return 1;
        else if((d1==d2 && d3==d4) || (d1==d3 && d2==d4) && (d1==d4 && d2==d3)) return 1;
        return 0;
    }

    static void convertSR(point p1,point p2,point p3,point p4){
        p2.x = p1.x  + 5;
        p2.y = p1.y;
        p3.x = p1.x;
        p3.y = p1.y + 5;
        p4.x = p2.x;
        p4.y = p2.y + 5;
        System.out.println("Now we converted to a square, Points after converting to square are: ");
        System.out.println("first point - " + p1.x + ", " + p1.y);
        System.out.println("second point - " + p2.x + ", " + p2.y);
        System.out.println("third point - " + p3.x + ", " + p3.y);
        System.out.println("fourth point - " + p4.x + ", " + p4.y);

        int d1 = (int)Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));

        System.out.println("Perimeter of our modified square is :" + rectangle.perimeter(d1,d1));
        System.out.println("Area of our modified square is :" + rectangle.area(d1,d1));

    }

    public static void main(String[] args){      

        //PROBLEM - 1

        int n = (int)(Math.random()*11) + 40;
        float[] arr = new float[n];
        for(int i=0;i<n;i++) arr[i] = (float)Math.random();
        System.out.println("Elememts in the ranfomly generated array are: ");
        printRecurse(arr,0,n);
        System.out.println();
        float average=0.0f;
        for(int i=0;i<n;i++) average+=arr[i];
        average/=n;
        System.out.println("Consecutive 2 elements whose sum is less than average of the array: ");
        consecutiveRecurse(arr,0,average,n);

        //PROBLEM - 2
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter k (height of pascals triangle)");
        int k = scan.nextInt();
        System.out.println("Pascal's triangle: ");
        pascalTriangle.printTriangle(k);
        System.out.println("Fibonacci numbers from the pascal's triangle:");
        pascalTriangle.printFibonacci(k);
        System.out.println();

        //PROBLEM - 4
        int[][] pnp = {{17,7,21,41,45,131,14,101,198,139},{89,15,2,59,40,26,115,60,151,18}};
        int r1=0,r2=0;
        while(r1<10 && r2<10){
            if(isPrime(pnp[0][r1])==1 && isPrime(pnp[1][r2])==0) {
                int temp = pnp[0][r1];
                pnp[0][r1] = pnp[1][r2];
                pnp[1][r2] = temp;
            }
            else if(isPrime(pnp[0][r1])==0) r1++;
            else if(isPrime(pnp[1][r2])==1) r2++;
        }
        System.out.println("2D array after moving primes down and nonprimes up");
        for(int i=0;i<2;i++){
            for(int j=0;j<10;j++) {
                System.out.print(pnp[i][j] + "  ");
            }    
            System.out.println();
        }

        bubbleSort(pnp,10,0);
        bubbleSort(pnp,10,1);

        System.out.println("After sorting each rows independently: ");
        for(int i=0;i<2;i++){
            for(int j=0;j<10;j++) {
                System.out.print(pnp[i][j] + "  ");
            }    
            System.out.println();
        }

        //PROBLEM - 3
        point p1 = new point();
        point p2 = new point();
        p1.x = (int)(Math.random()*(50));
        p1.y = (int)(Math.random()*(50));
        p2.x = (int)(Math.random()*(50));
        p2.y = (int)(Math.random()*(50));
        lineSegment(p1, p2);
        System.out.println();
        
        point p3 = new point();
        point p4 = new point();
        p1.x = (int)(Math.random()*(50));
        p1.y = (int)(Math.random()*(50));
        p2.x = (int)(Math.random()*(50));
        p2.y = (int)(Math.random()*(50));
        p3.x = (int)(Math.random()*(50));
        p3.y = (int)(Math.random()*(50));
        p4.x = (int)(Math.random()*(50));
        p4.y = (int)(Math.random()*(50));
        if(formSR(p1, p2, p3, p4)==1) System.out.println("Randomly generated points form either a square or a rectangle");
        else 
        {
            System.out.println("Randomly generated points form neither a square nor a rectangle");
            convertSR(p1 , p2, p3, p4);
        }    

        System.out.println("Enter length of any arbitrary square: ");
        int sqle = scan.nextInt();
        System.out.println("Perimeter of square is :" + rectangle.perimeter(sqle,sqle));
        System.out.println("Area of square is :" + rectangle.area(sqle,sqle));

        scan.close();
    }
}
