//}}}
//}}}
//{{{ Caret
//{{{ caretAutoScroll() method
/**
	 * Return if change in buffer should scroll this text area.
	 * @since jEdit 4.3pre2
	 */
public boolean caretAutoScroll() {
    return focusedComponent == this;
}