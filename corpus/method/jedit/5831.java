//}}}
//{{{ addInstall() method
void addInstall(String installed, String url, String installDirectory, int size) {
    addOperation(new Install(installed, url, installDirectory, size));
}