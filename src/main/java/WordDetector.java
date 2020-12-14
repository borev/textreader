import java.text.BreakIterator;
import java.util.*;


public class WordDetector {

    /**
     *  Получает масив слов из текста,
     *  можно проводить каккие-то операции с каждым из слов
     */
    public static List<String> detect(String text, Locale locale, Postprocessor postprocessor) {
        BreakIterator wordIterator = BreakIterator.getWordInstance(locale);
        wordIterator.setText(text);
        int start = wordIterator.first();
        int end = wordIterator.next();
        List<String> words = new ArrayList<>();
        while (end != BreakIterator.DONE) {
            String word = text.substring(start, end);
            if (Character.isLetterOrDigit(word.charAt(0))) {
                if (postprocessor != null) {
                    word = postprocessor.process(word);
                }
                words.add(word);
            }
            start = end;
            end = wordIterator.next();
        }
        return words;
    }

    public static List<String> detect(String text, Locale locale) {
        return detect(text, locale, null);
    }

}
