@BeforeClass
public static void oneTimeSetUp() {
    native2ASCIIEncoding = new Native2ASCIIEncoding();
    iso_8859_1 = Charset.forName("ISO-8859-1");
    bufferArray = new char[1024];
    buffer = CharBuffer.wrap(bufferArray);
}