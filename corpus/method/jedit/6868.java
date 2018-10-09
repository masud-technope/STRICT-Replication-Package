//}}}
//{{{ dump() method
void dump() {
    if (Debug.FOLD_VIS_DEBUG) {
        StringBuilder buf = new StringBuilder("{");
        for (int i = 0; i < fvmcount; i++) {
            if (i != 0)
                buf.append(',');
            buf.append(fvm[i]);
        }
        buf.append('}');
        Log.log(Log.DEBUG, this, "fvm = " + buf);
    }
}