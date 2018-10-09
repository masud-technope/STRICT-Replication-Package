// }}}
// {{{ actionPerformed()
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == ok) {
        ok();
    } else if (source == cancel) {
        cancel();
    } else if (source == apply) {
        ok(false);
    }
}