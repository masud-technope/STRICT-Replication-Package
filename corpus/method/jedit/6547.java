//{{{ intern() method
public LineContext intern() {
    WeakReference<LineContext> ref = intern.get(this);
    if (ref != null) {
        LineContext obj = ref.get();
        if (obj != null) {
            return obj;
        }
    }
    intern.put(this, new WeakReference<LineContext>(this));
    return this;
//}}}
}