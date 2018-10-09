public void actionPerformed(ActionEvent evt) {
    File directory = new File(field.getText());
    JFileChooser chooser = new JFileChooser(directory.getParent());
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setSelectedFile(directory);
    if (chooser.showOpenDialog(SwingInstall.this) == JFileChooser.APPROVE_OPTION) {
        field.setText(chooser.getSelectedFile().getPath());
        field.getInputVerifier().verify(field);
    }
}