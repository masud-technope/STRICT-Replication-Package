public  JEditTransferable(Map<DataFlavor, Transferable> flavors) {
    this.flavors = flavors;
    dataFlavors = flavors.keySet().toArray(new DataFlavor[flavors.size()]);
}