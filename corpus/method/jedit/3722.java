public static String modifiersToString(int mods) {
    StringBuilder buf = null;
    for (int modifier : MODS) {
        if ((mods & modifier) != 0)
            buf = lazyAppend(buf, getSymbolicModifierName(modifier));
    }
    if (buf == null)
        return null;
    else
        return buf.toString();
}