package lesson6.HW6;

import java.io.*;

public class Main {
    public static void createFile(String name, String content) {
        try {
            FileOutputStream FileText1 = new FileOutputStream(name);
            PrintStream ps1 = new PrintStream(FileText1);
            ps1.println(content);
            FileText1.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String name, StringBuilder nameBuilder) {
        try {
            FileInputStream InputFileText1 = new FileInputStream(name);

            int letterInFirstText;
            while ((letterInFirstText = InputFileText1.read()) != -1) {
                nameBuilder.append((char) letterInFirstText);
                System.out.print((char) letterInFirstText);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mergeMethod(String name, StringBuilder nameBuilder) {
        try {
            FileOutputStream FileText3 = new FileOutputStream(name);
            PrintStream ps3 = new PrintStream((FileText3));
            ps3.append(nameBuilder.toString());
        } catch (IOException e) {
            System.out.println("Error write File!");
        }
    }

    public static boolean chekWord(String word, String name) {
        try {
            FileInputStream InputFileText1 = new FileInputStream(name);
            StringBuilder chek = new StringBuilder();
            int letterInFirstText;
            while ((letterInFirstText = InputFileText1.read()) != -1) {
                chek.append((char) letterInFirstText);
            }
            if (chek.toString().contains(word)) {
                return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public static void main(String[] args) {
        createFile("File_Text_1.txt", "Hello world, my name is Dmitry Luts.If I study well, maybe I'll become a programmer");
        createFile("File_Text_2.txt", "But if I don't study well,I won't be able to become a programmer.");
        StringBuilder name = new StringBuilder();
        readFile("File_Text_1.txt", name);
        readFile("File_Text_2.txt", name);
        mergeMethod("File_Text_3.txt", name);
        if ( chekWord("study","File_Text_1.txt") && chekWord("study","File_Text_2.txt")){
            System.out.println("Файлы содержат слово \" study\"");
        }else
        {
            System.out.println("Слово не найдено");
        }

    }
}

// 1) Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);(ГОТОВО)
// 2) Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.(ГОТОВО)
// 3) Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.(ГОТОВО)
// 4) Написать метод, проверяющий, есть ли указанное слово в папке, внутри есть файлы
//    в которых может содержатся это слово (данная тема преднамеренно не рассказывалась,
//    поэтому надо погуглить (Гуглить - тоже надо уметь правильно). При чем не просто найти решение и списать,
//    а именно сформулировать проблему. Пока вы будете формулировать проблему - вы найдете 50% решения)
