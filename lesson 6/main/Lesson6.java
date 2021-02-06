package main;

import util.WorkTextFile;

public class Lesson6 {
    public static void main(String[] args) {
        ;
        final String nameFilePart1 = "file_part1.txt";          // имя файла с первой частью текста
        final String nameFilePart2 = "file_part2.txt";          // имя файла со второй частью текста
        final String nameFile = "file.txt";                     // имя файла содержащего итоговый текст

        final String strPart1 =
                "Россия — священная наша держава,\r\n" +
                        "Россия — любимая наша страна.\r\n" +
                        "Могучая воля, великая слава —\r\n" +
                        "Твоё достоянье на все времена!\r\n" +
                        "\r\n";

        final String strPart2 =
                "Славься, Отечество наше свободное,\r\n" +
                        "Братских народов союз вековой,\r\n" +
                        "Предками данная мудрость народная!\r\n" +
                        "Славься, страна! Мы гордимся тобой!\r\n" +
                        "\r\n";
        // 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет)
        WorkTextFile.write(nameFilePart1, strPart1, false);
        WorkTextFile.write(nameFilePart2, strPart2, false);
        // 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        WorkTextFile.glue(nameFile, nameFilePart1, nameFilePart2);
        // 3.* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        System.out.println(WorkTextFile.checkWord(nameFilePart2, "Россия"));
        System.out.println(WorkTextFile.checkWord(nameFile, "Россия"));
        // 4.** Написать метод, проверяющий, есть ли указанное слово в папке
        System.out.println(WorkTextFile.checkWordInDir("C:\\java\\lesson6", "Россия"));
        System.out.println(WorkTextFile.checkWordInDir("C:\\java\\lesson6", "россия"));
    }
}
