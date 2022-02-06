import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ColorCombination {
    private String colorCombination;


    public ColorCombination() {
        this.generate();
    }

    public ColorCombination(String colorCombination) {
        this.colorCombination = colorCombination;
    }

    public static boolean isValid(String codeCombination) {
        return codeCombination.matches("[1-6]{4}");
    }

    public void generate() {
        List<Integer> colorNumbers = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        StringBuilder generatedCombination = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomPos = (int) (Math.random() * (colorNumbers.size() - 1)) + 1;
            generatedCombination.append(colorNumbers.remove(randomPos));
        }
        this.colorCombination = generatedCombination.toString();

    }

    public String getColorCombination() {
        return this.colorCombination;
    }
}
