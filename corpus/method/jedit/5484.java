//{{{ setSelectedItem() method
@Override
public void setSelectedItem(Object anItem) {
    if (isValidName(anItem))
        selectedItem = anItem;
    else
        selectedItem = keymaps[0];
//}}}
}