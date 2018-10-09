public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == insert)
        ok();
    else if (source == cancel)
        cancel();
}