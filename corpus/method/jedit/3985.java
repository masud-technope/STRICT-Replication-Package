//}}}
//{{{ dispose() method
public void dispose() {
    if (realSplash == null) {
        win.dispose();
    } else {
        if (realSplash.isVisible()) {
            realSplash.close();
        }
    }
}