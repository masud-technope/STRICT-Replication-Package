//{{{ setFolderPainter() method
public void setFoldPainter(FoldPainter painter) {
    if (painter == null)
        foldPainter = new TriangleFoldPainter();
    else
        foldPainter = painter;
}