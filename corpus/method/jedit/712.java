//{{{ mouseReleased() method
@Override
public void mouseReleased(MouseEvent evt) {
    if (!GenericGUIUtilities.isPopupTrigger(evt) && table.getSelectedRow() != -1) {
        browser.filesSelected();
    }
//}}}
}