public void caretPositionChanged(InputMethodEvent event) {
    composedCaretX = 0;
    if (composedTextLayout != null) {
        TextHitInfo caret = event.getCaret();
        if (caret != null) {
            composedCaretX = Math.round(composedTextLayout.getCaretInfo(caret)[0]);
        }
        // Adjust visiblity.
        int insertion_x = owner.offsetToXY(owner.getCaretPosition()).x;
        TextHitInfo visible = event.getVisiblePosition();
        int composed_visible_x = (visible != null) ? Math.round(composedTextLayout.getCaretInfo(visible)[0]) : composedCaretX;
        int visible_x = insertion_x + composed_visible_x;
        int painter_width = owner.getPainter().getWidth();
        int adjustment = 0;
        if (visible_x < 0) {
            adjustment = visible_x;
        }
        if (visible_x >= painter_width) {
            adjustment = visible_x - (painter_width - 1);
        }
        if (adjustment != 0) {
            owner.setHorizontalOffset(owner.getHorizontalOffset() - adjustment);
        }
    } else {
        /* Cancel horizontal adjustment for composed text.
			   FIXME:
			     The horizontal offset may be beyond the max
			     value of owner's horizontal scroll bar.
			*/
        owner.scrollToCaret(false);
    }
    /* Invalidate one more line below the caret because
		   the underline for composed text goes beyond the caret
		   line in some font settings. */
    int caret_line = owner.getCaretLine();
    owner.invalidateLineRange(caret_line, caret_line + 1);
    event.consume();
}