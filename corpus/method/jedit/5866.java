public void paintComponent(Graphics gfx) {
    PrintPreviewModel model = printPreviewPane.getModel();
    if (model == null) {
        return;
    }
    super.paintComponent(gfx);
    Dimension currentSize = getPaperSize();
    double width = currentSize.getWidth();
    double height = currentSize.getHeight();
    // paint background white
    gfx.setColor(Color.WHITE);
    gfx.fillRect(0, 0, Double.valueOf(width).intValue(), Double.valueOf(height).intValue());
    // print the page into this panel
    updateModel();
    model.setGraphics(gfx);
    BufferPrinter1_7.printPage(model);
    scrollPane.revalidate();
    printPreviewPane.revalidate();
    printPreviewPane.repaint();
}