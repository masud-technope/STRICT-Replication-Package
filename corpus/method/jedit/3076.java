//}}}
//{{{ goToActionBar() method
public void goToActionBar() {
    repeatCount = view.getInputHandler().getRepeatCount();
    action.setText(null);
    action.requestFocus();
}