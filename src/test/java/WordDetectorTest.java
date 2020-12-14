import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordDetectorTest {

    @Test
    public void testEnText() {
        String someText = "The ballots will be transmitted to Washington, DC, to be tallied in Congress on January 6, when a building -- but almost certainly futile -- rearguard by Republican lawmakers may expose a large rump of the party that has also turned against the democratic principles that underpin free and fair elections.";
        // Можно воспользоваться внешними библиотеками детектора языка по тексту
        Locale en = LocaleDetector.detect(someText);

        List<String> list = WordDetector.detect(someText,
                en, (word) -> {
                    return word; // можно проводить какие-то постоперации со словом
        });

        // после выборки слов можно исключать предлоги,
        // цифры(или переводить их в слова), но это надо уже видимо какие-то словари иметь
        // для конкретных языков по которым  будет идти поиск
        System.out.println(list);
        assertEquals(49, list.size()); // тут просто протестировал количество ожидаемых слов

    }

    @Test
    public void testArabicText() {
        String someText = "سان حق التمتع بكافة الحقوق والحريات الواردة في هذا الإعلان، دون أي تمييز، كالتمييز بسبب العنصر أو اللون أو الجنس أو اللغة أو الدين أو الرأي السياسي أو أي رأي آخر، أو الأصل الوطني أو الإجتماعي أو الثروة أو الميلاد أو أي وضع آخر، دون أية تفرقة بين الرجال والنساء. وفضلاً عما تقدم فلن يكون هناك أي تمييز أساسه الوضع السياسي أو القانوني أو الدولي لبلد أو البقعة التي ينتمي إليها الفرد سواء كان هذا البلد أو";
        List<String> list = WordDetector.detect(someText, new Locale("en"));
        System.out.println(list);
        assertEquals(230, list.size());

    }


}
