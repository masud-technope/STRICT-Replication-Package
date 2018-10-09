public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == global) {
        String _abbrev = editor.getAbbrev();
        if (_abbrev == null || _abbrev.length() == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        Abbrevs.addGlobalAbbrev(_abbrev, editor.getExpansion());
        Abbrevs.expandAbbrev(view, false);
    } else if (source == modeSpecific) {
        String _abbrev = editor.getAbbrev();
        if (_abbrev == null || _abbrev.length() == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        Abbrevs.addModeAbbrev(view.getBuffer().getMode().getName(), _abbrev, editor.getExpansion());
        Abbrevs.expandAbbrev(view, false);
    }
    dispose();
}