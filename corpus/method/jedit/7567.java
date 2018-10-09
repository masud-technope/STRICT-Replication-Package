//}}}
//{{{ add() method
public void add(int num) {
    if (len >= array.length) {
        int[] arrayN = new int[len * 2];
        System.arraycopy(array, 0, arrayN, 0, len);
        array = arrayN;
    }
    array[len++] = num;
}