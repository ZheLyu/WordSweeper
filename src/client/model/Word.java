
package client.model;

import java.util.*;

/**
 * This class has a static map used for calculate the score of words users select
 * @author ZELING LEI
 *
 */
public class Word {
	
	
	public static final Map<String, Integer> WEIGHT = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> weight = new HashMap<>();
        weight.put("A", 2);
        weight.put("B", 4);
        weight.put("C", 3);
        weight.put("D", 3);
        weight.put("E", 1);
        weight.put("F", 4);
        weight.put("G", 4);
        weight.put("H", 2);
        weight.put("I", 2);
        weight.put("J", 7);
        weight.put("K", 5);
        weight.put("L", 3);
        weight.put("M", 3);
        weight.put("N", 2);
        weight.put("O", 2);
        weight.put("P", 4);
        weight.put("Qu", 11);
        weight.put("R", 2);
        weight.put("S", 2);
        weight.put("T", 1);
        weight.put("U", 3);
        weight.put("V", 5);
        weight.put("W", 3);
        weight.put("X", 7);
        weight.put("Y", 4);
        weight.put("Z", 8);
        weight.put("a", 2);
        weight.put("b", 4);
        weight.put("c", 3);
        weight.put("d", 3);
        weight.put("e", 1);
        weight.put("f", 4);
        weight.put("g", 4);
        weight.put("h", 2);
        weight.put("i", 2);
        weight.put("j", 7);
        weight.put("k", 5);
        weight.put("l", 3);
        weight.put("m", 3);
        weight.put("n", 2);
        weight.put("o", 2);
        weight.put("p", 4);
        weight.put("qu", 11);
        weight.put("r", 2);
        weight.put("s", 2);
        weight.put("t", 1);
        weight.put("u", 3);
        weight.put("v", 5);
        weight.put("w", 3);
        weight.put("x", 7);
        weight.put("y", 4);
        weight.put("z", 8);
        return Collections.unmodifiableMap(weight);
    }
    
}
