@Test(expected = MalformedInputException.class)
public void readShouldThrowExceptionOnMalformedInputWithThrottledReader() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    getThrottledReader("\\u21aL").read();
}