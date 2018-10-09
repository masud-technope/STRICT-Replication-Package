protected void ExpandBuff(boolean wrapAround) {
    char[] newbuffer = new char[bufsize + 2048];
    int newbufline[] = new int[bufsize + 2048];
    int newbufcolumn[] = new int[bufsize + 2048];
    try {
        if (wrapAround) {
            System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
            System.arraycopy(buffer, 0, newbuffer, bufsize - tokenBegin, bufpos);
            buffer = newbuffer;
            System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
            System.arraycopy(bufline, 0, newbufline, bufsize - tokenBegin, bufpos);
            bufline = newbufline;
            System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
            System.arraycopy(bufcolumn, 0, newbufcolumn, bufsize - tokenBegin, bufpos);
            bufcolumn = newbufcolumn;
            bufpos += (bufsize - tokenBegin);
        } else {
            System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
            buffer = newbuffer;
            System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
            bufline = newbufline;
            System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
            bufcolumn = newbufcolumn;
            bufpos -= tokenBegin;
        }
    } catch (Throwable t) {
        throw new Error(t.getMessage());
    }
    available = (bufsize += 2048);
    tokenBegin = 0;
}