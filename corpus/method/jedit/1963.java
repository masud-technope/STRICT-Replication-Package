/**
		Explicitly re-initialize just the token reader.
		This seems to be necessary to avoid certain looping errors when
		reading bogus input.  See Interpreter.
	*/
void reInitTokenInput(Reader in) {
    jj_input_stream.ReInit(in, jj_input_stream.getEndLine(), jj_input_stream.getEndColumn());
}