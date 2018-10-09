// }}}
// {{ setData methods
public void setLeftData(List<E> data) {
    leftModel = new MyListModel<E>(data);
    left.setModel(leftModel);
}