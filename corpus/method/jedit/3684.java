 CheckBoxListModel(Object[] _items) {
    items = new Vector<JCheckBoxList.Entry>(_items.length);
    for (Object _item : _items) {
        items.add(createEntry(_item));
    }
}