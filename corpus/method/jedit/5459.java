public void sort(int col) {
    Collections.sort(bindings, new KeyCompare(col));
}