//{{{ Install constructor
 Install(String installed, String url, String installDirectory, int size) {
    // catch those hooligans passing null urls
    if (url == null)
        throw new NullPointerException();
    this.installed = installed;
    this.url = url;
    this.installDirectory = installDirectory;
    this.size = size;
//}}}
}