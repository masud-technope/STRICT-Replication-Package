//}}}
//{{{ checkHashString() method
private boolean checkHashString(ParserRule rule) {
    for (int i = 0; i < rule.upHashChar.length; i++) {
        if (Character.toUpperCase(line.array[pos + i]) != rule.upHashChar[i]) {
            return false;
        }
    }
    return true;
}