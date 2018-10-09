//}}}
//{{{ showPopupMenu() method
public void showPopupMenu(boolean search) {
    if (search)
        showPopupMenu(getText().substring(getInputStart(), text.getSelectionStart()), 0, text.getHeight());
    else
        showPopupMenu("", 0, text.getHeight());
}