//}}}
//{{{ preContentRemoved() method
/**
	 * @return If the anchors should be reset.
	 */
boolean preContentRemoved(int startLine, int numLines) {
    boolean returnValue = false;
    int endLine = startLine + numLines;
    /* update fold visibility map. */
    int starti = search(startLine);
    int endi = search(endLine);
    /* both have same visibility; just remove
		 * anything in between. */
    if (Math.abs(starti % 2) == Math.abs(endi % 2)) {
        if (endi - starti == fvmcount) {
            // we're removing from before
            // the first visible to after
            // the last visible
            returnValue = true;
            starti = 1;
        } else {
            put(starti + 1, endi + 1, null);
            starti++;
        }
    } else /* collapse 2 */
    if (starti != -1 && fvm[starti] == startLine) {
        if (endi - starti == fvmcount - 1) {
            // we're removing from
            // the first visible to after
            // the last visible
            returnValue = true;
            starti = 1;
        } else
            put(starti, endi + 1, null);
    } else /* shift */
    {
        put(starti + 1, endi, null);
        fvm[starti + 1] = startLine;
        starti += 2;
    }
    /* update */
    for (int i = starti; i < fvmcount; i++) fvm[i] -= numLines;
    lastfvmget = -1;
    dump();
    return returnValue;
}