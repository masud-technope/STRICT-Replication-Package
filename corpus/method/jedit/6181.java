//{{{ HyperSearchResult constructor
 HyperSearchResult(Buffer buffer, int line) {
    path = buffer.getPath();
    if (!buffer.isTemporary())
        bufferOpened(buffer);
    this.line = line;
    str = (line + 1) + ": " + buffer.getLineText(line).replace('\t', ' ').trim();
}