@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == newViewItem) {
        jEdit.newView(null);
    } else if (e.getSource() == newPlainViewItem) {
        jEdit.newView(null, null, true);
    } else if (e.getSource() == exitItem) {
        jEdit.exit(null, true);
    }
}