package Model.Elements;

public class MessageElementUsualText extends MessageElement {
    @Override
    public String getMessage(String message, int start, int end) {
        return message.substring(start, end);
    }
}
