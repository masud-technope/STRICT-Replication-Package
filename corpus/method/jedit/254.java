/**
         * A 3 digit octal string, specify the user, group and
         * other modes in the standard Unix fashion;
         * optional, default=0644
         * @param octalString a 3 digit octal string.
         */
public void setMode(String octalString) {
    this.fileMode = UnixStat.FILE_FLAG | Integer.parseInt(octalString, 8);
}