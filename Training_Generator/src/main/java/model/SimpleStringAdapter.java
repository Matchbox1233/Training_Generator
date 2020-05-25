package model;

import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This class is convert a SimpleStringProperty to a String.
 */
public class SimpleStringAdapter extends XmlAdapter<String, SimpleStringProperty> {

    @Override
    public String marshal(SimpleStringProperty simpleStringProperty) throws Exception {
        return simpleStringProperty.get();
    }

    @Override
    public SimpleStringProperty unmarshal(String v) throws Exception {
        return new SimpleStringProperty(v);
    }



}