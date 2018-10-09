public void clear() {
    if (data.isEmpty())
        return;
    int i = data.size();
    data.clear();
    fireIntervalRemoved(this, 0, i - 1);
}