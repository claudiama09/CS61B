import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
//        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
//                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
//                'u', 'v', 'w', 'x', 'y', 'z'};
//
//        int xIndex = 0;
//        int yIndex = 0;
//        for (int i = 0; i < alphabets.length; i++) {
//            if (alphabets[i] == x) {
//                xIndex = i;
//            }
//            if (alphabets[i] == y) {
//                yIndex = i;
//            }
//        }
//
//        if (Math.abs(xIndex - yIndex) == 1 || Math.abs(xIndex - yIndex) == 25) {
//            return true;
//        }
        if (Math.abs(x - y) == 1 || Math.abs(x - y) == 25) {
            return true;
        }

        return false;
    }

    public OffByOne() {

    }

    @Test
    public void testOffByOne() {
        assertTrue(equalChars('a', 'b'));
        assertTrue(equalChars('z', 'a'));
        assertTrue(equalChars('r', 'q'));
        assertFalse(equalChars('a', 'a'));
    }
}
