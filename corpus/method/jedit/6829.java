// }}}
// {{{ implements InputMethodRequests
public Rectangle getTextLocation(TextHitInfo offset) {
    if (composedTextLayout != null) {
        // return location of composed text.
        Point caret = owner.offsetToXY(owner.getCaretPosition());
        return getCaretRectangle(caret.x + composedCaretX, caret.y);
    } else {
        // return location of selected text.
        Selection selection_on_caret = owner.getSelectionAtOffset(owner.getCaretPosition());
        if (selection_on_caret != null) {
            Point selection_start = owner.offsetToXY(selection_on_caret.getStart());
            return getCaretRectangle(selection_start.x, selection_start.y);
        }
    }
    return null;
}