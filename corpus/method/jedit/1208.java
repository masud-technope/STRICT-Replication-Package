static String[] getTypeDescriptors(Class[] cparams) {
    String[] sa = new String[cparams.length];
    for (int i = 0; i < sa.length; i++) sa[i] = BSHType.getTypeDescriptor(cparams[i]);
    return sa;
}