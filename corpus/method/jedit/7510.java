//}}}
//{{{ updateGutterBorders() method
/**
	 * Updates the borders of all gutters in this view to reflect the
	 * currently focused text area.
	 * @since jEdit 2.6final
	 */
private void updateGutterBorders() {
    EditPane[] editPanes = getEditPanes();
    for (EditPane editPane : editPanes) editPane.getTextArea().getGutter().updateBorder();
}