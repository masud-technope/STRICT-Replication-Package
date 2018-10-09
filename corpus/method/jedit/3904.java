public void setRightData(List<E> data) {
    rightModel = new MyListModel<E>(data);
    right.setModel(rightModel);
}