//}}}
//{{{ throwException() method
private void throwException(int offset, int line) {
    throw new IllegalArgumentException("{ELASTIC TABSTOP}CORRUPT DATA@{" + System.currentTimeMillis() + "} & Thread : " + Thread.currentThread().getName() + " :Cannot find the size for tab at offset " + (offset - buffer.getLineStartOffset(line)) + "in line " + line + "while searching in \n " + this);
}