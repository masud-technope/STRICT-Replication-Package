public void perform(String installDir, Vector filesets) throws IOException {
    if (!enabled) {
        return;
    }
    mkdirs(directory);
    // create app start script
    String name = installer.getProperty("app.name");
    String script = directory + File.separatorChar + name.toLowerCase();
    // Delete existing copy
    new File(script).delete();
    // Write simple script
    FileWriter out = new FileWriter(script);
    out.write("#!/bin/sh\n");
    out.write("#\n");
    out.write("# Runs jEdit - Programmer's Text Editor.\n");
    out.write("#\n");
    out.write("\n");
    out.write("# Find a java installation.\n");
    out.write("if [ -z \"${JAVA_HOME}\" ]; then\n");
    out.write("	echo 'Warning: $JAVA_HOME environment variable not set! Consider setting it.'\n");
    out.write("	echo '         Attempting to locate java...'\n");
    out.write("	j=`which java 2>/dev/null`\n");
    out.write("	if [ -z \"$j\" ]; then\n");
    out.write("		echo \"Failed to locate the java virtual machine! Bailing...\"\n");
    out.write("		exit 1\n");
    out.write("	else\n");
    out.write("		echo \"Found a virtual machine at: $j...\"\n");
    out.write("		JAVA=\"$j\"\n");
    out.write("	fi\n");
    out.write("else\n");
    out.write("	JAVA=\"${JAVA_HOME}/bin/java\"\n");
    out.write("fi\n");
    out.write("\n");
    out.write("# Launch application.\n");
    out.write("\n");
    out.write("exec \"${JAVA}\" -Dawt.useSystemAAFontSettings=on -Dswing.aatext=true -jar \"" + installDir + File.separator + "jedit.jar\" -reuseview \"$@\"\n");
    out.close();
    // Make it executable
    String[] chmodArgs = { "chmod", "755", script };
    exec(chmodArgs);
}