//}}}
//{{{ exit() method
/**
	 * Exits cleanly from jEdit, prompting the user if any unsaved files
	 * should be saved first.
	 * @param view The view from which this exit was called
	 * @param reallyExit If background mode is enabled and this parameter
	 * is true, then jEdit will close all open views instead of exiting
	 * entirely.
	 */
public static void exit(View view, boolean reallyExit) {
    // Close dialog, view.close() call need a view...
    if (view == null)
        view = activeView;
    // Wait for pending I/O requests
    TaskManager.instance.waitForIoTasks();
    // Create a new EditorExitRequested
    EditorExitRequested eer = new EditorExitRequested(view);
    // Send EditorExitRequested
    EditBus.send(eer);
    // if so, do not proceed anymore in the exiting
    if (eer.hasBeenExitCancelled()) {
        Log.log(Log.MESSAGE, jEdit.class, "Exit has been cancelled");
        return;
    }
    // Even if reallyExit is false, we still exit properly
    // if background mode is off
    reallyExit |= !background;
    PerspectiveManager.savePerspective(false);
    try {
        PerspectiveManager.setPerspectiveEnabled(false);
        // Close all buffers
        if (!closeAllBuffers(view, reallyExit))
            return;
    } finally {
        PerspectiveManager.setPerspectiveEnabled(true);
    }
    // reallyExit was not specified, then return here.
    if (!reallyExit) {
        // in this case, we can't directly call
        // view.close(); we have to call closeView()
        // for all open views
        view = viewsFirst;
        while (view != null) {
            closeView(view, false);
            view = view.next;
        }
        // Save settings in case user kills the backgrounded
        // jEdit process
        saveSettings();
    } else {
        // Send EditorExiting
        EditBus.send(new EditorExiting(null));
        // Save view properties here
        view = viewsFirst;
        while (view != null) {
            closeView(view, false);
            view = view.next;
        }
        // Stop autosave timer
        Autosave.stop();
        // Stop server
        if (server != null)
            server.stopServer();
        // Stop all plugins
        PluginJAR[] plugins = getPluginJARs();
        for (PluginJAR plugin : plugins) removePluginJAR(plugin, true);
        // Save settings
        saveSettings();
        // Close activity log stream
        Log.closeStream();
        // Byebye...
        System.exit(0);
    }
}