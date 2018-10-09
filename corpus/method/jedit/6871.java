//}}}
//{{{ show() method
void show(int start, int end) {
    int starti = search(start);
    int endi = search(end);
    if (starti % 2 == 0) {
        if (endi % 2 == 0)
            put(starti + 1, endi + 1, null);
        else {
            if (endi != fvmcount - 1 && fvm[endi + 1] == end + 1)
                put(starti + 1, endi + 2, null);
            else {
                put(starti + 1, endi, null);
                fvm[starti + 1] = end + 1;
            }
        }
    } else {
        if (endi % 2 == 0) {
            if (starti != -1 && fvm[starti] == start)
                put(starti, endi + 1, null);
            else {
                put(starti + 1, endi, null);
                fvm[starti + 1] = start;
            }
        } else
            put2(starti, endi, start, end);
    }
    lastfvmget = -1;
}