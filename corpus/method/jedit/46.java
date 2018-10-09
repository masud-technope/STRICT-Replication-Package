public String getCFBundleName() {
    if (mCFBundleName == null)
        return getApplicationName();
    return mCFBundleName;
}