public class OffByN implements CharacterComparator {
    public int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == n || Math.abs(x - y) == 25 - n) {
            return true;
        }

        return false;
    }
}
