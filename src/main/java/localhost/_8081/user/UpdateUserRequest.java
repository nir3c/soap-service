//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.04 at 04:06:34 PM IST 
//


package localhost._8081.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateUserRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateUserRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userAuthentication" type="{http://localhost:8081/user}UserAuthentication"/>
 *         &lt;element name="userUpdate" type="{http://localhost:8081/user}UserUpdate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUserRequest", propOrder = {
    "userAuthentication",
    "userUpdate"
})
public class UpdateUserRequest {

    @XmlElement(required = true)
    protected UserAuthentication userAuthentication;
    @XmlElement(required = true)
    protected UserUpdate userUpdate;

    /**
     * Gets the value of the userAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link UserAuthentication }
     *     
     */
    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    /**
     * Sets the value of the userAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAuthentication }
     *     
     */
    public void setUserAuthentication(UserAuthentication value) {
        this.userAuthentication = value;
    }

    /**
     * Gets the value of the userUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link UserUpdate }
     *     
     */
    public UserUpdate getUserUpdate() {
        return userUpdate;
    }

    /**
     * Sets the value of the userUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserUpdate }
     *     
     */
    public void setUserUpdate(UserUpdate value) {
        this.userUpdate = value;
    }

}
