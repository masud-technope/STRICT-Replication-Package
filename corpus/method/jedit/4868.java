//}}}
//{{{ visit() method
/**
	 * Visit the views, editpanes and textareas
	 * @param visitor the visitor
	 * @since jEdit 4.3pre13
	 */
public static void visit(JEditVisitor visitor) {
    View view = jEdit.getFirstView();
    while (view != null) {
        visitor.visit(view);
        view.visit(visitor);
        view = view.getNext();
    }
}