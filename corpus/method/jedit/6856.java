//}}}
//{{{ getFoldPainter() method
@Override
public FoldPainter getFoldPainter() {
    FoldPainter foldPainter = (FoldPainter) ServiceManager.getService(FOLD_PAINTER_SERVICE, getFoldPainterName());
    if (foldPainter == null)
        foldPainter = (FoldPainter) ServiceManager.getService(FOLD_PAINTER_SERVICE, DEFAULT_FOLD_PAINTER_SERVICE);
    return foldPainter;
}