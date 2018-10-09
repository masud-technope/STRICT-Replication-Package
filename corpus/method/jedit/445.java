/**
	 * try to contact a running instance of jEdit Server
	 * and ask it to close.
	 * @return	true	either if no server was detected, or the server was shut-down,
	 *		false otherwise
	 */
public static boolean quitjEditServer() {
    /* {{{ default server file location */
    String settingsDirectory = System.getProperty("user.home");
    File portFile;
    File f = new File(settingsDirectory);
    portFile = new File(f, ".jedit/server");
    if (portFile.exists()) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(portFile));
            String check = in.readLine();
            if (!check.equals("b")) {
                System.out.println("Wrong port file format");
                return false;
            }
            int port = Integer.parseInt(in.readLine());
            int key = Integer.parseInt(in.readLine());
            Socket socket = new Socket(InetAddress.getByName(null), port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeInt(key);
            // we can't close the socket cleanly, because we want
            // to wait for complete exit, and then it's too late.
            // so the socket is closed when the JVM is shut down.
            String script;
            script = "jEdit.exit(null,true);\n";
            out.writeUTF(script);
            // block until its closed
            try {
                socket.getInputStream().read();
            } catch (Exception e) {
            }
            in.close();
            out.close();
        } catch (FileNotFoundException fnfe) {
        } catch (UnknownHostException uhe) {
        } catch (IOException ioe) {
            System.out.println("Exception while trying to connect to existing server:");
            System.out.println(ioe);
            System.out.println("Don't worry too much !");
            return false;
        }
    }
    return true;
}