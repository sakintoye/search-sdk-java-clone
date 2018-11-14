/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakestore.v2016_11_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.datalakestore.v2016_11_01.implementation.DataLakeStoreManager;
import com.microsoft.azure.management.datalakestore.v2016_11_01.implementation.CapabilityInformationInner;
import java.util.UUID;

/**
 * Type representing CapabilityInformation.
 */
public interface CapabilityInformation extends HasInner<CapabilityInformationInner>, HasManager<DataLakeStoreManager> {
    /**
     * @return the accountCount value.
     */
    Integer accountCount();

    /**
     * @return the maxAccountCount value.
     */
    Integer maxAccountCount();

    /**
     * @return the migrationState value.
     */
    Boolean migrationState();

    /**
     * @return the state value.
     */
    SubscriptionState state();

    /**
     * @return the subscriptionId value.
     */
    UUID subscriptionId();

}