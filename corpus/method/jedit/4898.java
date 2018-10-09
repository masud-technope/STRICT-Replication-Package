//}}}
//{{{ finishStartup() method
private static void finishStartup(final boolean gui, final boolean restore, final boolean newPlainView, final String userDir, final String[] args) {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            int count = getBufferCount();
            boolean restoreFiles = restore && jEdit.getBooleanProperty("restore") && (count == 0 || jEdit.getBooleanProperty("restore.cli"));
            if (gui || count != 0) {
                View view;
                if (newPlainView)
                    view = newView(null, null, true);
                else
                    view = PerspectiveManager.loadPerspective(restoreFiles);
                if (view == null)
                    view = newView(null, null);
                Buffer buffer;
                // Treat the elements of additionalFiles just like command-line arguments
                if (!additionalFiles.isEmpty()) {
                    String[] newArgs = new String[additionalFiles.size() + args.length];
                    additionalFiles.copyInto(newArgs);
                    System.arraycopy(args, 0, newArgs, additionalFiles.size(), args.length);
                    // We need to pass view to openFiles, because when a file is openened via
                    // the command line and is not the current buffer (because other buffers are
                    // already openened) and '+line' command line argument is given, a view is
                    // needed to scroll to the given line.
                    buffer = openFiles(view, userDir, newArgs);
                } else {
                    // See comment above in if part on passing view.
                    buffer = openFiles(view, userDir, args);
                }
                if (buffer != null)
                    view.setBuffer(buffer);
                view.toFront();
            } else {
                openFiles(null, userDir, args);
            }
            // Start I/O threads
            EditBus.send(new EditorStarted(null));
            VFSManager.start();
            // Start edit server
            if (server != null)
                server.start();
            GUIUtilities.hideSplashScreen();
            Log.log(Log.MESSAGE, jEdit.class, "Startup " + "complete: " + (System.currentTimeMillis() - startupTime) + " ms");
            //{{{ Report any plugin errors
            if (pluginErrors != null) {
                showPluginErrorDialog();
            //}}}
            }
            startupDone.set(0, true);
            // in one case not a single AWT class will
            // have been touched (splash screen off +
            // -nogui -nobackground switches on command
            // line)
            Toolkit.getDefaultToolkit();
        }
    });
}