//}}}
//{{{ getFiles() method
public VFSFile[] getFiles() {
    VFSFile[] f = new VFSFile[files.length];
    for (int i = 0; i < f.length; i++) f[i] = files[i].dirEntry;
    return f;
}