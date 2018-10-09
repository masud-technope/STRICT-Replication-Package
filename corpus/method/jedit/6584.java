//}}}
//{{{ findParent() method
/**
	 * Finds the first element whose tag matches 'tagName',
	 * searching backwards in the stack.
	 */
private TagDecl findParent(String tagName) {
    for (int idx = stateStack.size() - 1; idx >= 0; idx--) {
        TagDecl tag = stateStack.get(idx);
        if (tag.tagName.equals(tagName))
            return tag;
    }
    return null;
}