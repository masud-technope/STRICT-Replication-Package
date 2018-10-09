@Override
public String getToolTipText(int x, int y) {
    if (textArea.wrapMargin != 0 && !textArea.wrapToWidth && isWrapGuidePainted()) {
        int wrapGuidePos = textArea.wrapMargin + textArea.getHorizontalOffset();
        if (Math.abs(x - wrapGuidePos) < 5) {
            return String.valueOf(textArea.getBuffer().getProperty("maxLineLen"));
        }
    }
    return null;
}