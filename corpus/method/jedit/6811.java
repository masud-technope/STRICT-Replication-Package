//}}}
//{{{ setCurrentLineHighlightEnabled() method
public void setCurrentLineHighlightEnabled(boolean enabled) {
    if (currentLineHighlightEnabled == enabled)
        return;
    currentLineHighlightEnabled = enabled;
    repaint();
}