import java.util.Scanner;

public class arithematic {
    
    static int add(final int a, final int b) {
        return a + b;
    }

    static int sub(final int a, final int b) {
        return a - b;
    }

    static int mul(final int a, final int b) {
        return a * b;
    }

    static int div(final int a, final int b) {
        return a / b;
    }

    public static void main(final String[] args) {
        final Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("enter yes to continue or no to exit");
            final String flag = s.nextLine();
            if (flag.equals("yes")) {
                System.out.println("Give the two numbers");
                int x, y;
                x = s.nextInt();
                y = s.nextInt();
                String buffer=s.nextLine();
                System.out.println("ADDITION->add\nSUBTRACTION->sub\nMULTIPLICATION->mul\nDIVISION->div\n");
                final String choice = s.nextLine().trim();
            switch(choice)
            {
                case "add":
                System.out.println("Answer:"+add(x,y)+"\n");
                break;
                case "sub":
                System.out.println("Answer:"+sub(x,y)+"\n");
                break;
                case "mul":
                System.out.println("Answer:"+mul(x,y)+"\n");
                break;
                case "div":
                System.out.println("Answer:"+div(x,y)+"\n");
                break;
            }
        }
        else break;
        }
        s.close();
        
    }
}