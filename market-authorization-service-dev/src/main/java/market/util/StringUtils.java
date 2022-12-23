package market.util;

public class StringUtils {

    public static boolean isEmpty(CharSequence resource) {
        return resource == null || resource.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence resource) {
        return !isEmpty(resource);
    }
}
