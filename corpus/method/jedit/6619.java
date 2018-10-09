//}}}
//{{{ getReadyToBreakFold() method
// This is a fix for black hole bug.
// If you modify a part of folded lines, like {{{ (followed by }}}),
// the fold is removed so it must be expanded otherwise the text
// remains invisible.
private void getReadyToBreakFold(int line) {
    displayManager.expandFold(line, false);
}