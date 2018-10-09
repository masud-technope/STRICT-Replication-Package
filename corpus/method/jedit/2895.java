//{{{ ListVFSFileTransferable constructor
public  ListVFSFileTransferable(VFSFile[] files) {
    this.files = Collections.unmodifiableList(Arrays.asList(files));
}