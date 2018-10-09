/**
	 * TarHeaders can be cloned.
	 */
public Object clone() {
    TarHeader hdr = null;
    try {
        hdr = (TarHeader) super.clone();
        hdr.name = (this.name == null) ? null : new StringBuffer(this.name.toString());
        hdr.mode = this.mode;
        hdr.userId = this.userId;
        hdr.groupId = this.groupId;
        hdr.size = this.size;
        hdr.modTime = this.modTime;
        hdr.checkSum = this.checkSum;
        hdr.linkFlag = this.linkFlag;
        hdr.linkName = (this.linkName == null) ? null : new StringBuffer(this.linkName.toString());
        hdr.magic = (this.magic == null) ? null : new StringBuffer(this.magic.toString());
        hdr.userName = (this.userName == null) ? null : new StringBuffer(this.userName.toString());
        hdr.groupName = (this.groupName == null) ? null : new StringBuffer(this.groupName.toString());
        hdr.devMajor = this.devMajor;
        hdr.devMinor = this.devMinor;
    } catch (CloneNotSupportedException ex) {
        ex.printStackTrace();
    }
    return hdr;
}