/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for VpnGatewayTunnelingProtocol.
 */
public final class VpnGatewayTunnelingProtocol extends ExpandableStringEnum<VpnGatewayTunnelingProtocol> {
    /** Static value IkeV2 for VpnGatewayTunnelingProtocol. */
    public static final VpnGatewayTunnelingProtocol IKE_V2 = fromString("IkeV2");

    /** Static value OpenVPN for VpnGatewayTunnelingProtocol. */
    public static final VpnGatewayTunnelingProtocol OPEN_VPN = fromString("OpenVPN");

    /**
     * Creates or finds a VpnGatewayTunnelingProtocol from its string representation.
     * @param name a name to look for
     * @return the corresponding VpnGatewayTunnelingProtocol
     */
    @JsonCreator
    public static VpnGatewayTunnelingProtocol fromString(String name) {
        return fromString(name, VpnGatewayTunnelingProtocol.class);
    }

    /**
     * @return known VpnGatewayTunnelingProtocol values
     */
    public static Collection<VpnGatewayTunnelingProtocol> values() {
        return values(VpnGatewayTunnelingProtocol.class);
    }
}
