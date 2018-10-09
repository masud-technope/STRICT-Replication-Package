public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == ok) {
        if (editor.getAbbrev() == null || editor.getAbbrev().length() == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        if (!checkForExistingAbbrev())
            return;
        isOK = true;
    }
    dispose();
}