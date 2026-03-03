import java.util.Scanner;
import java.util.ArrayList;

enum MStatus {
    START,
    PROSEC,
    FIHISH
}
//this utils class
final class MyTools{
    public static final String Helped = "";
    public static int  SumChek(String e, int prise, int priseTwo){
        int sum = prise + priseTwo;
        System.out.printf("уважаемый %s ваша сумма составит,%d", e, sum);
        return 1;
    }
}

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
        ArrayList<MyTools> tools = new ArrayList<>();
        int[] number = {10, 30, 70};
        int[] number2 = {30, 400, 7};
        String[] MassTas = {"firstWork1","firstWork2", "firstWork3"};

// очень удобно использовать свичи для этого
        switch (this.status) {
            case START:
                this.status = MStatus.PROSEC;
                //то есть при первом вызове в мейне я получу этот блок это первичное сосотояние
                // например в этом состоянии я запрошу от юзера задачи и значения
                System.out.println("this logic for start?");
                break;

            case PROSEC:
                this.status = MStatus.FIHISH;
                //в этом блоке выдам юзеру то что он желает
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
        switch (this.status){
            case START:
                this.status = MStatus.PROSEC;//вообще это стейт-машина
                System.out.println("this your works in Start!");
                //да я понимаю что переменные повторяются и это плохая практика, но ведь по большей части это всего лишь заглушки!
                ArrayList<MyTools> tools = new ArrayList<>();
                int[] number = {10, 30, 70};
                int[] number2 = {30, 400, 7};
                String[] MassTas = {"firstWork1","firstWork2", "firstWork3"};

                for (int i = 0; i < 2; i++)
                {
                    MyTools.SumChek(MassTas[i],number[i],number2[i]);
                }


                break;

            case PROSEC:
                this.status = MStatus.FIHISH;
                System.out.println("this your works in prosec!");
                ArrayList<MyTools> tools2 = new ArrayList<>();
                int[] number02 = {1000000, 3000, 7000000};
                int[] number022 = {3000, 400000, 700000};
                String[] MassTas02 = {"firstWork1","firstWork2", "firstWork3"};
                for (int i = 0; i < 2; i++)
                {
                    MyTools.SumChek(MassTas02[i],number02[i],number022[i]);
                }
                break;

            case FIHISH:
                System.out.println("this your works in finish!");
                ArrayList<MyTools> tools23 = new ArrayList<>();
                int[] number023 = {0, 0, 0};
                int[] number0223 = {0, 0, 0};
                String[] MassTas023 = {"firstWork1","firstWork2", "firstWork3"};
                for (int i = 0; i < 2; i++)
                {
                    MyTools.SumChek(MassTas023[i],number023[i],number0223[i]);
                }
                break;
        }

    }

}


public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        //TaskInc ta = new TaskInc("t","Y");
        //ta.set();//да! работает!
        //ta.set();//да! работает!  состояние иное!
        //ta.set();
        TaskInc Test = new TaskInc("randomName","randomTask");
        Test.usingEnum();
        Test.status = MStatus.PROSEC;
        Test.usingEnum();

        Test.status = MStatus.START;
        Test.usingEnum();

    }
}
