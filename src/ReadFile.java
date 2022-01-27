import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Atanas\\Desktop\\input.txt";
        FileInputStream fis = new FileInputStream(path);

        int oneByte = fis.read();
        while (oneByte != -1) {
            String binary = Integer.toBinaryString(oneByte);
            System.out.print(binary + " ");
            oneByte = fis.read();
        }
    }
}
