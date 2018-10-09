@Override
public void mouseWheelMoved(MouseWheelEvent e) {
    /****************************************************
			 * move caret depending on pressed control-keys:
			 * - Alt: move cursor, do not select
			 * - Alt+(shift or control): move cursor, select
			 * - shift: scroll horizontally
			 * - control: scroll single line
			 * - <else>: scroll 3 lines
			 ****************************************************/
    if (e.isAltDown()) {
        boolean select = e.isShiftDown() || e.isControlDown();
        if (e.getWheelRotation() < 0)
            goToPrevLine(select);
        else
            goToNextLine(select);
    } else if (e.getScrollType() == MouseWheelEvent.WHEEL_BLOCK_SCROLL) {
        if (e.isShiftDown()) {
            // Wheel orientation is reversed so we negate the charwidth
            _setHorizontalOffset(getHorizontalOffset() + (e.getWheelRotation() > 0 ? 1 : -1) * painter.getWidth());
        } else {
            if (e.getWheelRotation() > 0)
                scrollDownPage();
            else
                scrollUpPage();
        }
    } else if (e.isControlDown() && e.isShiftDown()) {
        if (e.getWheelRotation() > 0)
            scrollDownPage();
        else
            scrollUpPage();
    } else if (e.isControlDown()) {
        setFirstLine(getFirstLine() + e.getWheelRotation());
    } else if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
        if (e.isShiftDown()) {
            _setHorizontalOffset(getHorizontalOffset() + (-charWidth * e.getUnitsToScroll()));
        } else {
            setFirstLine(getFirstLine() + e.getUnitsToScroll());
        }
    } else {
        if (e.isShiftDown()) {
            _setHorizontalOffset(getHorizontalOffset() + (-charWidth * e.getWheelRotation()));
        } else {
            setFirstLine(getFirstLine() + 3 * e.getWheelRotation());
        }
    }
}