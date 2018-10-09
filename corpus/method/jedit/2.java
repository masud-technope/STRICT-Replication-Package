public void setJVMVersion(String s) {
    mJVMVersion = s;
    mJavaVersion = Double.parseDouble(s.substring(0, 3));
}