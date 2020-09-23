package Servise;

import Model.MessageElementFactory;
import Model.MetaData;
import Model.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadMessageImpl implements ReadMessage {

    private StringBuilder formatMessage =  new StringBuilder();
    private MetaValidator validator = new MetaValidator();


    @Override
    public String formatMessage(String message, List<MetaData> metaDataList) {
        validator.validate(message, metaDataList);
        List<MetaData> correctData = correctingData(metaDataList);
        Collections.sort(correctData);
        for (MetaData metaData:  correctData) {
            formatMessage.append( MessageElementFactory.getMessageElement(metaData.getType()).getMessage(message, metaData.getStart(),metaData.getEnd()) + " ");

        }
        return formatMessage.toString();
    }

    private List<MetaData> correctingData(List<MetaData> metaDataList){
        List<MetaData> sortData = new ArrayList<>();
        Collections.sort(metaDataList);
        for (int i = 0; i < metaDataList.size() - 1; i++) {
            if(metaDataList.get(i).getEnd() + 1 < metaDataList.get(i + 1).getStart()) {
                int start = metaDataList.get(i).getEnd() + 1;
                int end = metaDataList.get(i + 1).getStart() - 1;
                MetaData itemMeta = new MetaData(Type.UsualText, start, end);
                sortData.add(itemMeta);
            }
        }
        sortData.addAll(metaDataList);
        return sortData;
    }
}
