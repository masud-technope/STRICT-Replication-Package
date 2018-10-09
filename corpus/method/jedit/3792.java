public void setItem(Object item) {
    if (item == null)
        setText("");
    else
        setText(item.toString());
}