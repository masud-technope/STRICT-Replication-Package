//}}}
//{{{ cancel() method
public void cancel() {
    save(true);
    GUIUtilities.saveGeometry(this, "search");
    setVisible(false);
}