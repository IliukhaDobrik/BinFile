package MainPackege;

import java.io.*;

class Din {
    public static void main(String[] args) throws IOException
    {
        // Исходные данные - некоторый массив целых чисел
        double[] arrInt = { 2.5, 5.67, -164.633, 100, 33 };

        // 1. Записать массив arrInt в байтовый файл "integers.bin"
        // 1.1. Создать файловый байтовый поток, связанный с именем "integers.bin"
        FileOutputStream fs = new FileOutputStream("integers.bin");

        // 1.2. Создать байтовый поток, содержащий методы чтения данных примитивных типов
        DataOutputStream ds = new DataOutputStream(fs);

        // 1.3. Записать количество элементов в массиве - используется метод write()
        ds.writeInt(arrInt.length);

        // 1.4. Записать массив целых чисел
        for (int i=0; i<arrInt.length; i++)
            ds.writeDouble(arrInt[i]);

        // 1.5. Закрыть файл "integers.bin"
        fs.close();

        // -----------------------------------------------------------------
        // 2. Считать массив целых чисел из байтового файла "integers.bin"
        double[] arrInt2; // массив, в который будут считаны данные из файла "integers.bin"

        // 2.1. Создать файловый поток, связанный с именем "integers.bin"
        FileInputStream fs2 = new FileInputStream("integers.bin");

        // 2.2. Создать поток данных, связанный с файловым потоком fs2
        DataInputStream ds2 = new DataInputStream(fs2);

        // 2.3. Считать количество целочисленных элементов, которые записаны в файле
        int count = ds2.readInt();

        // 2.4. Выделить память для массива arrInt2
        arrInt2 = new double[count];

        // 2.5. Цикл чтения данных из ds2 и копирование их в массив arrInt2
        for (int i=0; i<arrInt2.length; i++)
            arrInt2[i] = ds2.readDouble();

        // 2.6. Закрыть поток ds2
        ds2.close();

        // --------------------------------------------------------------
        // 3. Вывести массив arrInt2 для контроля
        System.out.println("Array arrInt2: ");
        for (int i=0; i<arrInt2.length; i++)
            System.out.println(arrInt2[i]);
    }
}