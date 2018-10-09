//{{{ mouseEntered() method
public void mouseEntered(MouseEvent e) {
    ToolTipManager ttm = ToolTipManager.sharedInstance();
    toolTipInitialDelay = ttm.getInitialDelay();
    toolTipReshowDelay = ttm.getReshowDelay();
    ttm.setInitialDelay(0);
    ttm.setReshowDelay(0);
//}}}
}