//}}}
//{{{ textAreaDisposed() method
static void textAreaDisposed(TextArea textArea) {
    for (List<DisplayManager> l : bufferMap.values()) {
        Iterator<DisplayManager> liter = l.iterator();
        while (liter.hasNext()) {
            DisplayManager dmgr = liter.next();
            if (dmgr.textArea == textArea) {
                dmgr.dispose();
                liter.remove();
            }
        }
    }
}