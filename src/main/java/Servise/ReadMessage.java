package Servise;

import Model.MetaData;
import java.util.List;

public interface ReadMessage {
    String formatMessage(String message, List<MetaData> metaData);
}
