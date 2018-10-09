//}}}
//{{{ copy() method
private void copy(Object vfsSession, VFS vfs, String sourcePath, String sourceName, String targetPath) throws IOException, InterruptedException {
    String name = getTargetName(vfsSession, vfs, targetPath, sourceName);
    if (name == null) {
        return;
    }
    String targetName = MiscUtilities.constructPath(targetPath, name);
    CountDownLatch latch = new CountDownLatch(1);
    ThreadUtilities.runInBackground(new CopyFileWorker(comp, sourcePath, targetName, latch));
    latch.await();
}