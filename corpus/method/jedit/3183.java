//}}}
//{{{ doSelectedCompletion() method
/**
	 * Do completion with current selection and quit.
	 */
public boolean doSelectedCompletion() {
    int selected = list.getSelectedIndex();
    if (candidates != null && 0 <= selected && selected < candidates.getSize()) {
        candidates.complete(selected);
        dispose();
        return true;
    }
    return false;
}