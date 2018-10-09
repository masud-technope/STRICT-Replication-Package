//}}}
//{{{ needFullRepaint() method
/**
	 * The needFullRepaint variable becomes true when the number of screen
	 * lines in a physical line changes.
	 * @return true if the TextArea needs full repaint
	 */
boolean needFullRepaint() {
    boolean retVal = needFullRepaint;
    needFullRepaint = false;
    return retVal;
}