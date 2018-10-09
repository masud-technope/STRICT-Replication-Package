public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == okButton) {
        ok();
    } else if (source == cancelButton) {
        cancel();
    }
}