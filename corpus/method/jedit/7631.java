//}}}
//{{{ append() method
public void append(char ch) {
    ensureCapacity(count + 1);
    array[offset + count] = ch;
    count++;
}