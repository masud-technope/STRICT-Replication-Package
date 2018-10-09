//}}}
//{{{ saveRegisters() method
public void saveRegisters() {
    if (registersXML == null)
        return;
    if (registersXML.hasChangedOnDisk()) {
        Log.log(Log.WARNING, Registers.class, registersXML + " changed on disk; will not save registers");
        return;
    }
    Log.log(Log.MESSAGE, Registers.class, "Saving " + registersXML);
    String lineSep = System.getProperty("line.separator");
    SettingsXML.Saver out = null;
    try {
        out = registersXML.openSaver();
        out.writeXMLDeclaration();
        out.write("<!DOCTYPE REGISTERS SYSTEM \"registers.dtd\">");
        out.write(lineSep);
        out.write("<REGISTERS>");
        out.write(lineSep);
        Registers.Register[] registers = Registers.getRegisters();
        for (int i = 0; i < registers.length; i++) {
            Registers.Register register = registers[i];
            if (register == null || i == '$' || i == '%' || register.toString().length() == 0)
                continue;
            out.write("<REGISTER NAME=\"");
            if (i == '"')
                out.write("&quot;");
            else
                out.write((char) i);
            out.write("\">");
            out.write(XMLUtilities.charsToEntities(register.toString(), false));
            out.write("</REGISTER>");
            out.write(lineSep);
        }
        out.write("</REGISTERS>");
        out.write(lineSep);
        out.finish();
    } catch (Exception e) {
        Log.log(Log.ERROR, Registers.class, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}