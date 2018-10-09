//}}}
//{{{ init() method
@Override
public final void init() {
    if (!initialized) {
        initialized = true;
        _init();
    }
}