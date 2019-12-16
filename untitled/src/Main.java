import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("ProgrammingHistory.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        System.out.println(searchWord("programming", lines));
    }

    public static ArrayList<Integer> searchWord(String word, ArrayList<String> lines) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int index = 0; index < lines.size(); index++) {
            String line = lines.get(index);
            for (int i = 0; i < line.length(); i++) {
                int lineIndex = i, wordIndex = 0;
                while (wordIndex < word.length() &&
                        line.charAt(lineIndex) == word.charAt(wordIndex)) {
                    lineIndex++;
                    wordIndex++;
                }
                if (wordIndex >= word.length() - 1) {
                    result.add(index);
                }
            }
        }
        return result;
    }
}
