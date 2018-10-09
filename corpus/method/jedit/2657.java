//}}}
//{{{ contentRemoved() method
public synchronized void contentRemoved(int offset, int length) {
    if (positions.isEmpty())
        return;
    /* get all positions from offset to the end, inclusive */
    Iterator<PosBottomHalf> iter = positions.tailMap(new PosBottomHalf(offset)).keySet().iterator();
    iteration = true;
    while (iter.hasNext()) {
        iter.next().contentRemoved(offset, length);
    }
    iteration = false;
}