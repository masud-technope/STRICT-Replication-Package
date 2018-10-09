//}}}
//{{{ apply() method
public void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions) {
    if (thisAction != null && lineMatches(buffer, thisLineIndex)) {
        indentActions.add(thisAction);
    }
    if (prevAction != null && prevLineIndex != -1 && lineMatches(buffer, prevLineIndex)) {
        indentActions.add(prevAction);
        if (collapse)
            indentActions.add(IndentAction.PrevCollapse);
    }
    if (prevPrevAction != null && prevPrevLineIndex != -1 && lineMatches(buffer, prevPrevLineIndex)) {
        indentActions.add(prevPrevAction);
        if (collapse)
            indentActions.add(IndentAction.PrevPrevCollapse);
    }
}