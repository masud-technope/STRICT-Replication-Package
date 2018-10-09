private void writeInfoPlist() throws BuildException {
    PropertyListWriter listWriter = new PropertyListWriter(bundleProperties);
    File infoPlist = new File(mContentsDir, "Info.plist");
    listWriter.writeFile(infoPlist);
    if (mVerbose)
        log("Creating \"" + bundlePath(infoPlist) + "\" file");
    if (mShowPlist) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(infoPlist));
            String str;
            while ((str = in.readLine()) != null) log(str);
            in.close();
        } catch (IOException e) {
            throw new BuildException(e);
        }
    }
}