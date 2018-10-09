public final void print(Object o) {
    if (console != null) {
        console.print(o);
    } else {
        out.print(o);
        out.flush();
    }
}