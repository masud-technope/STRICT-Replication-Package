private  TaskMonitorWidget(final View view) {
    setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
    setFont(getFont().deriveFont(Font.BOLD));
    String property = jEdit.getProperty("statusbar.task-monitor.template");
    args = new Object[1];
    messageFormat = new MessageFormat(property);
    fieldPosition = new FieldPosition(0);
    addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                view.getDockableWindowManager().showDockableWindow("task-monitor");
            }
        }
    });
    stringBuffer = new StringBuffer();
}