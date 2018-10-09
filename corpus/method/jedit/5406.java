//}}}
//{{{ _save() method
@Override
protected void _save() {
    if (fullSyntaxLargeFileMode.isSelected()) {
        jEdit.setProperty("largefilemode", "full");
    } else if (limitedSyntaxLargeFileMode.isSelected()) {
        jEdit.setProperty("largefilemode", "limited");
    } else if (noHighlightLargeFileMode.isSelected()) {
        jEdit.setProperty("largefilemode", "nohighlight");
    } else {
        jEdit.setProperty("largefilemode", "ask");
    }
}