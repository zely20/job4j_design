package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLReport implements Report<Employee> {

    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> predicate) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter text = new StringWriter();
        StringBuilder result = new StringBuilder();
        for (Employee employee : store.findBy(predicate)) {
            jaxbMarshaller.marshal(employee, text);
            result.append(text.toString());
        }
        return result.toString();
    }
}