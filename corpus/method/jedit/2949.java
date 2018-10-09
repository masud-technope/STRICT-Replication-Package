//{{{ dispatch() method
private static void dispatch(EBMessageHandler emh, EBMessage msg) throws Exception {
    if (emh.handler != null && emh.comp != null)
        emh.handler.invoke(emh.comp, msg);
    else {
        assert (emh.comp instanceof EBComponent);
        ((EBComponent) emh.comp).handleMessage(msg);
    }
}