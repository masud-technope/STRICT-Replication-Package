public String toString() {
    if (value == Special.NULL_VALUE)
        return "null";
    else if (value == Special.VOID_TYPE)
        return "void";
    else
        return value.toString();
}