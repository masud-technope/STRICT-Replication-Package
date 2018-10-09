public void run() {
    progress.setMaximum(size * 1024);
    //return value ignored : already signalled in ServerKiller
    progress.message("stopping any jEdit server");
    ServerKiller.quitjEditServer();
    try {
        // install user-selected packages
        for (int i = 0; i < components.size(); i++) {
            String comp = (String) components.elementAt(i);
            progress.message("Installing " + comp);
            installComponent(comp);
        }
        // scripts, installing man pages, etc.)
        for (int i = 0; i < osTasks.length; i++) {
            progress.message("Performing task " + osTasks[i].getName());
            osTasks[i].perform(installDir, components);
        }
    } catch (FileNotFoundException fnf) {
        progress.error("The installer could not create the " + "destination directory.\n" + "Maybe you do not have write permission?");
        return;
    } catch (IOException io) {
        progress.error(io.toString());
        return;
    }
    progress.done();
}