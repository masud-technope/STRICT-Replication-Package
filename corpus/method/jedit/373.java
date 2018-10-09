private void moveToFrontCodeAndSend() throws IOException {
    bsPutIntVS(24, m_origPtr);
    generateMTFValues();
    sendMTFValues();
}