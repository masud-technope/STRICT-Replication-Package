void setSkew(int skew) {
    if (this.skew != skew) {
        this.skew = skew;
        setCallChanged(true);
    }
}