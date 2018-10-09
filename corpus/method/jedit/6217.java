@Override
public void keyPressed(KeyEvent evt) {
    switch(evt.getKeyCode()) {
        case KeyEvent.VK_SPACE:
            goToSelectedNode(M_OPEN);
            // fuck me dead
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    resultTree.requestFocus();
                }
            });
            evt.consume();
            break;
        case KeyEvent.VK_ENTER:
            goToSelectedNode(M_OPEN);
            evt.consume();
            break;
        case KeyEvent.VK_DELETE:
            removeSelectedNode();
            evt.consume();
            break;
        default:
            break;
    }
}