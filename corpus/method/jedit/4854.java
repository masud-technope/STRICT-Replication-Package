//}}}
@Nonnull
private static String getPLAFClassName(@Nullable String lf) {
    if (lf != null && lf.length() != 0) {
        return lf;
    } else if (OperatingSystem.isMacOS()) {
        return UIManager.getSystemLookAndFeelClassName();
    } else {
        return UIManager.getCrossPlatformLookAndFeelClassName();
    }
}