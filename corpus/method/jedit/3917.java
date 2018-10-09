public void addAll(Collection<E> newData) {
    int i = data.size();
    data.addAll(newData);
    fireIntervalAdded(this, i, i + newData.size() - 1);
}