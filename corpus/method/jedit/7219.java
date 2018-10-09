@Override
public char setIndex(int position) {
    if (0 <= position && position <= sequence.length()) {
        index = position;
        return current();
    } else {
        // Stacktrace will be enough.
        throw new IllegalArgumentException();
    }
}