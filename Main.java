import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String path = "E:\\IdeaProjects\\Games";

        List<String> CreatingDir = Arrays.asList(
                path + "\\src", path + "\\res", path + "\\savegames", path + "\\temp",
                path + "\\src\\main", path + "\\src\\test",
                path + "\\res/drawables", path + "\\res\\vectors", path + "\\res\\icons"
        );

        List<String> CreatingFile = Arrays.asList(
                path + "\\src\\main\\Main.java", path + "\\src\\main\\Utils.java",
                path + "\\temp\\temp.txt"
        );

        for (String dirPath : CreatingDir) {
            File dir = new File(dirPath);
            if (dir.mkdir()) {
                System.out.println(dir.getName() + " каталог создан успешно");
            } else {
                System.out.println(dir.getName() + " ошибка создания, каталог был создан ранее");
            }
            sb.append(dir.getName() + " каталог создан успешно" + "\n");
        }

        for (String filePath : CreatingFile) {
            File file = new File(filePath);
            try {
                if (file.createNewFile()) {
                    System.out.println(file.getName() + " файл создан успешно");
                } else {
                    System.out.println(file.getName() + " ошибка создания, файл был создан ранее");
                }
                sb.append(file.getName() + " файл создан успешно" + "\n");
            } catch (IOException ex) {
                ex.getMessage();
            }
        }

        try (FileWriter writer = new FileWriter(path + "\\temp\\temp.txt")) {
            writer.write(sb.toString());
            writer.flush();
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
