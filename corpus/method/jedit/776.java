@Override
public boolean accept(VFSFile file) {
    return file.getType() == VFSFile.DIRECTORY || file.getType() == VFSFile.FILESYSTEM;
}