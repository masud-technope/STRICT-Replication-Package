//{{{ dispose() method
@Override
public void dispose() {
    GUIUtilities.saveGeometry(this, "status.errorWidget");
    super.dispose();
//}}}
}