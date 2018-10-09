@Override
public char previous() {
    if (index > 0) {
        index = index - 1;
        return current();
    } else {
        return DONE;
    }
}