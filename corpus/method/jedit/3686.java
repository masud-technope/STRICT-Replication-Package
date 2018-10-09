 CheckBoxListModel(Vector _items) {
    items = new Vector<JCheckBoxList.Entry>(_items.size());
    for (int i = 0; i < _items.size(); i++) {
        items.add(createEntry(_items.elementAt(i)));
    }
}