//}}}
//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    String cmd = evt.getActionCommand();
    if (cmd.equals("clear"))
        view.getBuffer().removeAllMarkers();
    else if (cmd.equals("add-marker"))
        view.getEditPane().addMarker();
    else if (cmd.equals("next-marker")) {
        view.getEditPane().goToNextMarker(false);
        updateSelection();
    } else if (cmd.equals("prev-marker")) {
        view.getEditPane().goToPrevMarker(false);
        updateSelection();
    }
}