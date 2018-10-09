//}}}
//{{{ addOccur() method
void addOccur(int start, int end) {
    Occur o = new Occur(start, end);
    o.next = occur;
    occur = o;
    occurCount++;
}