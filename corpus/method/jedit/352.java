public void flush() throws IOException {
    super.flush();
    m_bsStream.flush();
}