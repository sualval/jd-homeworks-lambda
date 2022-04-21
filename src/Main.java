import worker.OnTaskDoneListener;
import worker.OnTaskErrorListener;
import worker.Worker;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
/*Т.к. при вычислении alc.minus.apply(1, 1) получаем 0,выходит ArithmeticException ,
 нужно обработать ощибку c помощью try catch или сделать проверку в calc.divide */
        try {
            int c = calc.divide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }


        ////----------  TASK2 ----------/////
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = er -> er.equals("33");
        Worker worker = new Worker(listener, errorListener);
        worker.start();


    }
}
