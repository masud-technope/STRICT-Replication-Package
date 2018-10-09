//{{{ finalize() method
// TODO: 'finalize' is deprecated as of Java 9
@SuppressWarnings("deprecation")
@Override
protected void finalize() {
    synchronized (PositionManager.this) {
        bh.unref();
    }
//}}}
}