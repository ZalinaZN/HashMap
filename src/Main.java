import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    protected static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";

    public static void main(String[] args) {

        char[] simbols = TEXT.toLowerCase().toCharArray();

        Map<Character, Integer> mapSymbols = new HashMap<>();

        for (int i = 0; i < simbols.length; i++) {
            if (Character.isLetter(simbols[i])) {
                Integer count = mapSymbols.get(simbols[i]);
                if (count == null) {
                    mapSymbols.put(simbols[i], 1);
                } else {
                    mapSymbols.put(simbols[i], ++count);
                }
            }
        }
        //System.out.println(mapSymbols);

        Integer max = getMax(mapSymbols);
        Integer min = getMin(mapSymbols);

        System.out.print(" Максимальное кол-во вхождений: ");
        for (Map.Entry<Character, Integer> mapSymbol: mapSymbols.entrySet()) {
            if(Objects.equals(mapSymbol.getValue(),max)){
                System.out.print("[" + mapSymbol.getKey() + ": " + mapSymbol.getValue() + "] ");
            }
        }

        System.out.println();
        System.out.print(" Минимальное кол-во вхождений: ");
        for (Map.Entry<Character, Integer> mapSymbol: mapSymbols.entrySet()) {
            if(Objects.equals(mapSymbol.getValue(),min)){
                System.out.print("[" + mapSymbol.getKey() + ": " + mapSymbol.getValue() + "] ");
            }
        }
    }

    private static Integer getMax(Map<Character, Integer> mapSymbols) {
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> mapSymbol : mapSymbols.entrySet()) {
            if (mapSymbol.getValue() > max) {
                max = mapSymbol.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> mapSymbols) {
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> mapSymbol: mapSymbols.entrySet()) {
            if (mapSymbol.getValue() < min) {
                min = mapSymbol.getValue();
            }
        }
        return min;
    }

}