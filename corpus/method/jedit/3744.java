//{{{ setFilter() method
private void setFilter() {
    String toFilter = filter.getText();
    listModel.setFilter(toFilter.length() == 0 ? " " : toFilter);
    scrollLaterIfRequired();
}