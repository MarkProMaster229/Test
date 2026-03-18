import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.IntStream;
//enum
enum MStatus {
    START,
    PROSEC,
    FIHISH
}

@FunctionalInterface
interface MathTest {
    int execute(int a, int b);

}

@FunctionalInterface
interface MyComand {
    int retur(int alex, int bob, int eve);


}
final class MychekRun{
    public static int CalculRun(int alex, int bob,int eve, MyComand command){
        int result = command.retur(alex,bob,eve);
        System.out.println(result);
        return result;
    }

}

//this utils class
final class MyTools{
    public static final String Helped = "";
    public static int  SumChek(String e, int prise, int priseTwo){
        int sum = prise + priseTwo;
        System.out.printf("уважаемый %s ваша сумма составит,%d", e, sum);
        return 1;
    }
    public static int calculateAndPrint(String e, int p1, int p2, MathTest op) {
        int result = op.execute(p1, p2);
        System.out.printf("Уважаемый %s, результат операции: %d%n", e, result);
        return result;
    }
}


//абстрактный класс
abstract class UpLoadTask{
    String Name;
    String Task;
    public UpLoadTask(String name, String Task)
    {
        this.Name = name;
        this.Task = Task;
    }
    public void SetTusk(){
        this.Task = Task;
    }
    public String getTusk(){
        return Task;
    }
}
//наследование
class TaskInc extends UpLoadTask{
    MStatus status  = MStatus.START;

    public TaskInc(String Name,String Task)
    {
        super(Name,Task);
    }
    @Override
    public void SetTusk()
    {
        Scanner scanner = new Scanner(System.in);
        String Task = scanner.nextLine();
    }
    @Override
    public String getTusk(){
        return Task;
    }

    public void set()
    {
        //лист
        ArrayList<MyTools> tools = new ArrayList<>();
        int[] number = {10, 30, 70};
        int[] number2 = {30, 400, 7};
        String[] MassTas = {"firstWork1","firstWork2", "firstWork3"};


        switch (this.status) {
            case START:
                this.status = MStatus.PROSEC;
                System.out.println("this logic for start?");
                break;

            case PROSEC:
                this.status = MStatus.FIHISH;
                for (int i = 0; i < 2; i++)
                {
                    MyTools.SumChek(MassTas[i],number[i],number2[i]);
                }
                break;

            case FIHISH:
                System.out.println("finaly");
                break;
        }
    }
    public void usingEnum()
    {
        int[] number;
        int[] number2;
        String[] MassTas;

        switch (this.status){ // через стейт машину реализовал
            case START:
                this.status = MStatus.PROSEC;
                System.out.println("this your works in Start!");
                number = new int[]{10, 30, 70};
                number2 = new int[]{30, 400, 7};
                MassTas = new String[]{"firstWork1","firstWork2", "firstWork3"};
                //лямбда выражение и функциональный интерфейс
                for (int i = 0; i < 2; i++) {
                    MyTools.calculateAndPrint(MassTas[i], number[i], number2[i], (a, b) -> a + b);
                }
                break;

            case PROSEC:
                this.status = MStatus.FIHISH;
                System.out.println("this your works in prosec!");
                number = new int[]{1000000, 3000, 7000000};
                number2 = new int[]{3000, 400000, 700000};
                MassTas = new String[]{"firstWork1","firstWork2", "firstWork3"};
                for (int i = 0; i < 2; i++)
                {
                    MyTools.SumChek(MassTas[i],number[i],number2[i]);
                }
                break;

            case FIHISH:
                System.out.println("this your works in finish!");
                final int[] fNumber = {0, 0, 0};
                final int[] fNumber2 = {0, 0, 0};
                final String[] fMassTas = {"firstWork1","firstWork2", "firstWork3"};

                //streamApi
                IntStream.range(0, 2)
                        .forEach(i -> MyTools.SumChek(fMassTas[i], fNumber[i], fNumber2[i]));
                break;
        }
    }
}


public class Main {

    // добавлены - наследование, ArrayList, утилитарный класс, enum, streaAPI, функциональный интерфейс, лямбда выражение
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        TaskInc Test = new TaskInc("randomName","randomTask");
        Test.usingEnum();
        Test.status = MStatus.PROSEC;
        Test.usingEnum();

        Test.status = MStatus.START;
        Test.usingEnum();
        int alex = 2;
        int bob = 10;
        int eve = 1;



        int abc = MychekRun.CalculRun(alex,bob,eve, (a,b,c)->a+b+c);

        String[] players = {"Alex","Bob","Eve"};
        int[] round1 = {10,7,12};
        int[] round2 = {15,20,12};

        IntStream.range(0, players.length)
                .map(i -> round1[i] + round2[i])
                .forEach(sum -> System.out.println(sum));
    }
}
