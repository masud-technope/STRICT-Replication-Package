//}}}
//{{{ apply() method
public void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions) {
    int prevOpenBracketCount = getOpenBracketCount(buffer, prevLineIndex);
    if (prevOpenBracketCount != 0) {
        handleCollapse(indentActions, true);
        boolean multiple = buffer.getBooleanProperty("multipleBracketIndent");
        IndentAction increase = new IndentAction.Increase(multiple ? prevOpenBracketCount : 1);
        indentActions.add(increase);
    } else if (getOpenBracketCount(buffer, thisLineIndex) != 0) {
        handleCollapse(indentActions, false);
    }
}