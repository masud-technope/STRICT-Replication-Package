//{{{ HistoryTextArea constructor
public  HistoryTextArea(String name) {
    super(3, 15);
    controller = new HistoryText(this, name);
    setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.singleton(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0)));
    setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.singleton(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK)));
}