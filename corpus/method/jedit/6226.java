//}}}
//{{{ updateMultiStatus() method
private void updateMultiStatus() {
    if (multiStatus)
        multi.setIcon(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.multi.multiple.icon")));
    else
        multi.setIcon(GUIUtilities.loadIcon(jEdit.getProperty("hypersearch-results.multi.single.icon")));
}