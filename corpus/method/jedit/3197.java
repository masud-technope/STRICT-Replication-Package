@Override
public void mouseClicked(MouseEvent e) {
    if (doSelectedCompletion()) {
        e.consume();
    } else {
        dispose();
    }
}