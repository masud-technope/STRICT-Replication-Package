//}}}
//{{{ remove() method
void remove(int i) {
    if (wrap) {
        String[] newRing = new String[ring.length];
        int newCount = 0;
        for (int j = 0; j < ring.length; j++) {
            int index = virtualToPhysicalIndex(j);
            if (i == index) {
                continue;
            }
            newRing[newCount++] = ring[index];
        }
        ring = newRing;
        count = newCount;
        wrap = false;
    } else {
        System.arraycopy(ring, i + 1, ring, i, count - i - 1);
        count--;
    }
}