import java.util.Locale;

/**
 * Можно воспользоваться внешними библиотеками детектора языка по тексту
 * Обычно это Singleton в котором поднимается некий список языков которые надо определять
 */
public class LocaleDetector {

    public static Locale detect(String text) {
       return new Locale("en");
    }
}
