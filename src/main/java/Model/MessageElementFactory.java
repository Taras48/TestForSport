package Model;

import Model.Elements.MessageElement;
import Model.Elements.MessageElementEntity;
import Model.Elements.MessageElementLink;
import Model.Elements.MessageElementTwitter;
import Model.Elements.MessageElementUsualText;

public class MessageElementFactory {
    public static MessageElement getMessageElement(Type type){
        switch (type) {
            case Entity: return new MessageElementEntity();
            case Link: return new MessageElementLink();
            case Twitter:return new MessageElementTwitter();
            case UsualText:return new MessageElementUsualText();
            default: throw new IllegalArgumentException("Unknown Item Type");
        }

    }
}
