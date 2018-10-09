//}}}
//{{{ showPopupMenu() method
public void showPopupMenu(String t, int x, int y) {
    if (historyModel == null)
        return;
    text.requestFocus();
    if (popup != null && popup.isVisible()) {
        popup.setVisible(false);
        popup = null;
        return;
    }
    popup = new JPopupMenu() {

        @Override
        public void setVisible(boolean b) {
            if (!b) {
                popup = null;
            }
            super.setVisible(b);
        }
    };
    JMenuItem caption = new JMenuItem(jEdit.getProperty("history.caption"));
    caption.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            new ListModelEditor().open(historyModel);
        }
    });
    popup.add(caption);
    popup.addSeparator();
    for (int i = 0; i < historyModel.getSize(); i++) {
        String item = historyModel.getItem(i);
        if (item.startsWith(t)) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.setActionCommand(String.valueOf(i));
            menuItem.addActionListener(new ActionHandler());
            popup.add(menuItem);
        }
    }
    GenericGUIUtilities.showPopupMenu(popup, text, x, y, false);
}