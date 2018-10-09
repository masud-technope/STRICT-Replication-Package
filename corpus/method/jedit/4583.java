//{{{ listRoots() method
private static File[] listRoots() {
    if (OperatingSystem.isMacOS()) {
        // Nasty hardcoded values
        File[] volumes = new File("/Volumes").listFiles();
        LinkedList<File> roots = new LinkedList<File>();
        roots.add(new File("/"));
        for (File volume : volumes) {
            // Make sure people don't do stupid things like putting files in /Volumes
            if (volume.isDirectory())
                roots.add(volume);
        }
        return roots.toArray(new File[roots.size()]);
    } else {
        File[] roots = File.listRoots();
        File[] desktop = fsView.getRoots();
        if (desktop == null)
            return roots;
        File[] rootsPlus = new File[roots.length + desktop.length];
        System.arraycopy(desktop, 0, rootsPlus, 0, desktop.length);
        System.arraycopy(roots, 0, rootsPlus, 1, roots.length);
        return rootsPlus;
    }
}