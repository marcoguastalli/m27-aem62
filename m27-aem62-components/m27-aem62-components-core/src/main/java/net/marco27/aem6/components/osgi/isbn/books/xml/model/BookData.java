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
 *         <element ref="{}Title"/>
 *         <element ref="{}TitleLong"/>
 *         <element ref="{}AuthorsText"/>
 *         <element ref="{}PublisherText"/>
 *         <element ref="{}Summary"/>
 *         <element ref="{}Notes"/>
 *         <element ref="{}UrlsText"/>
 *         <element ref="{}AwardsText"/>
 *         <element ref="{}Prices"/>
 *       </sequence>
 *       <attribute name="book_id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       <attribute name="isbn" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "title",
        "titleLong",
        "authorsText",
        "publisherText",
        "summary",
        "notes",
        "urlsText",
        "awardsText",
        "prices"
})
@XmlRootElement(name = "BookData")
public class BookData {

    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "TitleLong", required = true)
    protected String titleLong;
    @XmlElement(name = "AuthorsText", required = true)
    protected String authorsText;
    @XmlElement(name = "PublisherText", required = true)
    protected PublisherText publisherText;
    @XmlElement(name = "Summary", required = true)
    protected String summary;
    @XmlElement(name = "Notes", required = true)
    protected String notes;
    @XmlElement(name = "UrlsText", required = true)
    protected UrlsText urlsText;
    @XmlElement(name = "AwardsText", required = true)
    protected AwardsText awardsText;
    @XmlElement(name = "Prices", required = true)
    protected Prices prices;
    @XmlAttribute(name = "book_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String bookId;
    @XmlAttribute(required = true)
    protected String isbn;
    @XmlAttribute(required = true)
    protected String isbn13;

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the titleLong property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTitleLong() {
        return titleLong;
    }

    /**
     * Sets the value of the titleLong property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitleLong(String value) {
        this.titleLong = value;
    }

    /**
     * Gets the value of the authorsText property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAuthorsText() {
        return authorsText;
    }

    /**
     * Sets the value of the authorsText property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAuthorsText(String value) {
        this.authorsText = value;
    }

    /**
     * Gets the value of the publisherText property.
     *
     * @return possible object is
     * {@link PublisherText }
     */
    public PublisherText getPublisherText() {
        return publisherText;
    }

    /**
     * Sets the value of the publisherText property.
     *
     * @param value allowed object is
     *              {@link PublisherText }
     */
    public void setPublisherText(PublisherText value) {
        this.publisherText = value;
    }

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the urlsText property.
     *
     * @return possible object is
     * {@link UrlsText }
     */
    public UrlsText getUrlsText() {
        return urlsText;
    }

    /**
     * Sets the value of the urlsText property.
     *
     * @param value allowed object is
     *              {@link UrlsText }
     */
    public void setUrlsText(UrlsText value) {
        this.urlsText = value;
    }

    /**
     * Gets the value of the awardsText property.
     *
     * @return possible object is
     * {@link AwardsText }
     */
    public AwardsText getAwardsText() {
        return awardsText;
    }

    /**
     * Sets the value of the awardsText property.
     *
     * @param value allowed object is
     *              {@link AwardsText }
     */
    public void setAwardsText(AwardsText value) {
        this.awardsText = value;
    }

    /**
     * Gets the value of the prices property.
     *
     * @return possible object is
     * {@link Prices }
     */
    public Prices getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     *
     * @param value allowed object is
     *              {@link Prices }
     */
    public void setPrices(Prices value) {
        this.prices = value;
    }

    /**
     * Gets the value of the bookId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets the value of the bookId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBookId(String value) {
        this.bookId = value;
    }

    /**
     * Gets the value of the isbn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the isbn13 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIsbn13() {
        return isbn;
    }

    /**
     * Sets the value of the isbn13 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsbn13(String value) {
        this.isbn = value;
    }

}
