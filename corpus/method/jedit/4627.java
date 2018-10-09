public  RegexEncodingDetector(String pattern, String replacement) {
    this.pattern = Pattern.compile(pattern);
    this.replacement = replacement;
}