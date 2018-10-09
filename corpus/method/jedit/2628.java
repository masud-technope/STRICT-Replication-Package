//}}}
//{{{ indexOf() method
private int indexOf(String str) {
    int length = (wrap ? ring.length : count);
    for (int i = length - 1; i >= 0; i--) {
        if (ring[i].equals(str)) {
            return i;
        }
    }
    return -1;
}