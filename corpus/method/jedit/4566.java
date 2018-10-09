//{{{ Constructor
public  EncodingWithBOM(String plain) {
    byte[] bom = bomMap.get(plain);
    if (bom == null) {
        throw new UnsupportedCharsetException(plain + " with BOM");
    }
    this.plain = new CharsetEncoding(plain);
    this.bom = bom;
}