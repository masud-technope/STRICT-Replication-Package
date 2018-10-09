//}}}
//{{{ getStringMapKey() method
private int getStringMapKey(char[] s) {
    return (Character.toUpperCase(s[0]) + Character.toUpperCase(s[s.length - 1])) % mapLength;
}