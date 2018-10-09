/**
	 * try to connect to any running server instance and close it.
	 * exit with an error code on failure, but not if no server was found.
	 */
public static void main(String[] args) {
    boolean success = quitjEditServer();
    if (!success) {
        System.exit(-1);
    }
}