//}}}
//{{{ startDocument() method
@Override
public void startDocument() {
    try {
        pushElement(null);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    }
}