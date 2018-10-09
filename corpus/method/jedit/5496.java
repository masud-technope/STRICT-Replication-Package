//}}}
//{{{ updateButtons() method
/**
	 * Update the preview
	 */
private void updatePreview() {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < listModel.getSize(); i++) {
        if (i != 0)
            buf.append(' ');
        String widgetName = (String) listModel.elementAt(i);
        String sample = jEdit.getProperty("statusbar." + widgetName + ".sample", widgetName);
        buf.append(sample);
    }
    previewStatusBar.setText(buf.toString());
}