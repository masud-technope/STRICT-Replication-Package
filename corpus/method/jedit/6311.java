@Override
public void focusLost(FocusEvent e) {
    getField().addCurrentToHistory();
}