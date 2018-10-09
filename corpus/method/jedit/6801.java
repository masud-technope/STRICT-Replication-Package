//{{{ mouseExited() method
public void mouseExited(MouseEvent evt) {
    ToolTipManager ttm = ToolTipManager.sharedInstance();
    ttm.setInitialDelay(toolTipInitialDelay);
    ttm.setReshowDelay(toolTipReshowDelay);
//}}}
}