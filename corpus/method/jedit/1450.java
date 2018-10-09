public String GetImage() {
    if (bufpos >= tokenBegin)
        return new String(buffer, tokenBegin, bufpos - tokenBegin + 1);
    else
        return new String(buffer, tokenBegin, bufsize - tokenBegin) + new String(buffer, 0, bufpos + 1);
}