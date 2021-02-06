package util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WorkTextFile {                                                         // Класс для работы с текстовыми файлами
    final static String fileExt = ".txt";                                            // расширение для тектовых файлов

    public static String read(String fileName) {                                    // прочитать содержимое файла fileName
        try {
            StringBuilder sb        = new StringBuilder();
            FileInputStream fis     = new FileInputStream(fileName);
            InputStreamReader isr   = new InputStreamReader(fis, StandardCharsets.UTF_8);     // "обертка" для чтения кириллических символов из файла
            int i;

            while ((i = isr.read()) != -1) sb.append((char) i);

            isr.close();
            fis.close();

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void write(String fileName, String text, boolean append) {        // записать текст в файл fileName
        try {
            FileOutputStream fos = new FileOutputStream(fileName, append);

            fos.write(text.getBytes());

            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void print(String fileName, String text, boolean append) {        // записать текст в файл fileName через "обертку" PrintStream
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintStream ps = new PrintStream(fos);

            ps.println(text);

            ps.flush();
            ps.close();

            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void append(String fileName, String fileNameAppend) {             // добавить к файлу fileName содержимое файла fileNameAppend
        String text = read(fileNameAppend);
        write(fileName, text, true);
    }
    public static void glue(String fileName, String fileName1, String fileName2) { // склеить содержимое файлов fileName1 и fileName2 в файле fileName
        String text1 = read(fileName1);
        String text2 = read(fileName2);

        write(fileName, text1, false);
        write(fileName, text2, true);
    }
    public static boolean checkWord(String fileName, String word) {                // проверить содержится ли слово в файле fileName
        String text = read(fileName);
        return text.contains(word);
    }
    public static boolean checkWordInDir(String dirPath, String word) {             // проверить содержится ли слово в каталоге dirPath
        File file = new File(dirPath);

        for (File f : file.listFiles())
            if (f.isFile())
                if (f.getName().endsWith(fileExt))
                    if (checkWord(f.getName(), word))
                        return true;

        return false;
    }
}
