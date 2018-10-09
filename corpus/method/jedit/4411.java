@Override
public void keyPressed(KeyEvent ke) {
    switch(ke.getKeyCode()) {
        case KeyEvent.VK_UP:
            JScrollBar scrollBar = viewerScrollPane.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getValue() - scrollBar.getUnitIncrement(-1));
            ke.consume();
            break;
        case KeyEvent.VK_DOWN:
            scrollBar = viewerScrollPane.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getValue() + scrollBar.getUnitIncrement(1));
            ke.consume();
            break;
        case KeyEvent.VK_LEFT:
            scrollBar = viewerScrollPane.getHorizontalScrollBar();
            scrollBar.setValue(scrollBar.getValue() - scrollBar.getUnitIncrement(-1));
            ke.consume();
            break;
        case KeyEvent.VK_RIGHT:
            scrollBar = viewerScrollPane.getHorizontalScrollBar();
            scrollBar.setValue(scrollBar.getValue() + scrollBar.getUnitIncrement(1));
            ke.consume();
            break;
        case KeyEvent.VK_HOME:
            scrollBar = viewerScrollPane.getHorizontalScrollBar();
            scrollBar.setValue(0);
            scrollBar = viewerScrollPane.getVerticalScrollBar();
            scrollBar.setValue(0);
            ke.consume();
            break;
        case KeyEvent.VK_END:
            scrollBar = viewerScrollPane.getHorizontalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());
            scrollBar = viewerScrollPane.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());
            ke.consume();
            break;
    }
}