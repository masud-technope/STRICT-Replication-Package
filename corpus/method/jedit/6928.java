//{{{ setText() method
/**
		 * Replace the selection with the given text
		 * @param buffer the buffer
		 * @param text the text
		 * @return the offset at the end of the inserted text
		 */
@Override
int setText(JEditBuffer buffer, String text) {
    buffer.remove(start, end - start);
    if (text != null && text.length() != 0) {
        buffer.insert(start, text);
        return start + text.length();
    } else
        return start;
//}}}
}