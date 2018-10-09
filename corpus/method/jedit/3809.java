//}}}
//{{{ updateSize() method
private void updateSize() {
    Dimension currentSize = getSize();
    Dimension requestedSize = getPreferredSize();
    Dimension newSize = new Dimension(Math.max(currentSize.width, requestedSize.width), Math.max(currentSize.height, requestedSize.height));
    if (newSize.width < 300)
        newSize.width = 300;
    if (newSize.height < 200)
        newSize.height = 200;
    setSize(newSize);
    validate();
}