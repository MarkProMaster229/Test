import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


public class Main {
    public static void main(String[] args) {

        Magazin ma = new Magazin("apple", 10);
        ma.setName("f12");
        Calk c = new Calk(3, "ff", 3);
        c.res();



        Animal test = new Animal("cool head", 0, "long tail");

        Cat cat = new Cat(true, "Cool Head", 4, "long tail", "Meow");
        System.out.println(cat.sound());


    }
}