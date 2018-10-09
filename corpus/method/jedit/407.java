public static OperatingSystem getOperatingSystem() {
    if (os != null)
        return os;
    if (System.getProperty("mrj.version") != null) {
        os = new MacOS();
    } else {
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1)
            os = new Windows();
        else if (osName.indexOf("OS/2") != -1)
            os = new HalfAnOS();
        else if (osName.indexOf("VMS") != -1)
            os = new VMS();
        else
            os = new Unix();
    }
    return os;
}