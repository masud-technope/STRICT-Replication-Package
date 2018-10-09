@Test
public void multipleSkipCallsShouldWork() throws IOException {
    Reader reader = getReader("asdf\\: \\\\u21alasdf");
    long skipped = reader.skip(5);
    assertThat(skipped, is(equalTo(5L)));
    skipped = reader.skip(10);
    assertThat(skipped, is(equalTo(10L)));
    skipped = reader.skip(5);
    assertThat(skipped, is(equalTo(3L)));
    int c = reader.read();
    assertThat(c, is(equalTo(-1)));
}