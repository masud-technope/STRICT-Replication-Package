//{{{ Recorder constructor
public  Recorder(View view, Buffer buffer, boolean temporary) {
    this.view = view;
    this.buffer = buffer;
    this.temporary = temporary;
    EditBus.addToBus(this);
//}}}
}