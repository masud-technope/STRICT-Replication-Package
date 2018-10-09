public  ArOutputStream(OutputStream os) throws IOException {
    super(os);
    if (null == os) {
        throw new NullPointerException("os must not be null");
    }
    this.out.write(ArConstants.ARMAGIC, 0, ArConstants.ARMAGIC.length);
    this.oneBuf = new byte[1];
}