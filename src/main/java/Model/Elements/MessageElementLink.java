package Model.Elements;

public class MessageElementLink extends MessageElement {
    @Override
    public String getMessage(String message, int start, int end) {
        String formatString = message.substring(start, end);
        return "<a href=\"" + formatString + "\">" + formatString + "</a>";
    }
}
