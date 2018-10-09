@Test(expected = MalformedInputException.class)
public void read_charArray_ShouldThrowExceptionOnMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    getThrottledReader("\\u21aL").read(bufferArray);
}