public boolean verify(JComponent input) {
    if (input instanceof JTextComponent) {
        String dir = ((JTextComponent) input).getText();
        if (checkNull(dir) && checkExistNotDirectory(dir) && checkExistNotEmpty(dir) && checkRelative(dir)) {
            //everything is perfect, clean label
            if (message.getParent() != null) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        parent.remove(message);
                        parent.revalidate();
                        parent.repaint();
                    }
                });
            }
        } else {
            if (message.getParent() == null) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        parent.add(message, pos);
                        parent.revalidate();
                        parent.repaint();
                    }
                });
            } else
                message.repaint();
        }
    }
    return true;
}