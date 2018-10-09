public  TarHeader() {
    this.magic = new StringBuffer(TarHeader.TMAGIC);
    this.name = new StringBuffer();
    this.linkName = new StringBuffer();
    String user = System.getProperty("user.name", "");
    if (user.length() > 31)
        user = user.substring(0, 31);
    this.userId = 0;
    this.groupId = 0;
    this.userName = new StringBuffer(user);
    this.groupName = new StringBuffer("");
}