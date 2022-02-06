import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CodeMaker implements ICodeMaker {
    private final ColorCombination colorCombination;

    public CodeMaker() {
        this.colorCombination = new ColorCombination();
    }

    @Override
    public String evaluate(String code) {
        AtomicReference<String> feedback = new AtomicReference<>("");
        String combinationCode = colorCombination.getColorCombination();
        IntStream.range(0, 4).forEach(i -> {
            if (code.charAt(i) == combinationCode.charAt(i)) {
                feedback.updateAndGet(v -> v + 'b');
            } else if (code.indexOf(combinationCode.charAt(i)) != -1) {
                feedback.updateAndGet(v -> v + 'w');
            } else
                feedback.updateAndGet(v -> v + '.');
        });
        return feedback.get();
    }

    public boolean isGuessCorrect(String code) {
        return evaluate(code).equals("bbbb");
    }

    public ColorCombination getColorCombination() {
        return colorCombination;
    }
}

