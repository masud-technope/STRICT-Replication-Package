@Override
public void mousePressed(MouseEvent evt) {
    if (evt.getClickCount() == 2) {
        jEdit.showMemoryDialog(view);
        repaint();
    }
}