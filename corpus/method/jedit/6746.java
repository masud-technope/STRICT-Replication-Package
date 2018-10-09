//}}}
//{{{ getToolTipText() method
String getToolTipText(int x, int y) {
    for (Entry extension : extensions) {
        TextAreaExtension ext = extension.ext;
        String toolTip = ext.getToolTipText(x, y);
        if (toolTip != null)
            return toolTip;
    }
    return null;
}