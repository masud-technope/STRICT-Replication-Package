// make the print preview be no larger than the view size
@Override
public Dimension getPreferredSize() {
    return getPaperSize();
}