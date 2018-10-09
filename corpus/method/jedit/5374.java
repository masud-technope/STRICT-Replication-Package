public void actionPerformed(ActionEvent evt) {
    httpHost.setEnabled(httpEnabled.isSelected());
    httpPort.setEnabled(httpEnabled.isSelected());
    httpUser.setEnabled(httpEnabled.isSelected());
    httpPass.setEnabled(httpEnabled.isSelected());
    httpNonProxy.setEnabled(httpEnabled.isSelected());
    socksHost.setEnabled(socksEnabled.isSelected());
    socksPort.setEnabled(socksEnabled.isSelected());
}