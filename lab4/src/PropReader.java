import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class PropReader {
    private String fileName;

    public PropReader(String fileName) {
        this.fileName = fileName;
    }

    HashMap<String,String> HashMap()
    {
        FileInputStream input;
        byte[] buffer = new byte[1024];
        StringBuilder stringBuffer = new StringBuilder("");
        int n;

        try {
            input = new FileInputStream(this.fileName);
        } catch (FileNotFoundException e) {
            System.out.print("Не удается открыть");
            return new HashMap<>();
        }

        try {
            while ((n = input.read(buffer)) != -1) {
                stringBuffer.append(new String(buffer, 0, n));
            }
        } catch (IOException e) {
            try {
                input.close();
            } catch (IOException e2) {
                return new HashMap<>();
            }
        }
        return parseProperties(stringBuffer.toString());
    }

    private HashMap<String,String> parseProperties(String input)
    {
        HashMap<String, String> result = new HashMap<>();
        for (String line : input.split("\n")) {
            String[] key_value = line.split("=");
            if (key_value.length != 2) {
                continue;
            }
            result.put(key_value[0].trim(), key_value[1].trim());
        }
        return result;
    }
}