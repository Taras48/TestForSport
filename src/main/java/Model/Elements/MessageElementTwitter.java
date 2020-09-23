package Model.Elements;

public class MessageElementTwitter extends MessageElement {

    @Override
    public String getMessage(String message, int start, int end) {
        String formatString = message;
        formatString = formatString.contains("@") ? formatString.split("@")[1] : formatString;
        return "@<a href=\"http://twitter.com/" + formatString + "\">" + formatString + "</a>";
    }
}
