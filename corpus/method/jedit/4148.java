@Override
public void mouseClicked(MouseEvent evt) {
    Object source = evt.getSource();
    if (source == caretStatus && evt.getClickCount() == 2) {
        view.getTextArea().showGoToLineDialog();
    }
}