package Servise;

import Model.MetaData;
import java.util.List;
import java.util.Objects;

public class MetaValidator {

    public void validate(String message, List<MetaData> metaDataList) {
        boolean metaIsNull = metaDataList.stream()
                .anyMatch(Objects::isNull);
        if (metaIsNull) {
            throw new IllegalArgumentException("Meta data is null");
        }
        boolean metaLength = metaDataList.stream()
                .anyMatch(metaData -> metaData.getEnd() > message.length());
        boolean metaBadSymbol = metaDataList.stream()
                .anyMatch(metaData -> metaData.getEnd() < message.length() && (char) 32 != (message.charAt(metaData.getEnd())));
        if (metaLength || metaBadSymbol) {
            throw new IllegalArgumentException("Wrong meta data");
        }
    }
}
