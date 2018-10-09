public void add(int pos, E[] addedDatas) {
    for (int i = addedDatas.length - 1; i >= 0; i--) data.add(pos, addedDatas[i]);
    fireContentsChanged(this, pos, pos + addedDatas.length - 1);
}