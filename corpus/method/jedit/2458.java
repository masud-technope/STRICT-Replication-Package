public void insert(int start, Segment seg) {
    prepareGapForInsertion(start, seg.count);
    System.arraycopy(seg.array, seg.offset, text, start, seg.count);
    gapStart += seg.count;
    length += seg.count;
}