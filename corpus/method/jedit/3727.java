@Override
public String toString() {
    return (modifiers == null ? "" : modifiers) + '<' + Integer.toString(key, 16) + ',' + Integer.toString(input, 16) + '>';
}