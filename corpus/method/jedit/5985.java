private void init() {
    pageRanges = BufferPrinter1_7.getPageRanges(view, buffer, attributes);
    DefaultComboBoxModel<Integer> pagesModel = new DefaultComboBoxModel<Integer>();
    boolean reverse = attributes.containsKey(Reverse.class);
    StringBuilder pr = new StringBuilder();
    for (Integer i : pageRanges.keySet()) {
        Integer pageNo = reverse ? pageRanges.size() - i + 1 : i;
        pagesModel.addElement(pageNo);
        //Log.log(Log.DEBUG, this, "init, i = " + i + ", range = " + pageRanges.get(i));
        pr.append(i).append(',');
    }
    pr.deleteCharAt(pr.length() - 1);
    pages.setModel(pagesModel);
    pages.setSelectedIndex(0);
    nextPage.setEnabled(pagesModel.getSize() > 1);
    prevPage.setEnabled(pagesModel.getSize() > 1);
    model = new PrintPreviewModel(view, buffer, printService, attributes, pageRanges);
    int firstPage = (Integer) pages.getSelectedItem();
    model.setPageNumber(firstPage - 1);
    model.setPageRanges(pageRanges);
    model.setZoomLevel(zoomLevel);
    attributes.add(new PageRanges(firstPage));
    printPreviewPane.setModel(model);
}