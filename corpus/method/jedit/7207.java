@Override
public char last() {
    int length = sequence.length();
    index = (length > 0) ? length - 1 : length;
    return current();
}