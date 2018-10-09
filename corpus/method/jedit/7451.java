//}}}
//{{{ setMainContent() method
private void setMainContent(Component c) {
    if (mainContent != null)
        mainPanel.remove(mainContent);
    mainContent = c;
    mainPanel.add(mainContent, BorderLayout.CENTER);
    if (c instanceof JSplitPane) {
        splitPane = (JSplitPane) c;
    } else {
        splitPane = null;
        editPane = (EditPane) c;
    }
    mainPanel.revalidate();
    mainPanel.repaint();
}