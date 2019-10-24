/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_09_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2019_09_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2019_09_01.implementation.ExpressRouteLinkInner;
import com.microsoft.azure.management.network.v2019_09_01.implementation.ExpressRoutePortInner;

/**
 * Type representing ExpressRoutePort.
 */
public interface ExpressRoutePort extends HasInner<ExpressRoutePortInner>, Resource, GroupableResourceCore<NetworkManager, ExpressRoutePortInner>, HasResourceGroup, Refreshable<ExpressRoutePort>, Updatable<ExpressRoutePort.Update>, HasManager<NetworkManager> {
    /**
     * @return the allocationDate value.
     */
    String allocationDate();

    /**
     * @return the bandwidthInGbps value.
     */
    Integer bandwidthInGbps();

    /**
     * @return the circuits value.
     */
    List<SubResource> circuits();

    /**
     * @return the encapsulation value.
     */
    ExpressRoutePortsEncapsulation encapsulation();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the etherType value.
     */
    String etherType();

    /**
     * @return the identity value.
     */
    ManagedServiceIdentity identity();

    /**
     * @return the links value.
     */
    List<ExpressRouteLink> links();

    /**
     * @return the mtu value.
     */
    String mtu();

    /**
     * @return the peeringLocation value.
     */
    String peeringLocation();

    /**
     * @return the provisionedBandwidthInGbps value.
     */
    Double provisionedBandwidthInGbps();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * The entirety of the ExpressRoutePort definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ExpressRoutePort definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ExpressRoutePort definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the ExpressRoutePort definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the expressrouteport definition allowing to specify BandwidthInGbps.
         */
        interface WithBandwidthInGbps {
            /**
             * Specifies bandwidthInGbps.
             * @param bandwidthInGbps Bandwidth of procured ports in Gbps
             * @return the next definition stage
             */
            WithCreate withBandwidthInGbps(Integer bandwidthInGbps);
        }

        /**
         * The stage of the expressrouteport definition allowing to specify Encapsulation.
         */
        interface WithEncapsulation {
            /**
             * Specifies encapsulation.
             * @param encapsulation Encapsulation method on physical ports. Possible values include: 'Dot1Q', 'QinQ'
             * @return the next definition stage
             */
            WithCreate withEncapsulation(ExpressRoutePortsEncapsulation encapsulation);
        }

        /**
         * The stage of the expressrouteport definition allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of ExpressRoutePort, if configured
             * @return the next definition stage
             */
            WithCreate withIdentity(ManagedServiceIdentity identity);
        }

        /**
         * The stage of the expressrouteport definition allowing to specify Links.
         */
        interface WithLinks {
            /**
             * Specifies links.
             * @param links The set of physical links of the ExpressRoutePort resource
             * @return the next definition stage
             */
            WithCreate withLinks(List<ExpressRouteLinkInner> links);
        }

        /**
         * The stage of the expressrouteport definition allowing to specify PeeringLocation.
         */
        interface WithPeeringLocation {
            /**
             * Specifies peeringLocation.
             * @param peeringLocation The name of the peering location that the ExpressRoutePort is mapped to physically
             * @return the next definition stage
             */
            WithCreate withPeeringLocation(String peeringLocation);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ExpressRoutePort>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithBandwidthInGbps, DefinitionStages.WithEncapsulation, DefinitionStages.WithIdentity, DefinitionStages.WithLinks, DefinitionStages.WithPeeringLocation {
        }
    }
    /**
     * The template for a ExpressRoutePort update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ExpressRoutePort>, Resource.UpdateWithTags<Update>, UpdateStages.WithBandwidthInGbps, UpdateStages.WithEncapsulation, UpdateStages.WithIdentity, UpdateStages.WithLinks, UpdateStages.WithPeeringLocation {
    }

    /**
     * Grouping of ExpressRoutePort update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the expressrouteport update allowing to specify BandwidthInGbps.
         */
        interface WithBandwidthInGbps {
            /**
             * Specifies bandwidthInGbps.
             * @param bandwidthInGbps Bandwidth of procured ports in Gbps
             * @return the next update stage
             */
            Update withBandwidthInGbps(Integer bandwidthInGbps);
        }

        /**
         * The stage of the expressrouteport update allowing to specify Encapsulation.
         */
        interface WithEncapsulation {
            /**
             * Specifies encapsulation.
             * @param encapsulation Encapsulation method on physical ports. Possible values include: 'Dot1Q', 'QinQ'
             * @return the next update stage
             */
            Update withEncapsulation(ExpressRoutePortsEncapsulation encapsulation);
        }

        /**
         * The stage of the expressrouteport update allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of ExpressRoutePort, if configured
             * @return the next update stage
             */
            Update withIdentity(ManagedServiceIdentity identity);
        }

        /**
         * The stage of the expressrouteport update allowing to specify Links.
         */
        interface WithLinks {
            /**
             * Specifies links.
             * @param links The set of physical links of the ExpressRoutePort resource
             * @return the next update stage
             */
            Update withLinks(List<ExpressRouteLinkInner> links);
        }

        /**
         * The stage of the expressrouteport update allowing to specify PeeringLocation.
         */
        interface WithPeeringLocation {
            /**
             * Specifies peeringLocation.
             * @param peeringLocation The name of the peering location that the ExpressRoutePort is mapped to physically
             * @return the next update stage
             */
            Update withPeeringLocation(String peeringLocation);
        }

    }
}
