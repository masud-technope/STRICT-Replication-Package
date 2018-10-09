//}}}
//{{{ setSelectionAreaEnabled() method
public void setSelectionAreaEnabled(boolean enabled) {
    if (isSelectionAreaEnabled() == enabled)
        return;
    selectionAreaEnabled = enabled;
    if (enabled)
        collapsedSize.width += selectionAreaWidth;
    else
        collapsedSize.width -= selectionAreaWidth;
    revalidate();
}