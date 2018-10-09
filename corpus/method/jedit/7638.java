public CharSequence subSequence(int start, int end) {
    return new SegmentCharSequence(seg, offset + start, end - start);
}