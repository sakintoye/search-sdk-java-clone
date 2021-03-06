/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storageimportexport.v2016_11_01;

import rx.Observable;
import com.microsoft.azure.management.storageimportexport.v2016_11_01.implementation.BitLockerKeysInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing BitLockerKeys.
 */
public interface BitLockerKeys extends HasInner<BitLockerKeysInner> {
    /**
     * Returns the BitLocker Keys for all drives in the specified job.
     *
     * @param jobName The name of the import/export job.
     * @param resourceGroupName The resource group name uniquely identifies the resource group within the user subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<DriveBitLockerKey> listAsync(String jobName, String resourceGroupName);

}
