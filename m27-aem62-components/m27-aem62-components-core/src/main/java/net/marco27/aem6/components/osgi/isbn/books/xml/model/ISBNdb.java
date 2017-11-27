package net.marco27.aem6.components.osgi.isbn.books.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{}BookList"/>
 *       </sequence>
 *       <attribute name="server_time" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "bookList"
})
@XmlRootElement(name = "ISBNdb")
public class ISBNdb {

    @XmlElement(name = "BookList", required = true)
    protected BookList bookList;
    @XmlAttribute(name = "server_time", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String serverTime;

    /**
     * Gets the value of the bookList property.
     *
     * @return possible object is
     * {@link BookList }
     */
    public BookList getBookList() {
        return bookList;
    }

    /**
     * Sets the value of the bookList property.
     *
     * @param value allowed object is
     *              {@link BookList }
     */
    public void setBookList(BookList value) {
        this.bookList = value;
    }

    /**
     * Gets the value of the serverTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getServerTime() {
        return serverTime;
    }

    /**
     * Sets the value of the serverTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setServerTime(String value) {
        this.serverTime = value;
    }
}