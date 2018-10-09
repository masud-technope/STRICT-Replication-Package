public AttributeSet getAttributes() {
    AttributeSet as = new HashAttributeSet();
    if (sides.isEnabled()) {
        as.add((Sides) sides.getSelectedItem());
    }
    if (pagesPerSide.isEnabled()) {
        as.add((NumberUp) pagesPerSide.getSelectedItem());
    }
    if (pageOrdering.isEnabled()) {
        as.add((PresentationDirection) pageOrdering.getSelectedItem());
    }
    onlyPrintPages = onlyPrint.getSelectedIndex();
    if (paperSource.isEnabled()) {
        as.add((MediaTray) paperSource.getSelectedItem());
    }
    if (paperSize.isEnabled()) {
        as.add(paperSizes.get(paperSize.getSelectedIndex()));
    }
    if (orientation.isEnabled()) {
        as.add((OrientationRequested) orientation.getSelectedItem());
    }
    Number topMargin = topMarginField.getValue();
    Number leftMargin = leftMarginField.getValue();
    Number rightMargin = rightMarginField.getValue();
    Number bottomMargin = bottomMarginField.getValue();
    Margins margins = new Margins(topMargin.floatValue(), leftMargin.floatValue(), rightMargin.floatValue(), bottomMargin.floatValue());
    as.add(margins);
    jEdit.setProperty("print.topMargin", topMargin.toString());
    jEdit.setProperty("print.leftMargin", leftMargin.toString());
    jEdit.setProperty("print.rightMargin", rightMargin.toString());
    jEdit.setProperty("print.bottomMargin", bottomMargin.toString());
    return as;
}