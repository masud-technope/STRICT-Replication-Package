//}}}
//{{{ handleClient() method
private boolean handleClient(final Socket client, DataInputStream in) throws Exception {
    int key = in.readInt();
    if (key != authKey) {
        Log.log(Log.ERROR, this, client + ": wrong" + " authorization key (got " + key + ", expected " + authKey + ")");
        in.close();
        client.close();
        return false;
    } else {
        // Reset the timeout
        client.setSoTimeout(0);
        Log.log(Log.DEBUG, this, client + ": authenticated" + " successfully");
        final String script = in.readUTF();
        Log.log(Log.DEBUG, this, script);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    NameSpace ns = new NameSpace(BeanShell.getNameSpace(), "EditServer namespace");
                    ns.setVariable("socket", client);
                    BeanShell.eval(null, ns, script);
                } catch (org.gjt.sp.jedit.bsh.UtilEvalError e) {
                    Log.log(Log.ERROR, this, e);
                } finally {
                    try {
                        BeanShell.getNameSpace().setVariable("socket", null);
                    } catch (org.gjt.sp.jedit.bsh.UtilEvalError e) {
                        Log.log(Log.ERROR, this, e);
                    }
                }
            }
        });
        return true;
    }
}