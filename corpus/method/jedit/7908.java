@AfterClass
public static void oneTimeTearDown() {
    native2ASCIIEncoding = null;
    iso_8859_1 = null;
    bufferArray = null;
    buffer = null;
}