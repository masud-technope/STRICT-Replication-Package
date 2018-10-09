public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == selectAll)
        selectAll();
    else if (source == reload)
        action("RELOAD");
    else if (source == close)
        dispose();
    else if (source == ignore)
        action("IGNORE");
}