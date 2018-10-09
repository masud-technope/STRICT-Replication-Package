//}}}
//{{{ searchStarted() method
public void searchStarted() {
    stop.setEnabled(true);
    caption.setText(jEdit.getProperty("hypersearch-results.searching", new String[] { trimSearchString() }));
}