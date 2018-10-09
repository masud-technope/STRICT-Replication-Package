//}}}
//{{{ contentInserted() method
public synchronized void contentInserted(int offset, int length) {
    if (positions.isEmpty())
        return;
    /* get all positions from offset to the end, inclusive */
    Iterator<PosBottomHalf> iter = positions.tailMap(new PosBottomHalf(offset)).keySet().iterator();
    iteration = true;
    while (iter.hasNext()) {
        iter.next().contentInserted(offset, length);
    }
    iteration = false;
}