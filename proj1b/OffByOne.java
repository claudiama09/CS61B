public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == 1 || Math.abs(x - y) == 25) {
            return true;
        }

        return false;
    }

    public OffByOne() {

    }

}
