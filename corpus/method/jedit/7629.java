//}}}
//{{{ Private members
//{{{ ensureCapacity() method
private void ensureCapacity(int capacity) {
    if (array == null)
        array = new char[capacity];
    else if (capacity >= array.length) {
        char[] arrayN = new char[capacity * 2];
        System.arraycopy(array, 0, arrayN, 0, count);
        array = arrayN;
    }
}