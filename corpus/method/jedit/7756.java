@Nonnull
public Writer getTextWriter(@Nonnull OutputStream out) throws IOException {
    return new FilterWriter(asciiEncoding.getTextWriter(out)) {

        @Override
        @Nonnull
        public Writer append(@Nullable CharSequence csq) throws IOException {
            write((csq == null) ? "null" : csq.toString());
            return this;
        }

        @Override
        @Nonnull
        public Writer append(@Nullable CharSequence csq, int start, int end) throws IOException {
            CharSequence cs = (csq == null ? "null" : csq);
            write(cs.subSequence(start, end).toString());
            return this;
        }

        @Override
        @Nonnull
        public Writer append(char c) throws IOException {
            write(c);
            return this;
        }

        @Override
        public void write(@Nonnull String str) throws IOException {
            write(str, 0, str.length());
        }

        @Override
        public void write(@Nonnull char cbuf[]) throws IOException {
            write(cbuf, 0, cbuf.length);
        }

        @Override
        public void write(@Nonnull String str, int off, int len) throws IOException {
            write(str.substring(off, off + len).toCharArray());
        }

        @Override
        public void write(@Nonnull char[] cbuf, int off, int len) throws IOException {
            char[] buf = new char[len * 6];
            int i = 0;
            for (int j = off, j2 = off + len; j < j2; j++) {
                char c = cbuf[j];
                if (asciiEncoder.canEncode(c)) {
                    buf[i++] = c;
                } else {
                    System.arraycopy(String.format("\\u%04X", (int) c).toCharArray(), 0, buf, i, 6);
                    i += 6;
                }
            }
            super.write(buf, 0, i);
        }

        @Override
        public void write(int c) throws IOException {
            if (asciiEncoder.canEncode((char) c)) {
                super.write(c);
            } else {
                write(String.format("\\u%04X", c));
            }
        }
    };
}