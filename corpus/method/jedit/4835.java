//}}}
//{{{ getResourceAsUTF8Text() method
private static Reader getResourceAsUTF8Text(String name) throws IOException {
    InputStream bytes = jEdit.class.getResourceAsStream(name);
    if (bytes == null) {
        return null;
    }
    Reader text = null;
    try {
        // Using our CharsetEncoding to reliably detect
        // encoding errors.
        CharsetEncoding utf8 = new CharsetEncoding("UTF-8");
        text = utf8.getTextReader(bytes);
    } finally {
        if (text == null) {
            bytes.close();
        }
    }
    return text;
}