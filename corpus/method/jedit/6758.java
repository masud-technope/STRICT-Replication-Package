//}}}
//{{{ changed() method
@Override
public void changed() {
    //{{{ Debug code
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "changed() before: " + getPhysicalLine() + ':' + getScrollLine() + ':' + getSkew());
    //}}}
    }
    if (Debug.SCROLL_VERIFY)
        scrollVerify();
    ensurePhysicalLineIsVisible();
    int currentPhysicalLine = getPhysicalLine();
    int screenLines = getDisplayManager().getScreenLineCount(currentPhysicalLine);
    if (getSkew() >= screenLines)
        setSkew(screenLines - 1);
    //{{{ Debug code
    if (Debug.SCROLL_VERIFY)
        scrollVerify();
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "changed() after: " + getPhysicalLine() + ':' + getScrollLine() + ':' + getSkew());
    //}}}
    }
}