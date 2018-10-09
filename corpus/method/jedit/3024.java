//{{{ EditServer constructor
 EditServer(String portFile) {
    super("jEdit server daemon [" + portFile + "]");
    setDaemon(true);
    this.portFile = portFile;
    try {
        // your way. Nasty.)
        if (OperatingSystem.isUnix()) {
            new File(portFile).createNewFile();
            FileVFS.setPermissions(portFile, 0600);
        }
        // Bind to any port on localhost; accept 2 simultaneous
        // connection attempts before rejecting connections
        socket = new ServerSocket(0, 2, InetAddress.getByName(null));
        authKey = new Random().nextInt(Integer.MAX_VALUE);
        int port = socket.getLocalPort();
        FileWriter out = new FileWriter(portFile);
        try {
            out.write("b\n");
            out.write(String.valueOf(port));
            out.write("\n");
            out.write(String.valueOf(authKey));
            out.write("\n");
        } finally {
            out.close();
        }
        ok = true;
        Log.log(Log.DEBUG, this, "jEdit server started on port " + socket.getLocalPort());
        Log.log(Log.DEBUG, this, "Authorization key is " + authKey);
    } catch (IOException io) {
        Log.log(Log.NOTICE, this, io);
    }
}