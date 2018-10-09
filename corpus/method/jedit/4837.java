//}}}
//{{{ makeServerScript() method
/**
	 * Creates a BeanShell script that can be sent to a running edit server.
	 */
private static String makeServerScript(boolean wait, boolean restore, boolean newView, boolean newPlainView, String[] args, String scriptFile) {
    StringBuilder script = new StringBuilder();
    String userDir = System.getProperty("user.dir");
    script.append("parent = \"");
    script.append(StandardUtilities.charsToEscapes(userDir));
    script.append("\";\n");
    script.append("args = new String[");
    script.append(args.length);
    script.append("];\n");
    for (int i = 0; i < args.length; i++) {
        script.append("args[");
        script.append(i);
        script.append("] = ");
        if (args[i] == null)
            script.append("null");
        else {
            script.append('"');
            script.append(StandardUtilities.charsToEscapes(args[i]));
            script.append('"');
        }
        script.append(";\n");
    }
    script.append("view = jEdit.getLastView();\n");
    script.append("buffer = EditServer.handleClient(");
    script.append(restore).append(',').append(newView).append(',').append(newPlainView);
    script.append(",parent,args);\n");
    script.append("if(buffer != null && ").append(wait).append(") {\n");
    script.append("\tbuffer.setWaitSocket(socket);\n");
    script.append("\tdoNotCloseSocket = true;\n");
    script.append("}\n");
    script.append("if(view != jEdit.getLastView() && ").append(wait).append(") {\n");
    script.append("\tjEdit.getLastView().setWaitSocket(socket);\n");
    script.append("\tdoNotCloseSocket = true;\n");
    script.append("}\n");
    script.append("if(doNotCloseSocket == void)\n");
    script.append("\tsocket.close();\n");
    if (scriptFile != null) {
        scriptFile = MiscUtilities.constructPath(userDir, scriptFile);
        script.append("BeanShell.runScript(view,\"").append(StandardUtilities.charsToEscapes(scriptFile)).append("\",null,this.namespace);\n");
    }
    return script.toString();
}