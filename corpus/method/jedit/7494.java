//}}}
//{{{ nextTextArea() method
/**
	 * Moves keyboard focus to the next text area.
	 * @since jEdit 2.7pre4
	 */
public void nextTextArea() {
    EditPane[] editPanes = getEditPanes();
    for (int i = 0; i < editPanes.length; i++) {
        if (editPane == editPanes[i]) {
            if (i == editPanes.length - 1)
                editPanes[0].focusOnTextArea();
            else
                editPanes[i + 1].focusOnTextArea();
            break;
        }
    }
}