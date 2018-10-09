@Test(expected = MalformedInputException.class)
public void read_charArray_int_int_ShouldThrowExceptionOnMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    getThrottledReader("\\u21aL").read(bufferArray, 0, 1);
}