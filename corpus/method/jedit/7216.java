@Override
public char current() {
    return index < sequence.length() ? sequence.charAt(index) : DONE;
}