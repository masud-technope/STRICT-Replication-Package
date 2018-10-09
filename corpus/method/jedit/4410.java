@Override
public void propertyChange(PropertyChangeEvent evt) {
    if ("page".equals(evt.getPropertyName())) {
        String titleStr = (String) viewer.getDocument().getProperty("title");
        if (titleStr == null) {
            titleStr = MiscUtilities.getFileName(viewer.getPage().toString());
        }
        title.setText(titleStr);
        historyModel.updateTitle(viewer.getPage().toString(), titleStr);
    }
}