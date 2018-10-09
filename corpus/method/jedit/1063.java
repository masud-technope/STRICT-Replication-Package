private char getEscapeChar(char ch) {
    switch(ch) {
        case 'b':
            ch = '\b';
            break;
        case 't':
            ch = '\t';
            break;
        case 'n':
            ch = '\n';
            break;
        case 'f':
            ch = '\f';
            break;
        case 'r':
            ch = '\r';
            break;
        // do nothing - ch already contains correct character
        case '"':
        case '\'':
        case '\\':
            break;
    }
    return ch;
}