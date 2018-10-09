public static byte[] md5(CharSequence charSequence) {
    try {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] ba = new byte[2];
        for (int i = 0, n = charSequence.length(); i < n; i++) {
            char cp = charSequence.charAt(i);
            ba[0] = (byte) (cp & 0xff);
            ba[1] = (byte) (cp >> 8 & 0xff);
            digest.update(ba);
        }
        return digest.digest();
    } catch (NoSuchAlgorithmException e) {
        Log.log(Log.ERROR, StandardUtilities.class, "Can't Calculate MD5 hash!", e);
        return new byte[1];
    }
}