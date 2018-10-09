//}}}
//{{{ createPosition() method
/** No explicit removal is required. Unreferencing is enough. */
public synchronized Position createPosition(int offset) {
    PosBottomHalf bh = new PosBottomHalf(offset);
    PosBottomHalf existing = positions.get(bh);
    if (existing == null) {
        positions.put(bh, bh);
        existing = bh;
    }
    return new PosTopHalf(existing);
}