public char charAt(int index) {
    if (index < len)
        return data[offset + index];
    else if (next != null)
        return next.charAt(index - len);
    else
        throw new ArrayIndexOutOfBoundsException(index);
}