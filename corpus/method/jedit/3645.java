//}}}
//{{{ setText() method
/**
	 * Sets the displayed text.
	 */
public void setText(String text) {
    super.setText(text);
    controller.setIndex(-1);
}