@Override
public void keyTyped(KeyEvent e) {
    if (b1 != null)
        match1 = match(e, b1, match1);
    if (b2 != null)
        match2 = match(e, b2, match2);
    if ((match1 > 0 && b1 != null && match1 == b1.size()) || (match2 > 0 && b2 != null && match2 == b2.size())) {
        hideDockableWindow(name);
        match1 = match2 = 0;
    }
}