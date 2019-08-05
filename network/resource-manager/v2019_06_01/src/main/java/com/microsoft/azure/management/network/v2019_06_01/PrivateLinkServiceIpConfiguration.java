/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import com.microsoft.azure.management.network.v2019_06_01.implementation.SubnetInner;
import com.microsoft.azure.management.network.v2019_06_01.implementation.PublicIPAddressInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * The private link service ip configuration.
 */
@JsonFlatten
public class PrivateLinkServiceIpConfiguration {
    /**
     * The private IP address of the IP configuration.
     */
    @JsonProperty(value = "properties.privateIPAddress")
    private String privateIPAddress;

    /**
     * The private IP address allocation method. Possible values include:
     * 'Static', 'Dynamic'.
     */
    @JsonProperty(value = "properties.privateIPAllocationMethod")
    private IPAllocationMethod privateIPAllocationMethod;

    /**
     * The reference of the subnet resource.
     */
    @JsonProperty(value = "properties.subnet")
    private SubnetInner subnet;

    /**
     * The reference of the public IP resource.
     */
    @JsonProperty(value = "properties.publicIPAddress")
    private PublicIPAddressInner publicIPAddress;

    /**
     * Gets the provisioning state of the public IP resource. Possible values
     * are: 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * Available from Api-Version 2016-03-30 onwards, it represents whether the
     * specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4.
     * Possible values include: 'IPv4', 'IPv6'.
     */
    @JsonProperty(value = "properties.privateIPAddressVersion")
    private IPVersion privateIPAddressVersion;

    /**
     * The name of private link service ip configuration.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Get the private IP address of the IP configuration.
     *
     * @return the privateIPAddress value
     */
    public String privateIPAddress() {
        return this.privateIPAddress;
    }

    /**
     * Set the private IP address of the IP configuration.
     *
     * @param privateIPAddress the privateIPAddress value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withPrivateIPAddress(String privateIPAddress) {
        this.privateIPAddress = privateIPAddress;
        return this;
    }

    /**
     * Get the private IP address allocation method. Possible values include: 'Static', 'Dynamic'.
     *
     * @return the privateIPAllocationMethod value
     */
    public IPAllocationMethod privateIPAllocationMethod() {
        return this.privateIPAllocationMethod;
    }

    /**
     * Set the private IP address allocation method. Possible values include: 'Static', 'Dynamic'.
     *
     * @param privateIPAllocationMethod the privateIPAllocationMethod value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withPrivateIPAllocationMethod(IPAllocationMethod privateIPAllocationMethod) {
        this.privateIPAllocationMethod = privateIPAllocationMethod;
        return this;
    }

    /**
     * Get the reference of the subnet resource.
     *
     * @return the subnet value
     */
    public SubnetInner subnet() {
        return this.subnet;
    }

    /**
     * Set the reference of the subnet resource.
     *
     * @param subnet the subnet value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withSubnet(SubnetInner subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the reference of the public IP resource.
     *
     * @return the publicIPAddress value
     */
    public PublicIPAddressInner publicIPAddress() {
        return this.publicIPAddress;
    }

    /**
     * Set the reference of the public IP resource.
     *
     * @param publicIPAddress the publicIPAddress value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withPublicIPAddress(PublicIPAddressInner publicIPAddress) {
        this.publicIPAddress = publicIPAddress;
        return this;
    }

    /**
     * Get gets the provisioning state of the public IP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set gets the provisioning state of the public IP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @param provisioningState the provisioningState value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get available from Api-Version 2016-03-30 onwards, it represents whether the specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4. Possible values include: 'IPv4', 'IPv6'.
     *
     * @return the privateIPAddressVersion value
     */
    public IPVersion privateIPAddressVersion() {
        return this.privateIPAddressVersion;
    }

    /**
     * Set available from Api-Version 2016-03-30 onwards, it represents whether the specific ipconfiguration is IPv4 or IPv6. Default is taken as IPv4. Possible values include: 'IPv4', 'IPv6'.
     *
     * @param privateIPAddressVersion the privateIPAddressVersion value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withPrivateIPAddressVersion(IPVersion privateIPAddressVersion) {
        this.privateIPAddressVersion = privateIPAddressVersion;
        return this;
    }

    /**
     * Get the name of private link service ip configuration.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of private link service ip configuration.
     *
     * @param name the name value to set
     * @return the PrivateLinkServiceIpConfiguration object itself.
     */
    public PrivateLinkServiceIpConfiguration withName(String name) {
        this.name = name;
        return this;
    }

}
