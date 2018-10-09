public void remove(int index) {
    data.remove(index);
    fireContentsChanged(this, index, index);
}