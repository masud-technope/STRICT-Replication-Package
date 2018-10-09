//{{{ addExtension() method
/**
	 * Add an extension.
	 * See {@link Gutter} and {@link TextAreaPainter} to know the layers
	 *
	 * @param layer the layer. It could be defined in Gutter or TextAreaPainter
	 * @param ext the extension to add
	 */
void addExtension(int layer, TextAreaExtension ext) {
    Entry entry = new Entry(layer, ext);
    int i = 0;
    for (Entry extension : extensions) {
        int _layer = extension.layer;
        if (layer < _layer) {
            extensions.add(i, entry);
            return;
        }
        i++;
    }
    extensions.add(entry);
}