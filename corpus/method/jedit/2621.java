//}}}
//{{{ propertiesChanged() method
public void propertiesChanged(int historySize) {
    int newSize = Math.max(1, historySize);
    if (ring == null)
        ring = new String[newSize];
    else if (newSize != ring.length) {
        String[] newRing = new String[newSize];
        int newCount = Math.min(getSize(), newSize);
        for (int i = 0; i < newCount; i++) {
            newRing[i] = getElementAt(i);
        }
        ring = newRing;
        count = newCount;
        wrap = false;
    }
    if (count == ring.length) {
        count = 0;
        wrap = true;
    }
}