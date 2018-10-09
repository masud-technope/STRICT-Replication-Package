/**
   * Visits a field of the class.
   *
   * @param access the field's access flags (see {@link Constants}). This
   *      parameter also indicates if the field is synthetic and/or deprecated.
   * @param name the field's name.
   * @param desc the field's descriptor (see {@link Type Type}).
   * @param value the field's initial value. This parameter, which may be
   *      <tt>null</tt> if the field does not have an initial value, must be an
   *      {@link java.lang.Integer Integer}, a {@link java.lang.Float Float}, a
   *      {@link java.lang.Long Long}, a {@link java.lang.Double Double} or a
   *      {@link String String}.
   */
void visitField(int access, String name, String desc, Object value);