/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2019_06_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.management.network.v2019_06_01.implementation.ServiceEndpointPolicyDefinitionInner;
import com.microsoft.azure.management.network.v2019_06_01.implementation.ServiceEndpointPolicyInner;

/**
 * Type representing ServiceEndpointPolicy.
 */
public interface ServiceEndpointPolicy extends HasInner<ServiceEndpointPolicyInner>, Resource, GroupableResourceCore<NetworkManager, ServiceEndpointPolicyInner>, HasResourceGroup, Refreshable<ServiceEndpointPolicy>, Updatable<ServiceEndpointPolicy.Update>, HasManager<NetworkManager> {
    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the serviceEndpointPolicyDefinitions value.
     */
    List<ServiceEndpointPolicyDefinition> serviceEndpointPolicyDefinitions();

    /**
     * @return the subnets value.
     */
    List<Subnet> subnets();

    /**
     * The entirety of the ServiceEndpointPolicy definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ServiceEndpointPolicy definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ServiceEndpointPolicy definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the ServiceEndpointPolicy definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the serviceendpointpolicy definition allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next definition stage
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the serviceendpointpolicy definition allowing to specify ServiceEndpointPolicyDefinitions.
         */
        interface WithServiceEndpointPolicyDefinitions {
            /**
             * Specifies serviceEndpointPolicyDefinitions.
             * @param serviceEndpointPolicyDefinitions A collection of service endpoint policy definitions of the service endpoint policy
             * @return the next definition stage
             */
            WithCreate withServiceEndpointPolicyDefinitions(List<ServiceEndpointPolicyDefinitionInner> serviceEndpointPolicyDefinitions);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ServiceEndpointPolicy>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithEtag, DefinitionStages.WithServiceEndpointPolicyDefinitions {
        }
    }
    /**
     * The template for a ServiceEndpointPolicy update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ServiceEndpointPolicy>, Resource.UpdateWithTags<Update>, UpdateStages.WithEtag, UpdateStages.WithServiceEndpointPolicyDefinitions {
    }

    /**
     * Grouping of ServiceEndpointPolicy update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the serviceendpointpolicy update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next update stage
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the serviceendpointpolicy update allowing to specify ServiceEndpointPolicyDefinitions.
         */
        interface WithServiceEndpointPolicyDefinitions {
            /**
             * Specifies serviceEndpointPolicyDefinitions.
             * @param serviceEndpointPolicyDefinitions A collection of service endpoint policy definitions of the service endpoint policy
             * @return the next update stage
             */
            Update withServiceEndpointPolicyDefinitions(List<ServiceEndpointPolicyDefinitionInner> serviceEndpointPolicyDefinitions);
        }

    }
}
