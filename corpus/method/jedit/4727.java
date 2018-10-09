public void run() {
    synchronized (vfsUpdateLock) {
        // the vfs browser has what you might call
        // a design flaw, it doesn't update properly
        // unless the vfs update for a parent arrives
        // before any updates for the children. sorting
        // the list alphanumerically guarantees this.
        Collections.sort(vfsUpdates, new StandardUtilities.StringCompare<VFSUpdate>());
        for (VFSUpdate vfsUpdate : vfsUpdates) EditBus.send(vfsUpdate);
        vfsUpdates.clear();
    }
}