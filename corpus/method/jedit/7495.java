//}}}
//{{{ prevTextArea() method
/**
	 * Moves keyboard focus to the previous text area.
	 * @since jEdit 2.7pre4
	 */
public void prevTextArea() {
    EditPane[] editPanes = getEditPanes();
    for (int i = 0; i < editPanes.length; i++) {
        if (editPane == editPanes[i]) {
            if (i == 0)
                editPanes[editPanes.length - 1].focusOnTextArea();
            else
                editPanes[i - 1].focusOnTextArea();
            break;
        }
    }
}