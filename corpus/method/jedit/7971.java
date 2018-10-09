@Test
public void differentReadMethodsShouldBeUsableOnTheSameStream() throws IOException {
    Reader reader = getReader("asdf\\: \\u21aFasdf");
    int c = reader.read();
    assertThat((char) c, is(equalTo('a')));
    c = reader.read();
    assertThat((char) c, is(equalTo('s')));
    c = reader.read();
    assertThat((char) c, is(equalTo('d')));
    c = reader.read(bufferArray, 0, 3);
    assertThat(c, is(equalTo(3)));
    int i = 0;
    assertThat(bufferArray[i++], is(equalTo('f')));
    assertThat(bufferArray[i++], is(equalTo('\\')));
    assertThat(bufferArray[i++], is(equalTo(':')));
    c = reader.read();
    assertThat((char) c, is(equalTo(' ')));
    c = reader.read();
    assertThat((char) c, is(equalTo('?')));
    c = reader.read();
    assertThat((char) c, is(equalTo('a')));
    c = reader.read(buffer);
    buffer.flip();
    assertThat(c, is(equalTo(3)));
    assertThat(buffer.length(), is(equalTo(3)));
    assertThat(buffer.toString(), is(equalTo("sdf")));
}