//}}}
//{{{ initMisc() method
/**
	 * Initialise various objects, register protocol handlers.
	 */
private static void initMisc() {
    ModeProvider.instance = new ModeProvider() {

        @Override
        protected void error(String fileName, Throwable e) {
            Log.log(Log.ERROR, this, e);
            if (e instanceof SAXParseException) {
                String message = e.getMessage();
                int line = ((SAXParseException) e).getLineNumber();
                int col = ((SAXParseException) e).getColumnNumber();
                Object[] args = { fileName, line, col, message };
                GUIUtilities.error(null, "xmode-error", args);
            }
        }
    };
    jars = new Vector<PluginJAR>();
    FoldHandler.foldHandlerProvider = new ServiceManager.ServiceFoldHandlerProvider();
    actionContext = new ActionContext() {

        @Override
        public void invokeAction(EventObject evt, EditAction action) {
            View view = GUIUtilities.getView((Component) evt.getSource());
            boolean actionBarVisible;
            if (view.getActionBar() == null || !view.getActionBar().isShowing())
                actionBarVisible = false;
            else {
                actionBarVisible = view.getActionBar().isVisible();
            }
            view.getInputHandler().invokeAction(action);
            if (actionBarVisible) {
                // XXX: action bar might not be 'temp'
                ActionBar actionBar = view.getActionBar();
                if (actionBar != null)
                    view.removeToolBar(actionBar);
            }
        }
    };
    bufferHash = new HashMap<String, Buffer>();
    File userKeymapFolder = null;
    if (settingsDirectory != null) {
        userKeymapFolder = new File(settingsDirectory, "keymaps");
    }
    inputHandler = new DefaultInputHandler(null);
    // Add our protocols to java.net.URL's list
    System.getProperties().put("java.protocol.handler.pkgs", "org.gjt.sp.jedit.proto|" + System.getProperty("java.protocol.handler.pkgs", ""));
    // Set the User-Agent string used by the java.net HTTP handler
    String userAgent = "jEdit/" + getVersion() + " (Java " + System.getProperty("java.version") + ". " + System.getProperty("java.vendor") + "; " + System.getProperty("os.arch") + ')';
    System.getProperties().put("http.agent", userAgent);
    /* Determine installation directory.
		 * If the jedit.home property is set, use that.
		 * Then, look for jedit.jar in the classpath.
		 * If that fails, assume this is the web start version. */
    jEditHome = System.getProperty("jedit.home");
    if (jEditHome == null) {
        String classpath = System.getProperty("java.class.path");
        int index = classpath.toLowerCase().indexOf("jedit.jar");
        int start = classpath.lastIndexOf(File.pathSeparator, index) + 1;
        // if started with java -jar jedit.jar
        if (start == index) {
            jEditHome = System.getProperty("user.dir");
        } else if (index > start) {
            jEditHome = classpath.substring(start, index - 1);
        } else {
            // check if web start
            /* if(jEdit.class.getResource("/modes/catalog") != null)
				{
					// modes bundled in; hence web start
					jEditHome = null;
				}
				else */
            {
                // use user.dir as last resort
                jEditHome = System.getProperty("user.dir");
                Log.log(Log.WARNING, jEdit.class, "jedit.jar not in class path!");
                Log.log(Log.WARNING, jEdit.class, "Assuming jEdit is installed in " + jEditHome + '.');
                Log.log(Log.WARNING, jEdit.class, "Override with jedit.home " + "system property.");
            }
        }
    }
    jEditHome = MiscUtilities.resolveSymlinks(jEditHome);
    Log.log(Log.MESSAGE, jEdit.class, "jEdit home directory is " + jEditHome);
    keymapManager = new KeymapManagerImpl(propertyManager, new File(jEditHome, "keymaps"), userKeymapFolder);
    if (settingsDirectory != null) {
        jarCacheDirectory = MiscUtilities.constructPath(settingsDirectory, "jars-cache");
        new File(jarCacheDirectory).mkdirs();
    }
    //if(jEditHome == null)
    //	Log.log(Log.DEBUG,jEdit.class,"Web start mode");
    // Add an EditBus component that will reload edit modes and
    // macros if they are changed from within the editor
    EditBus.addToBus(new SettingsReloader());
    // Set the ContextClassLoader for the main jEdit thread.
    // This way, the ContextClassLoader will be a JARClassLoader
    // even at plugin activation and the EventQueue can also pick
    // up the JARClassLoader. That's why this call has to be done
    // before the usage of the EventQueue.
    Thread.currentThread().setContextClassLoader(new JARClassLoader());
    // Perhaps if Xerces wasn't slightly brain-damaged, we would
    // not need this
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            Thread.currentThread().setContextClassLoader(new JARClassLoader());
        }
    });
}