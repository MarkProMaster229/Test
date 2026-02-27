import java.util.*;

class Animal {
    String head;
    int paw;
    String tail;

    public Animal(String head, int paw, String tail) {
        this.head = head;
        this.paw = paw;
        this.tail = tail;
    }

    public String sound() {
        return "MySound";
    }

}

//любой cat это animal
class Cat extends Animal {
    private String meow;
    boolean fluffy;

    public Cat(boolean flaffy, String head, int paw, String tail,
               String meow) {
        super(head, paw, tail);
        this.meow = meow;
        this.fluffy = flaffy;
    }

    //прост пример можно и больше добавить в целом
    //главная мысль которую я хочу донести - get и set методы это про управление в процессе работы
    //а конструктор это однократная инициализация при появлении обьекта
    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    //полиморфизм
    @Override
    public String sound() {
        return "meow";
    }
}


//магазин должен быть класс, за продукты отвечает характеристики нам, конструктор надо, иметь два реализованых конструк.
//будет для расчета другой класс и в этом классе показать один хотя бы приватный метод который помогает в расчете поможет основ калькулейт
//мейн класс - статический мы придумаем - такой метод статический в класс мейн которому что то кидаешь а тебе возвращает обьект товара
//для нега вожно стат метод который создает сам обьект, и с каждым костурк.

class Magazin {
    private String name;
    private int price;

    Scanner scanner = new Scanner(System.in);

    public Magazin(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String Getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int GetPrise() {
        return price;
    }

    public void SetPrise(int price) {
        this.price = price;
    }
}

class Calk extends Magazin {
    Scanner scanner = new Scanner(System.in);

    int save;

    public Calk(int save, String name, int prise) {
        super(name, prise);
        this.save = save;
    }

    public void res() {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int price = scanner.nextInt();


        Magazin ma = new Magazin(name, price);

        System.out.println(name);
        System.out.println(price);
        int pr1 = price;
        String na1 = name;
        System.out.println(pr1);


    }
}
// enum class
// ну типа он хочет tack менеджер-коекакер там надо использовать enum class, второстепенные задачи есть и основные типо того если все второстепенные задачи есть то передает основной задаче
// готово, использовать
class Shop {

    int prise;


    public Shop(int prise) {

        this.prise = prise;
    }

    public void calk() {
        System.out.println("сколько товаров");
        Scanner scanner = new Scanner(System.in);

        int calk = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        System.out.println("страт");
        for (int i = 0; i < calk; i++) {
            list.add(scanner.nextInt());
        }

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        System.out.println("цена");
        System.out.println(sum);


    }

}

class Task{
    enum progres{empty, medium, done}
    private String task;
    private int id;
    public Task(String task, int id)
    {
        this.task = task;
        this.id = id;//this problem moment
    }

    public int GetId()
    {
        return id;
    }

    public void SetTask()
    {
        this.task = task;
    }

    public void mainTask()
    {
        System.out.println("введите свои задачки");
        Scanner scanner = new Scanner(System.in);
        String nameTask = scanner.nextLine();

    }
}
class Helper extends Task{

    public Helper(String task, int id)
    {
        super(task, id);
    }

    public void underTask()
    {
        //give me value
        System.out.println("дайть мне кол-во подзадач");
        Scanner scanner = new Scanner(System.in);
        int value  = scanner.nextInt();

        String[] subtasks = new String[value];
        for(int i = 0; i < value; i++)
        {
            System.out.println("введи последовательно подзадачи");
            subtasks[i] = scanner.nextLine();
        }


    }

}
//есть главная задача затем подзадачи выносятся ниже затем табуляция
//то есть под центральной задачей аккуратно выстраиваются подзадачи
//и так последовательно
//так же нужно сделать проверку на уникальность компаратор и хеш код нужен
// Equals????
class Task2
{
    //this terrible, I know)
    //i dont must using public this -
    public String task;
    public int id;
    public Task2(String task, int id)
    {
        this.task = task;
        this.id = id;
    }

}

class SubTask extends Task2{

    public List<String> mySubtask = new ArrayList<>(10);

    //this lazy list
    public List<String> value = new ArrayList<String>(10);

    public SubTask(List<String> mySubtask, String task, int id, List<String> value){
        super(task, id);
        this.mySubtask = mySubtask;
        this.value = value;

    }
    public void Getter()
    {
        //user must get me task and subtack
        id++;
        Scanner scanner = new Scanner(System.in);
        String InputUser = scanner.nextLine();
        mySubtask.add(InputUser);

    }
}

class GoodReturn extends SubTask
{
    public int For_what_me_this;

    public GoodReturn(int For_what_me_this, List<String> mySubtask, String task, int id, List<String> value){
        super(mySubtask, task, id, value);
        this.For_what_me_this = For_what_me_this;
    }


}

class MyComparator implements Comparator<SubTask> {

    @Override //я хз зачем переопределять его наврено чтоб
    //конфликта не было хз не знаю вообщем))

