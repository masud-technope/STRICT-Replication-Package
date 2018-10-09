public void actionPerformed(ActionEvent evt) {
    updateMirrors.setEnabled(false);
    updateStatus.setText(jEdit.getProperty("options.plugin-manager.workthread"));
    ThreadUtilities.runInBackground(new UpdateMirrorsThread(true));
}