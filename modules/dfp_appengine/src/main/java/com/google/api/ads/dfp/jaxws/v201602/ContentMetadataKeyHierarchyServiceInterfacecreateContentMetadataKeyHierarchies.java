// Copyright 2016 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.google.api.ads.dfp.jaxws.v201602;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Creates new {@link ContentMetadataKeyHierarchy} objects.
 *             
 *             The following fields are required:
 *             <ul>
 *             <li>{@link ContentMetadataKeyHierarchy#id}</li>
 *             <li>{@link ContentMetadataKeyHierarchy#name}</li>
 *             <li>{@link ContentMetadataKeyHierarchy#hierarchyLevels}</li>
 *             </ul>
 *             
 *             @param contentMetadataKeyHierarchies the hierarchies to create
 *             @return the created hierarchies with their IDs filled in
 *           
 * 
 * <p>Java class for createContentMetadataKeyHierarchies element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="createContentMetadataKeyHierarchies">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="contentMetadataKeyHierarchies" type="{https://www.google.com/apis/ads/publisher/v201602}ContentMetadataKeyHierarchy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contentMetadataKeyHierarchies"
})
@XmlRootElement(name = "createContentMetadataKeyHierarchies")
public class ContentMetadataKeyHierarchyServiceInterfacecreateContentMetadataKeyHierarchies {

    protected List<ContentMetadataKeyHierarchy> contentMetadataKeyHierarchies;

    /**
     * Gets the value of the contentMetadataKeyHierarchies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentMetadataKeyHierarchies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentMetadataKeyHierarchies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentMetadataKeyHierarchy }
     * 
     * 
     */
    public List<ContentMetadataKeyHierarchy> getContentMetadataKeyHierarchies() {
        if (contentMetadataKeyHierarchies == null) {
            contentMetadataKeyHierarchies = new ArrayList<ContentMetadataKeyHierarchy>();
        }
        return this.contentMetadataKeyHierarchies;
    }

}
