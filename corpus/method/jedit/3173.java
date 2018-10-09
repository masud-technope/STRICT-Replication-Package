//}}}
//{{{ reset() method
/**
	 * Start completion.
	 * @param candidates The candidates of this completion
	 * @param active Set focus to the popup
	 */
public void reset(Candidates candidates, boolean active) {
    if (candidates == null || !candidates.isValid() || candidates.getSize() <= 0) {
        dispose();
        return;
    }
    this.candidates = candidates;
    list.setModel(new CandidateListModel());
    list.setVisibleRowCount(Math.min(candidates.getSize(), 8));
    pack();
    setLocation(fitInScreen(getLocation(null), this, view.getTextArea().getPainter().getLineHeight()));
    if (active) {
        setSelectedIndex(0);
        GenericGUIUtilities.requestFocus(this, list);
    }
    setVisible(true);
    view.setKeyEventInterceptor(keyHandler);
}