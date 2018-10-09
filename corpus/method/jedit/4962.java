//}}}
//{{{ load() method
@Override
public void load() {
    if (killringXML == null)
        return;
    if (!killringXML.fileExists())
        return;
    Log.log(Log.MESSAGE, KillRing.class, "Loading " + killringXML);
    KillRingHandler handler = new KillRingHandler();
    try {
        killringXML.load(handler);
    } catch (OutOfMemoryError oem) {
        Log.log(Log.ERROR, this, "Unable to load entire Killring, too low memory, increase your jvm max heap size");
        String start = jEdit.getProperty("killring.start");
        String deleteKillRing = jEdit.getProperty("killring.delete");
        String stop = jEdit.getProperty("killring.stop");
        int selected = GUIUtilities.option(null, "killring.load-memoryerror", null, JOptionPane.ERROR_MESSAGE, new Object[] { start, deleteKillRing, stop }, start);
        if (selected == 2) {
            System.exit(-1);
        } else if (selected == 1) {
            new File(MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "killring.xml")).delete();
            return;
        }
    } catch (IOException ioe) {
        Log.log(Log.ERROR, this, ioe);
    }
    reset(handler.list);
}