//}}}
//{{{ getValues() method
public Entry[] getValues() {
    CheckBoxListModel model = (CheckBoxListModel) getModel();
    Entry[] retVal = new Entry[model.items.size()];
    model.items.copyInto(retVal);
    return retVal;
}