    public int compare(SubTask o1, SubTask o2) {
        //а если у меня один лист че мне делать ? А если у меня три обьекта и более че делать
        //хорошо, но мы имеем только один лист, но судя по задачи я должен использовать именно судью - компаратор?
        //не комперебл который сравнивает себя с кем то, но постойте в любом случае я должен иметь два обьекта, хорошо создам фиктивный лист для того чтобы просто
        //разобраться в сути работы компаратора, но для самого задания это не будет иметь смысла.
        //был создан public List<String> value = new ArrayList<String>(10);
        if (o1.id < o2.id) {
            return -1;
        } else if (o1.id > o2.id) {
            return 1;
        }
        return 0;
    }
}
abstract class Animal1 {
    public String make() {
        return "Звук";
    }
}

class Cat1 extends Animal1 {
    @Override
    public String make()
    {
        return "Мяу";
    }
}

// надо принцип солид применять и соответ добавить клиент и клиент должен запоминать свою задачу
// использовать хеш меп ключем будет - задача цена будет как значение ютилс
// класс превращат в абстракт класс  и добавить новый интерфейс

// хорошо мне надо иметь три класса абсстрактный класс - задачи
// у него будут поля ключ значение
// потом будет абстрактный класс персон person в этом классе пусть будет главный и посредник
// цена... цена.... цена... пусть будет в абстрактом классе задач
// и того подытожим созать функцию цены, создать функцию персоны, создать функцию таск
// для дальнешего переопределения
// держать принципы солид(наверно)
// все принципы солид были успешно мной нарушены
// YAGNI

//хорошо были так же созданы два класса которые наследуют абстрактный класс

// следующие задание

// у нас есть интрефейс где думаете один метод где интерфес финансибл кто то создал второй интерфейс мы переходим в функциональный интерфейс
// где одна функция находится комперебл сейчас вы свой финансбл интрфейс превращаете в функциональный интерфейс можете гуглить
// над назавнием интерфейс добавляете собака дальше где этот метод из интерфейс финансб вы вызваете там стурктура надо менять
// можно гуглить создание функцинального интерфейса далее перйдем в стрим апи и лябда выражения

//хорошо моя задача я не помню.



// ладно


// методы в ютил класс методы - апдейт статус

// хорошо у нас есть один главный центральный интерфейс - ютилс класс от него будет реализованы абстрактыне обьекты а от них дочерние
// дочерные - функциональные интерфейсы нужно иметь енам класс для статусов от него будет наследован потом как я понимаю
// в дочерний обьект будет имплементировать задачи от абстарктного класса

// хорошо задача следующая - иметь центральный класс он же ютилс джава класс
// от него будут наследованы абстрактные классы а вот уже от абстрактных классов будут наследованы дочерние обьекты которые в свою очередь и будут имплементирвоать
// обстарктных классов

//хорошо создам енум обьект пусть он будет отвечать за статус, далее

enum MyStatus {
    START, PROCES, FINISH
}






// енам класс для статусов
// хорошо мне надо реализовать
abstract class TaskAbs {
    private Map<String, Integer> tasks;
    int prise;
    public List<String> value = new ArrayList<String>(10);


    public TaskAbs(Map<String, Integer> tasks , int prise, List<String> value ) {
        this.tasks = tasks;
        this.prise = prise;
        this.value = value;
    }
    public void myTask (){
        System.out.println("stub");
    }
    public void mony(){
        System.out.println("stub");
    }
}

abstract class Person{
    private String persona;

    public Person(String persona)
    {
        this.persona = persona;
    }
    public void persona(String Persona)
    {
        this.persona = persona;
    }
}

class TaskOrigin extends TaskAbs{

    public TaskOrigin(Map<String, Integer> tasks , int prise, List<String> value)
    {
        super(tasks, prise, value);
    }
    @Override
    public void myTask()
    {
        Scanner scanner = new Scanner(System.in);
        String InputUser = scanner.nextLine();
        for(int i = 0; i < 10; i++ ){
            value.add(scanner.nextLine());
        }
    }
    @Override
    public void mony()
    {
        Scanner scanner = new Scanner(System.in);
        this.prise = scanner.nextInt();
    }
}

class PersonOrigin extends Person{
    public PersonOrigin(String persona)
    {
        super(persona);
    }
    public void iKnow()
    {

    }
}



    public class Main {
        public static void main(String[] args) {
            //TODO I must finishing class GoodReturn And working witch Comparator
            //TODO realization good struct witch get and set method
            Magazin ma = new Magazin("apple", 10);
            ma.setName("f12");
            Calk c = new Calk(3, "ff", 3);
            c.res();

            MyComparator co = new MyComparator();

            //типо сейчас я вызываю два одих и тех же обьекта SubTask
            List<String> value = new ArrayList<String>(10);
            SubTask s = new SubTask(value,"ggg",51,value);
            SubTask s2 = new SubTask(value,"ggg",52,value);



            if(co.compare(s,s2) == -1)
            {
                System.out.println("ttt");
            }
            else{
                System.out.println("t2");
            }


            Animal test = new Animal("cool head", 0, "long tail");

            Cat cat = new Cat(true, "Cool Head", 4, "long tail", "Meow");
            System.out.println(cat.sound());
        }
    }
