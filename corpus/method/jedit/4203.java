//{{{ setTrayIconArgs() method
@Override
void setTrayIconArgs(boolean restore, String userDir, String[] args) {
    this.restore = restore;
    this.userDir = userDir;
    this.args = args;
}