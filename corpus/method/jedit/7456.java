//}}}
//{{{ visit() method
/**
	 * Visit the the editpanes and textareas of the view
	 * @param visitor the visitor
	 * @since jEdit 4.3pre13
	 */
public void visit(JEditVisitor visitor) {
    EditPane[] panes = getEditPanes();
    for (EditPane editPane : panes) {
        visitor.visit(editPane);
        visitor.visit(editPane.getTextArea());
    }
}