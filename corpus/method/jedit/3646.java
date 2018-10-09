//}}}
//{{{ Protected members
//{{{ processKeyEvent() method
protected void processKeyEvent(KeyEvent evt) {
    if (!isEnabled())
        return;
    if (evt.getID() == KeyEvent.KEY_PRESSED) {
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (evt.isControlDown()) {
                    replaceSelection("\n");
                    evt.consume();
                }
                break;
            case KeyEvent.VK_TAB:
                if (evt.isControlDown()) {
                    replaceSelection("\t");
                    evt.consume();
                }
                break;
            case KeyEvent.VK_PAGE_UP:
                if (evt.isShiftDown())
                    controller.doBackwardSearch();
                else
                    controller.historyPrevious();
                evt.consume();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                if (evt.isShiftDown())
                    controller.doForwardSearch();
                else
                    controller.historyNext();
                evt.consume();
                break;
            case KeyEvent.VK_UP:
                if (evt.isAltDown()) {
                    controller.showPopupMenu(evt.isShiftDown());
                    evt.consume();
                }
                break;
            case KeyEvent.VK_CONTEXT_MENU:
                controller.showPopupMenu(evt.isShiftDown());
                evt.consume();
                break;
        }
    }
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}