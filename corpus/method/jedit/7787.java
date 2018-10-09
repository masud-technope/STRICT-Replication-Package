public String lineAt(int i) {
    StringBuilder sb = new StringBuilder();
    while (!atEndOfBuffer(i)) {
        char c = charAt(i);
        sb.append(c);
        if (c == '\n')
            break;
    }
    return sb.toString();
}