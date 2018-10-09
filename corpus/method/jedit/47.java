// ================================================================================
//
// Bundle setters and getters
//
public void setCFBundleName(String s) {
    if (s.length() > 16)
        System.err.println("WARNING: 'shortname' is recommeded to be no more than 16 " + "charaters long. See usage notes.");
    mCFBundleName = s;
}