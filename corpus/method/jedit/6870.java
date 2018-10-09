//}}}
//{{{ hide() method
void hide(int start, int end) {
    int starti = search(start);
    int endi = search(end);
    if (starti % 2 == 0) {
        if (endi % 2 == 0)
            put2(starti, endi, start, end);
        else {
            if (start == fvm[0])
                put(starti, endi + 1, null);
            else {
                put(starti + 1, endi, null);
                fvm[starti + 1] = start;
            }
        }
    } else {
        if (endi % 2 == 0) {
            if (end + 1 == fvm[fvmcount - 1])
                put(starti + 1, endi + 2, null);
            else {
                put(starti + 1, endi, null);
                fvm[starti + 1] = end + 1;
            }
        } else
            put(starti + 1, endi + 1, null);
    }
    lastfvmget = -1;
}