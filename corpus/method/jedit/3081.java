public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == close)
        view.removeToolBar(ActionBar.this);
    else
        invoke();
}