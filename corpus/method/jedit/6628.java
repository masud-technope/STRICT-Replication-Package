//}}}
//{{{ foldLevelChanged() method
public void foldLevelChanged(JEditBuffer buffer, int start, int end) {
    if (textArea.getDisplayManager() == displayManager && end != 0 && !buffer.isLoading()) {
        textArea.invalidateLineRange(start - 1, textArea.getLastPhysicalLine());
    }
}