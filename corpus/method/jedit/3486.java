//}}}
//{{{ cancel() method
@Override
public void cancel() {
    GUIUtilities.saveGeometry(this, "propdialog");
    setVisible(false);
}