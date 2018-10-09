public AttributeSet getAttributes() {
    jEdit.setProperty("print.lastUsedPrinter", printers.getSelectedValue().getName());
    AttributeSet as = new HashAttributeSet();
    if (allPages.isSelected()) {
        as.add(new PageRanges(1, 1000));
        as.add(PrintRangeType.ALL);
    } else if (pages.isSelected()) {
        String pageRange = pagesField.getText();
        if (pageRange != null) {
            try {
                as.add(new PageRanges(pageRange));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        as.add(PrintRangeType.RANGE);
    } else if (currentPage.isSelected()) {
        PrinterDialog.this.attributes.add(new PageRanges(1, 1000));
        HashMap<Integer, Range> currentPageRange = BufferPrinter1_7.getCurrentPageRange(view, view.getBuffer(), PrinterDialog.this.attributes);
        int page = 1;
        if (currentPageRange != null && !currentPageRange.isEmpty()) {
            page = currentPageRange.keySet().iterator().next();
        }
        as.add(new PageRanges(page));
        as.add(PrintRangeType.CURRENT_PAGE);
    } else if (selection.isSelected()) {
        PrinterDialog.this.attributes.add(new PageRanges(1, 1000));
        as.add(PrintRangeType.SELECTION);
    }
    if (collate.isSelected()) {
        as.add(SheetCollate.COLLATED);
    }
    as.add(new Copies((Integer) copies.getValue()));
    if (reverse.isSelected()) {
        as.add(new Reverse());
    } else {
        attributes.remove(Reverse.class);
    }
    return as;
}