//}}}
//{{{ paint() method
public void paint(Graphics g) {
    if (isEnabled())
        super.paint(g);
    else {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(c);
        super.paint(g2);
    }
}