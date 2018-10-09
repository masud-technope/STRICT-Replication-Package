private  MyTransferable(E[] data) {
    this.data = Arrays.copyOf(data, data.length);
}