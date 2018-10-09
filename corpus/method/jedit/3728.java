//{{{ parseModifiers() method
private static int parseModifiers(String modifierString) {
    int modifiers = 0;
    for (char ch : modifierString.toCharArray()) {
        switch(Character.toUpperCase(ch)) {
            case 'A':
                modifiers |= a;
                break;
            case 'C':
                modifiers |= c;
                break;
            case 'M':
                modifiers |= m;
                break;
            case 'S':
                modifiers |= s;
                break;
        }
    }
    return modifiers;
}