private BufferSegment subSegment(int start, int end) {
    if (0 <= start && start <= end)
        if (end <= len)
            return new BufferSegment(data, offset + start, end - start);
        else if (next != null)
            if (start < len)
                return new BufferSegment(data, offset + start, len - start, next.subSegment(0, end - len));
            else
                return next.subSegment(start - len, end - len);
        else
            throw new ArrayIndexOutOfBoundsException();
    else
        throw new ArrayIndexOutOfBoundsException();
}