private char med3(char a, char b, char c) {
    char t;
    if (a > b) {
        t = a;
        a = b;
        b = t;
    }
    if (b > c) {
        t = b;
        b = c;
        c = t;
    }
    if (a > b) {
        b = a;
    }
    return b;
}