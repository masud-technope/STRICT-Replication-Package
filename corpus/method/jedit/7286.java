//}}}
//{{{ _changeLine() method
private void _changeLine(boolean select, int newCaret) {
    if (select) {
        RectParams params = getRectParams(caret, newCaret);
        int extraStartVirt;
        int extraEndVirt;
        if (params == null) {
            extraStartVirt = 0;
            extraEndVirt = 0;
        } else {
            extraStartVirt = params.extraStartVirt;
            extraEndVirt = params.extraEndVirt;
            newCaret = params.newCaret;
        }
        extendSelection(caret, newCaret, extraStartVirt, extraEndVirt);
    } else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}