//{{{ getFoldPainterService() method
public static String getFoldPainterName() {
    return jEdit.getProperty(FOLD_PAINTER_PROPERTY, DEFAULT_FOLD_PAINTER_SERVICE);
}