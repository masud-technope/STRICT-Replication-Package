//}}}
//{{{ put() method
/**
	 * Replaces from <code>start</code> to <code>end-1</code> inclusive with
	 * <code>put</code>. Update <code>fvmcount</code>.
	 */
void put(int start, int end, int[] put) {
    if (Debug.FOLD_VIS_DEBUG) {
        StringBuilder buf = new StringBuilder(50);
        buf.append("fvmput(").append(start).append(',');
        buf.append(end).append(',');
        buf.append('{');
        if (put != null) {
            for (int i = 0; i < put.length; i++) {
                if (i != 0)
                    buf.append(',');
                buf.append(put[i]);
            }
        }
        buf.append("})");
        Log.log(Log.DEBUG, this, buf.toString());
    }
    int putl = put == null ? 0 : put.length;
    int delta = putl - (end - start);
    if (fvmcount + delta > fvm.length) {
        int[] newfvm = new int[(fvm.length << 1) + 1];
        System.arraycopy(fvm, 0, newfvm, 0, fvmcount);
        fvm = newfvm;
    }
    if (delta != 0) {
        System.arraycopy(fvm, end, fvm, start + putl, fvmcount - end);
    }
    if (putl != 0) {
        System.arraycopy(put, 0, fvm, start, put.length);
    }
    fvmcount += delta;
    dump();
    if (fvmcount == 0)
        throw new InternalError();
}