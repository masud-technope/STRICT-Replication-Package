// for the cast
@SuppressWarnings({ "unchecked" })
private  MyTransferable(List<E> data) {
    this.data = (E[]) data.toArray();
}