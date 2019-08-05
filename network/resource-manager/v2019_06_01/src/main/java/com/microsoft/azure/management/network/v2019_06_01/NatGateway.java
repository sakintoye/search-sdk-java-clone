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
import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2019_06_01.implementation.NatGatewayInner;

/**
 * Type representing NatGateway.
 */
public interface NatGateway extends HasInner<NatGatewayInner>, Resource, GroupableResourceCore<NetworkManager, NatGatewayInner>, HasResourceGroup, Refreshable<NatGateway>, Updatable<NatGateway.Update>, HasManager<NetworkManager> {
    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the idleTimeoutInMinutes value.
     */
    Integer idleTimeoutInMinutes();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the publicIpAddresses value.
     */
    List<SubResource> publicIpAddresses();

    /**
     * @return the publicIpPrefixes value.
     */
    List<SubResource> publicIpPrefixes();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the sku value.
     */
    NatGatewaySku sku();

    /**
     * @return the subnets value.
     */
    List<SubResource> subnets();

    /**
     * @return the zones value.
     */
    List<String> zones();

    /**
     * The entirety of the NatGateway definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of NatGateway definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a NatGateway definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the NatGateway definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the natgateway definition allowing to specify Etag.
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
         * The stage of the natgateway definition allowing to specify IdleTimeoutInMinutes.
         */
        interface WithIdleTimeoutInMinutes {
            /**
             * Specifies idleTimeoutInMinutes.
             * @param idleTimeoutInMinutes The idle timeout of the nat gateway
             * @return the next definition stage
             */
            WithCreate withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes);
        }

        /**
         * The stage of the natgateway definition allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the NatGateway resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next definition stage
             */
            WithCreate withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the natgateway definition allowing to specify PublicIpAddresses.
         */
        interface WithPublicIpAddresses {
            /**
             * Specifies publicIpAddresses.
             * @param publicIpAddresses An array of public ip addresses associated with the nat gateway resource
             * @return the next definition stage
             */
            WithCreate withPublicIpAddresses(List<SubResource> publicIpAddresses);
        }

        /**
         * The stage of the natgateway definition allowing to specify PublicIpPrefixes.
         */
        interface WithPublicIpPrefixes {
            /**
             * Specifies publicIpPrefixes.
             * @param publicIpPrefixes An array of public ip prefixes associated with the nat gateway resource
             * @return the next definition stage
             */
            WithCreate withPublicIpPrefixes(List<SubResource> publicIpPrefixes);
        }

        /**
         * The stage of the natgateway definition allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid The resource GUID property of the nat gateway resource
             * @return the next definition stage
             */
            WithCreate withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the natgateway definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The nat gateway SKU
             * @return the next definition stage
             */
            WithCreate withSku(NatGatewaySku sku);
        }

        /**
         * The stage of the natgateway definition allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting the zone in which Nat Gateway should be deployed
             * @return the next definition stage
             */
            WithCreate withZones(List<String> zones);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<NatGateway>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithEtag, DefinitionStages.WithIdleTimeoutInMinutes, DefinitionStages.WithProvisioningState, DefinitionStages.WithPublicIpAddresses, DefinitionStages.WithPublicIpPrefixes, DefinitionStages.WithResourceGuid, DefinitionStages.WithSku, DefinitionStages.WithZones {
        }
    }
    /**
     * The template for a NatGateway update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<NatGateway>, Resource.UpdateWithTags<Update>, UpdateStages.WithEtag, UpdateStages.WithIdleTimeoutInMinutes, UpdateStages.WithProvisioningState, UpdateStages.WithPublicIpAddresses, UpdateStages.WithPublicIpPrefixes, UpdateStages.WithResourceGuid, UpdateStages.WithSku, UpdateStages.WithZones {
    }

    /**
     * Grouping of NatGateway update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the natgateway update allowing to specify Etag.
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
         * The stage of the natgateway update allowing to specify IdleTimeoutInMinutes.
         */
        interface WithIdleTimeoutInMinutes {
            /**
             * Specifies idleTimeoutInMinutes.
             * @param idleTimeoutInMinutes The idle timeout of the nat gateway
             * @return the next update stage
             */
            Update withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes);
        }

        /**
         * The stage of the natgateway update allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the NatGateway resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next update stage
             */
            Update withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the natgateway update allowing to specify PublicIpAddresses.
         */
        interface WithPublicIpAddresses {
            /**
             * Specifies publicIpAddresses.
             * @param publicIpAddresses An array of public ip addresses associated with the nat gateway resource
             * @return the next update stage
             */
            Update withPublicIpAddresses(List<SubResource> publicIpAddresses);
        }

        /**
         * The stage of the natgateway update allowing to specify PublicIpPrefixes.
         */
        interface WithPublicIpPrefixes {
            /**
             * Specifies publicIpPrefixes.
             * @param publicIpPrefixes An array of public ip prefixes associated with the nat gateway resource
             * @return the next update stage
             */
            Update withPublicIpPrefixes(List<SubResource> publicIpPrefixes);
        }

        /**
         * The stage of the natgateway update allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid The resource GUID property of the nat gateway resource
             * @return the next update stage
             */
            Update withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the natgateway update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The nat gateway SKU
             * @return the next update stage
             */
            Update withSku(NatGatewaySku sku);
        }

        /**
         * The stage of the natgateway update allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting the zone in which Nat Gateway should be deployed
             * @return the next update stage
             */
            Update withZones(List<String> zones);
        }

    }
}
