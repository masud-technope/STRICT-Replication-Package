//}}}
//{{{ getCheckedValues() method
public Object[] getCheckedValues() {
    List<Object> values = new ArrayList<Object>();
    CheckBoxListModel model = (CheckBoxListModel) getModel();
    for (int i = 0; i < model.items.size(); i++) {
        Entry entry = model.items.get(i);
        if (entry.checked && !entry.caption) {
            values.add(entry.value);
        }
    }
    Object[] retVal = new Object[values.size()];
    return values.toArray(retVal);
}