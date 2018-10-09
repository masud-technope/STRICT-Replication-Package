//}}}
//{{{ handleCollapse() method
private static void handleCollapse(List<IndentAction> indentActions, boolean delPrevPrevCollapse) {
    if (indentActions.contains(IndentAction.PrevCollapse)) {
        indentActions.clear();
        return;
    }
    if (delPrevPrevCollapse && indentActions.contains(IndentAction.PrevPrevCollapse)) {
        indentActions.clear();
        return;
    }
}