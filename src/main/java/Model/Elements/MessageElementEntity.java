package Model.Elements;

public class MessageElementEntity extends MessageElement {

    @Override
    public String getMessage(String message, int start, int end) {
        return "<strong>" + message.substring(start, end) + "</strong>";
    }
}
