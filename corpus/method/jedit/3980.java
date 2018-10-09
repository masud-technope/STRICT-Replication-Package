//}}}
//{{{ paintComponent() method
@Override
public synchronized void paintComponent(Graphics g) {
    Dimension size = getSize();
    g.drawImage(image, 1, 1, this);
    doPaintContents(g, size);
    // for the wait() inside advance(...)
    notify();
}