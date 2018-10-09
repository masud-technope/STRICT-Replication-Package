//}}}
//{{{ setModel() method
/**
	 * Sets the history list model.
	 * @param name The model name
	 * @since jEdit 2.3pre3
	 */
public void setModel(String name) {
    controller.setModel(name);
    if (name != null) {
        setBorder(new CompoundBorder(this.getBorder(), new HistoryBorder()));
    }
    repaint();
}