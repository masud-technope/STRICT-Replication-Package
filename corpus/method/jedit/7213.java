@Override
public char next() {
    int length = sequence.length();
    if (index < length) {
        index = index + 1;
        return current();
    } else {
        return DONE;
    }
}