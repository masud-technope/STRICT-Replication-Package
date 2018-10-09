//}}}
//{{{ put2() method
/**
	 * Merge previous and next entry if necessary.
	 */
void put2(int starti, int endi, int start, int end) {
    if (Debug.FOLD_VIS_DEBUG) {
        Log.log(Log.DEBUG, this, "*fvmput2(" + starti + "," + endi + "," + start + "," + end + ")");
    }
    if (starti != -1 && fvm[starti] == start) {
        if (endi <= fvmcount - 2 && fvm[endi + 1] == end + 1) {
            put(starti, endi + 2, null);
        } else {
            put(starti, endi + 1, new int[] { end + 1 });
        }
    } else {
        if (endi != fvmcount - 1 && fvm[endi + 1] == end + 1) {
            put(starti + 1, endi + 2, new int[] { start });
        } else {
            put(starti + 1, endi + 1, new int[] { start, end + 1 });
        }
    }
}