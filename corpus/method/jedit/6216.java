//{{{ mousePressed() method
@Override
public void mousePressed(MouseEvent evt) {
    if (evt.isConsumed())
        return;
    TreePath path1 = resultTree.getPathForLocation(evt.getX(), evt.getY());
    if (path1 == null)
        return;
    resultTree.setSelectionPath(path1);
    if (GenericGUIUtilities.isPopupTrigger(evt))
        showPopupMenu(evt);
    else {
        goToSelectedNode(M_OPEN);
    }
//}}}
}