@Override
public int read() throws IOException {
    // delegate read to the ISO-8859-1
    int result = in.read();
    // (EOF - which is signalled by -1 - is also captured)
    if ((result != '\\') || escaped) {
        escaped = false;
        return result;
    }
    int read = in.read();
    if (read == -1) {
        return result;
    }
    if (read != 'u') {
        escaped = true;
        in.unread(read);
        return result;
    }
    char[] escape = { 'u', '\0', '\0', '\0', '\0' };
    read = 1 + in.read(escape, 1, 4);
    if (read == 0) {
        if (permissive) {
            escaped = true;
            in.unread('u');
            return result;
        } else {
            throw new MalformedInputException(1);
        }
    }
    // mean no more input available currently, so try to read on
    while (read < 5) {
        int read2 = in.read(escape, read, 5 - read);
        // enough input for an escape sequence
        if (read2 == -1) {
            if (permissive) {
                escaped = true;
                in.unread(escape, 0, read);
                return result;
            } else {
                throw new MalformedInputException(1);
            }
        }
        read += read2;
    }
    // no unicode escape with non-hex characters in positions 3-6
    for (int i = 1; i < 5; i++) {
        char e = escape[i];
        if (!(((e >= '0') && (e <= '9')) || ((e >= 'a') && (e <= 'f')) || ((e >= 'A') && (e <= 'F')))) {
            if (permissive) {
                escaped = true;
                in.unread(escape, 0, read);
                return result;
            } else {
                throw new MalformedInputException(1);
            }
        }
    }
    // valid unicode escape
    escaped = false;
    return Integer.parseInt(new String(escape, 1, 4), 16);
}