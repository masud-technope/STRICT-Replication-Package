//}}}
//{{{ updateUI() method
public void updateUI() {
    super.updateUI();
    //setBorder(originalBorder);
    setBorderPainted(false);
    setRequestFocusEnabled(false);
    setMargin(new Insets(1, 1, 1, 1));
}