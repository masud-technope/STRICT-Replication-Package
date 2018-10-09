public static boolean start(RootDoc root) {
    if (!Standard.start(root)) {
        return false;
    }
    try {
        String destDirName = null;
        for (String[] option : root.options()) {
            if ("-d".equals(option[0].toLowerCase())) {
                destDirName = option[1];
                break;
            }
        }
        FileWriter out = new FileWriter(new File(destDirName, OUT));
        out.write(HEADER);
        PackageDoc[] packages = root.specifiedPackages();
        for (int i = 0; i < packages.length; ++i) {
            processPackage(out, packages[i]);
        }
        out.write(FOOTER);
        out.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}