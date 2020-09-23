package Servise;


import Model.MetaData;
import Model.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadMessageImplTest {

    private ReadMessage readMessage;

    @Before
    public void init() {
        readMessage = new ReadMessageImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void badDataForFormatMessage() {
        String inputMessage = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

        List<MetaData> metaData = new ArrayList<>();
        metaData.add(new MetaData(Type.Entity, 0, 5));
        metaData.add(new MetaData(Type.Entity, 14, 22));
        metaData.add(new MetaData(Type.Twitter, 48, 56));
        metaData.add(new MetaData(Type.Link, 37, 47));

        readMessage.formatMessage(inputMessage, metaData);
    }

    @Test
    public void goodDataForFormatMessage() {
        String inputMessage = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

        List<MetaData> metaData = new ArrayList<>();
        metaData.add(new MetaData(Type.Entity, 0, 5));
        metaData.add(new MetaData(Type.Entity, 14, 22));
        metaData.add(new MetaData(Type.Twitter, 55, 67));
        metaData.add(new MetaData(Type.Link, 37, 54));

        String outputMessage = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a> ";
        Assert.assertEquals(outputMessage, readMessage.formatMessage(inputMessage, metaData));
    }
}