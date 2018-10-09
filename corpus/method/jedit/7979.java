@Test
public void differentReadMethodsShouldHaveACommonEscapeSequenceHandling() throws IOException {
    Reader reader = getReader("asdf\\: \\\\u21aFasdf");
    int c = reader.read(bufferArray, 0, 8);
    assertThat(c, is(equalTo(8)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('a')));
    assertThat(bufferArray[i++], is(equalTo('s')));
    assertThat(bufferArray[i++], is(equalTo('d')));
    assertThat(bufferArray[i++], is(equalTo('f')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo(':')));
    assertThat(bufferArray[i++], is(equalTo(' ')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('\\')));
    c = reader.read();
    assertThat((char) c, is(equalTo('u')));
    c = reader.read();
    assertThat((char) c, is(equalTo('2')));
    c = reader.read();
    assertThat((char) c, is(equalTo('1')));
    c = reader.read();
    assertThat((char) c, is(equalTo('a')));
    c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(5)));
    assertThat(buffer.length(), is(equalTo(5)));
    assertThat(buffer.toString(), is(equalTo("Fasdf")));
}