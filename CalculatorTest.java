class Calculator{
    int input1;
    int input2;

       public int sum(){
        return input1 + input2;
    }
    public int product(){
        return input1 * input2;
    }
}

public class CalculatorTest {

    public static void main(String args[]){
        Calculator c = new Calculator();
            
        c.input1 = 10;
        c.input2 = 20;

        System.out.println(c.sum());
    }
    
}