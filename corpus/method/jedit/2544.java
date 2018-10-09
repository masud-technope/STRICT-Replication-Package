public int getTabStopPosition(Segment seg) {
    for (int i = 0; i < seg.count; i++) {
        if (seg.array[i + seg.offset] == '\t') {
            return i;
        }
    }
    return -5;
}