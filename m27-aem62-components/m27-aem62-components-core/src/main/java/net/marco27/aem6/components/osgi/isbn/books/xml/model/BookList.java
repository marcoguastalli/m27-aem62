package net.marco27.aem6.components.osgi.isbn.books.xml.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         <element ref="{}BookData" maxOccurs="unbounded"/>
 *       </sequence>
 *       <attribute name="total_results" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "bookData"
})
@XmlRootElement(name = "BookList")
public class BookList {

    @XmlElement(name = "BookData", required = true)
    protected List<BookData> bookData;
    @XmlAttribute(name = "total_results", required = true)
    protected BigInteger totalResults;

    /**
     * Gets the value of the bookData property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bookData property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBookData().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BookData }
     */
    public List<BookData> getBookData() {
        if (bookData == null) {
            bookData = new ArrayList<BookData>();
        }
        return this.bookData;
    }

    /**
     * Gets the value of the totalResults property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getTotalResults() {
        return totalResults;
    }

    /**
     * Sets the value of the totalResults property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setTotalResults(BigInteger value) {
        this.totalResults = value;
    }

}
