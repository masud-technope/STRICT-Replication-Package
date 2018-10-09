@Override
public boolean equals(Object o) {
    if (o instanceof Key) {
        Key k = (Key) o;
        if (Objects.equals(modifiers, k.modifiers) && key == k.key && input == k.input) {
            return true;
        }
    }
    return false;
}