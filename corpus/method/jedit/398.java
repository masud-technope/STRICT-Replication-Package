public  Install() {
    props = new Properties();
    try {
        InputStream in = getClass().getResourceAsStream("/installer/install.props");
        props.load(in);
        in.close();
    } catch (IOException io) {
        System.err.println("Error loading 'install.props':");
        io.printStackTrace();
    }
    buf = new byte[32768];
}