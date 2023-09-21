// Задание
// 1) Напишите класс-конструктор у которого принимает минимум 3 строки,
// содержащие три поля id игрушки, текстовое название и частоту выпадения
// игрушки
// 2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три
// массива.
// 3) Используя API коллекцию: java.util.PriorityQueue добавить элементы в
// коллекцию
// 4) Организовать общую очередь 
// 5) Вызвать Get 10 раз и записать результат в
// файл
// Подсказка:
// В метод put передаете последовательно несколько строк
// 1 2 конструктор;
// 2 2 робот;
// 3 6 кукла.
// Метод Get должен случайно вернуть либо “2”, либо “3” и соответствии с весом.
// В 20% случаях выходит единица
// В 20% двойка
// И в 60% тройка.
// Критерии оценки
// Приложение должно запускаться, записывать значения в файл.


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

class Toy {
    private int id;
    private String name;
    private int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
}

public class ToyQueueApp {
    public static void main(String[] args) {
        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        // Примеры строк для создания игрушек
        String[] toyStrings = {
            "1 2 конструктор",
            "2 2 робот",
            "3 6 кукла"
        };

        // Создаем игрушки из строк и добавляем их в очередь
        for (String toyString : toyStrings) {
            String[] parts = toyString.split(" ");
            int id = Integer.parseInt(parts[0]);
            int frequency = Integer.parseInt(parts[1]);
            String name = parts[2];
            Toy toy = new Toy(id, name, frequency);
            toyQueue.add(toy);
        }