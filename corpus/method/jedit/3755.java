 LogList(ListModel<String> model) {
    super(model);
    setVisibleRowCount(24);
    getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    setAutoscrolls(true);
}