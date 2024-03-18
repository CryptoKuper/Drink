import java.util.ArrayList;
import java.util.List;

// Интерфейс для горячих напитков
interface HotDrink {
    String getName(); // Метод для получения имени напитка
    int getVolume(); // Метод для получения объема напитка
    int getTemperature(); // Метод для получения температуры напитка
}

// Класс горячего напитка
class HotBeverage implements HotDrink {
    private String name; // Имя напитка
    private int volume; // Объем напитка
    private int temperature; // Температура напитка

    // Конструктор класса
    public HotBeverage(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    // Реализация метода получения имени
    @Override
    public String getName() {
        return name;
    }

    // Реализация метода получения объема
    @Override
    public int getVolume() {
        return volume;
    }

    // Реализация метода получения температуры
    @Override
    public int getTemperature() {
        return temperature;
    }
}

// Класс автомата горячих напитков
class HotBeverageMachine implements VendingMachine {
    private List<HotDrink> drinks; // Список доступных напитков в автомате

    // Конструктор класса
    public HotBeverageMachine(List<HotDrink> drinks) {
        this.drinks = drinks;
    }

    // Метод получения напитка по имени и объему
    @Override
    public HotDrink getProduct(int name, int volume) {
        // Перебираем все доступные напитки
        for (HotDrink drink : drinks) {
            // Если имя и объем совпадают, возвращаем этот напиток
            if (drink.getName().hashCode() == name && drink.getVolume() == volume) {
                return drink;
            }
        }
        return null; // Если не найден подходящий напиток, возвращаем null
    }

    // Перегруженный метод для получения напитка по имени, объему и температуре
    public HotDrink getProduct(int name, int volume, int temperature) {
        // Перебираем все доступные напитки
        for (HotDrink drink : drinks) {
            // Если имя, объем и температура совпадают, возвращаем этот напиток
            if (drink.getName().hashCode() == name && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null; // Если не найден подходящий напиток, возвращаем null
    }
}

// Интерфейс торгового автомата
interface VendingMachine {
    HotDrink getProduct(int name, int volume); // Метод для получения напитка по имени и объему
}

// Основной класс приложения
public class Drink {
    // Точка входа в программу
    public static void main(String[] args) {
        // Создаем несколько горячих напитков
        HotDrink tea = new HotBeverage("Tea", 200, 80);
        HotDrink coffee = new HotBeverage("Coffee", 250, 85);
        HotDrink cocoa = new HotBeverage("Cocoa", 300, 90);

        // Создаем автомат горячих напитков и добавляем напитки
        List<HotDrink> drinks = new ArrayList<>();
        drinks.add(tea);
        drinks.add(coffee);
        drinks.add(cocoa);

        HotBeverageMachine machine = new HotBeverageMachine(drinks);

        // Получаем напитки из автомата
        HotDrink hotTea = machine.getProduct("Tea".hashCode(), 200);
        HotDrink hotCoffee = machine.getProduct("Coffee".hashCode(), 250);
        HotDrink hotCocoa = machine.getProduct("Cocoa".hashCode(), 300);

        // Выводим информацию о напитках
        System.out.println("Hot Tea: " + hotTea.getName() + ", Volume: " + hotTea.getVolume() + "ml, Temperature: " + hotTea.getTemperature() + "C");
        System.out.println("Hot Coffee: " + hotCoffee.getName() + ", Volume: " + hotCoffee.getVolume() + "ml, Temperature: " + hotCoffee.getTemperature() + "C");
        System.out.println("Hot Cocoa: " + hotCocoa.getName() + ", Volume: " + hotCocoa.getVolume() + "ml, Temperature: " + hotCocoa.getTemperature() + "C");
    }
}
