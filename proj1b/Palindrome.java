import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> arrayList = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            arrayList.addLast(word.charAt(i));
        }
        return arrayList;
    }

    @SuppressFBWarnings({"RC_REF_COMPARISON", "ICAST_IDIV_CAST_TO_DOUBLE", "UC_USELESS_CONDITION"})
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        int size = wordDeque.size();

        if (size <= 1) {
            return true;
        }
//
//        for (int i = 0; i < Math.floor(size / 2); i++) {
//            if (wordDeque.removeFirst() != wordDeque.removeLast()) {
//                return false;
//            }
//        }
//
//        return true;

        return isPalindromeHelper(wordDeque, 0, size - 1);

    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque, int start, int end) {
        if (start == end) {
            return true;
        }

        if (wordDeque.removeFirst() != wordDeque.removeLast()) {
            return false;
        }

        return isPalindromeHelper(wordDeque, start + 1, end - 1);

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque<Character> wordDeque = wordToDeque(word);

        int size = wordDeque.size();

        if (size <= 1) {
            return true;
        }

        for (int i = 0; i < Math.floor(size / 2); i++) {
            char firstWord = wordDeque.removeFirst();
            char lastWord = wordDeque.removeLast();

            if (!cc.equalChars(firstWord, lastWord)) {
                return false;
            }
        }
        return true;
    }

}
