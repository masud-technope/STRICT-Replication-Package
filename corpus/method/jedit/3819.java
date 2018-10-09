//}}}
//{{{ dispose() method
@Override
public void dispose() {
    GUIUtilities.saveGeometry(this, name);
    jEdit.setIntegerProperty(name + ".splitter", splitter.getDividerLocation());
    super.dispose();
}