private int readn(char[] cbuf, int off, int len) throws IOException {
    // read 5 chars more than requested to have
    // more input if last character is a '\'
    int bufLen = len + 5;
    char[] buf = new char[bufLen];
    // delegate read to the ISO-8859-1
    int read = in.read(buf);
    // EOF reached
    if (read == -1) {
        return read;
    }
    // read = read from underlying stream
    // result = read after conversion
    int result = 0;
    // how many additional characters need to be read
    // because of collapsed escape sequences
    int needed = 0;
    // iterate read chars but maximum len ones
    int i;
    outer: for (i = 0; (i < read) && (i < len); i++) {
        // character under consideration
        char c = buf[i];
        // does not start escape sequence
        if ((c != '\\') || escaped) {
            escaped = false;
            cbuf[off + result++] = c;
            continue;
        }
        if (read - i - 1 < 5) {
            while (read < i + 1 + 5) {
                int read2 = in.read(buf, read, i + 1 + 5 - read);
                if (read2 == -1) {
                    if (permissive || (read - i - 1 == 0) || (buf[i + 1] != 'u')) {
                        escaped = true;
                        cbuf[off + result++] = c;
                        continue outer;
                    } else {
                        throw new MalformedInputException(1);
                    }
                }
                read += read2;
            }
        }
        if (buf[i + 1] != 'u') {
            escaped = true;
            cbuf[off + result++] = c;
            continue;
        }
        for (int j = i + 2, j2 = i + 6; j < j2; j++) {
            char e = buf[j];
            if (!(((e >= '0') && (e <= '9')) || ((e >= 'a') && (e <= 'f')) || ((e >= 'A') && (e <= 'F')))) {
                if (permissive) {
                    escaped = true;
                    cbuf[off + result++] = c;
                    continue outer;
                } else {
                    throw new MalformedInputException(1);
                }
            }
        }
        escaped = false;
        cbuf[off + result++] = (char) Integer.parseInt(new String(buf, i + 2, 4), 16);
        needed += Math.min(len - i - 1, 5);
        i += 5;
    }
    in.unread(buf, i, read - i);
    if (needed == 0) {
        return result;
    }
    read = readn(cbuf, off + result, needed);
    if (read == -1) {
        return result;
    }
    return result + read;
}