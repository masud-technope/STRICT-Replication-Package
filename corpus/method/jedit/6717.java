//}}}
//{{{ invalidateScreenLineCounts() method
void invalidateScreenLineCounts() {
    screenLineMgr.invalidateScreenLineCounts();
    firstLine.setCallReset(true);
    scrollLineCount.setCallReset(true);
}