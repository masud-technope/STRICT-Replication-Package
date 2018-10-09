//}}}
//{{{ loadRegisters() method
public void loadRegisters() {
    if (registersXML == null)
        return;
    if (!registersXML.fileExists())
        return;
    Log.log(Log.MESSAGE, jEdit.class, "Loading " + registersXML);
    RegistersHandler handler = new RegistersHandler();
    try {
        Registers.setLoading(true);
        registersXML.load(handler);
    } catch (IOException ioe) {
        Log.log(Log.ERROR, Registers.class, ioe);
    } finally {
        Registers.setLoading(false);
    }
}