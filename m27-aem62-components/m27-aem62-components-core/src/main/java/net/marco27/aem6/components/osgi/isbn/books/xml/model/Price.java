package net.marco27.aem6.components.osgi.isbn.books.xml.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       <attribute name="check_time" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       <attribute name="is_in_stock" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       <attribute name="is_new" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       <attribute name="price" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       <attribute name="store_id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Price")
public class Price {

    @XmlAttribute(name = "check_time", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String checkTime;
    @XmlAttribute(name = "is_in_stock", required = true)
    protected BigInteger isInStock;
    @XmlAttribute(name = "is_new", required = true)
    protected BigInteger isNew;
    @XmlAttribute(required = true)
    protected BigDecimal price;
    @XmlAttribute(name = "store_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String storeId;

    /**
     * Gets the value of the checkTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCheckTime() {
        return checkTime;
    }

    /**
     * Sets the value of the checkTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCheckTime(String value) {
        this.checkTime = value;
    }

    /**
     * Gets the value of the isInStock property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getIsInStock() {
        return isInStock;
    }

    /**
     * Sets the value of the isInStock property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setIsInStock(BigInteger value) {
        this.isInStock = value;
    }

    /**
     * Gets the value of the isNew property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getIsNew() {
        return isNew;
    }

    /**
     * Sets the value of the isNew property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setIsNew(BigInteger value) {
        this.isNew = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the storeId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * Sets the value of the storeId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStoreId(String value) {
        this.storeId = value;
    }

}