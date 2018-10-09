//{{{ Static part
//{{{ getDisplayManager() method
static DisplayManager getDisplayManager(JEditBuffer buffer, TextArea textArea) {
    List<DisplayManager> l = bufferMap.get(buffer);
    if (l == null) {
        l = new LinkedList<DisplayManager>();
        bufferMap.put(buffer, l);
    }
    /* An existing display manager's fold visibility map
		that a new display manager will inherit */
    DisplayManager copy = null;
    Iterator<DisplayManager> liter = l.iterator();
    DisplayManager dmgr;
    while (liter.hasNext()) {
        dmgr = liter.next();
        copy = dmgr;
        if (!dmgr.inUse && dmgr.textArea == textArea) {
            dmgr.inUse = true;
            return dmgr;
        }
    }
    // if we got here, no unused display manager in list
    dmgr = new DisplayManager(buffer, textArea, copy);
    dmgr.inUse = true;
    l.add(dmgr);
    return dmgr;
}