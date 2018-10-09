public boolean accept(VFSFile file) {
    if (file.getType() == VFSFile.DIRECTORY || file.getType() == VFSFile.FILESYSTEM) {
        return true;
    } else {
        return accept(file.getName());
    }
}