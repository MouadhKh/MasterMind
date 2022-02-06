public interface ICodeMaker {

    /**
     * Evaluate code by returning feedback for each input
     */
    String evaluate(String code);

    /**
     *
     * @return true if the guess is correct
     */
    boolean isGuessCorrect(String code);
}
