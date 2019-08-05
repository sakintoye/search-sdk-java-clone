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
 * Defines values for DdosCustomPolicyProtocol.
 */
public final class DdosCustomPolicyProtocol extends ExpandableStringEnum<DdosCustomPolicyProtocol> {
    /** Static value Tcp for DdosCustomPolicyProtocol. */
    public static final DdosCustomPolicyProtocol TCP = fromString("Tcp");

    /** Static value Udp for DdosCustomPolicyProtocol. */
    public static final DdosCustomPolicyProtocol UDP = fromString("Udp");

    /** Static value Syn for DdosCustomPolicyProtocol. */
    public static final DdosCustomPolicyProtocol SYN = fromString("Syn");

    /**
     * Creates or finds a DdosCustomPolicyProtocol from its string representation.
     * @param name a name to look for
     * @return the corresponding DdosCustomPolicyProtocol
     */
    @JsonCreator
    public static DdosCustomPolicyProtocol fromString(String name) {
        return fromString(name, DdosCustomPolicyProtocol.class);
    }

    /**
     * @return known DdosCustomPolicyProtocol values
     */
    public static Collection<DdosCustomPolicyProtocol> values() {
        return values(DdosCustomPolicyProtocol.class);
    }
}
