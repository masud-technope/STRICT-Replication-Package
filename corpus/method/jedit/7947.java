@Test(expected = MalformedInputException.class)
public void read_CharBuffer_ShouldThrowExceptionOnMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    getThrottledReader("\\u21aL").read(buffer);
}