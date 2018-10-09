public TextHitInfo getLocationOffset(int x, int y) {
    if (composedTextLayout != null) {
        Point origin = owner.getPainter().getLocationOnScreen();
        Point caret = owner.offsetToXY(owner.getCaretPosition());
        float local_x = x - origin.x - caret.x;
        float local_y = y - origin.y - caret.y - (composedTextLayout.getLeading() + 1) - composedTextLayout.getAscent();
        return composedTextLayout.hitTestChar(local_x, local_y);
    }
    return null;
}