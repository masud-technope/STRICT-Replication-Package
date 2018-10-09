private void installComponent(String name) throws IOException {
    InputStream in = new BufferedInputStream(getClass().getResourceAsStream(name + ".tar.bz2"));
    // skip header bytes
    // maybe should check if they're valid or not?
    in.read();
    in.read();
    TarInputStream tarInput = new TarInputStream(new CBZip2InputStream(in));
    TarEntry entry;
    String fileName = null;
    while ((entry = tarInput.getNextEntry()) != null) {
        if (entry.isDirectory()) {
            fileName = null;
            continue;
        }
        if (fileName == null) {
            fileName = entry.getName();
            if (fileName.equals("././@LongLink")) {
                fileName = new BufferedReader(new InputStreamReader(tarInput)).readLine();
                if (fileName == null) {
                    // missing filename ??
                    throw new IOException("Invalid or corrupt contents: file in tar with long filename but no filename found");
                }
                // bug #3837 - can't install because long file name ends with \0
                while (!fileName.isEmpty() && fileName.charAt(fileName.length() - 1) == 0) {
                    fileName = fileName.substring(0, fileName.length() - 1);
                }
                if (fileName.isEmpty()) {
                    // filename consists in '\0's ??
                    throw new IOException("Invalid or corrupt contents: file in tar with long filename but empty filename found");
                }
                continue;
            }
        }
        //System.err.println(fileName);
        String outfile = installDir + File.separatorChar + fileName.replace('/', File.separatorChar);
        installer.copy(tarInput, outfile, progress);
        fileName = null;
    }
    tarInput.close();
}