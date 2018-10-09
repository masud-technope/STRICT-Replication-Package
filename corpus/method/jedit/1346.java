public int read() throws IOException {
    int b;
    if (state == sentSemi) {
        state = lastCharNL;
        return '\n';
    }
    // skip CR
    while ((b = in.read()) == '\r') ;
    if (b == '\n')
        if (state == lastCharNL) {
            b = ';';
            state = sentSemi;
        } else
            state = lastCharNL;
    else
        state = normal;
    return b;
}