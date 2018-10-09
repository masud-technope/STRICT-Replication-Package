public void addBuffer(String s) {
    if (includeFiles) {
        if (includeRemotes) {
            buffers.add(s);
            return;
        }
        if (!isRemote(s)) {
            buffers.add(s);
        }
    }
}