/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * jkl
 */

package com.microsoft.azure.management.apimanagement.v2019_01_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.apimanagement.v2019_01_01.ApiVersionSets;
import rx.Completable;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.apimanagement.v2019_01_01.ApiVersionSetContract;

class ApiVersionSetsImpl extends WrapperImpl<ApiVersionSetsInner> implements ApiVersionSets {
    private final ApiManagementManager manager;

    ApiVersionSetsImpl(ApiManagementManager manager) {
        super(manager.inner().apiVersionSets());
        this.manager = manager;
    }

    public ApiManagementManager manager() {
        return this.manager;
    }

    @Override
    public ApiVersionSetContractImpl define(String name) {
        return wrapModel(name);
    }

    private ApiVersionSetContractImpl wrapModel(ApiVersionSetContractInner inner) {
        return  new ApiVersionSetContractImpl(inner, manager());
    }

    private ApiVersionSetContractImpl wrapModel(String name) {
        return new ApiVersionSetContractImpl(name, this.manager());
    }

    @Override
    public Observable<ApiVersionSetContract> listByServiceAsync(final String resourceGroupName, final String serviceName) {
        ApiVersionSetsInner client = this.inner();
        return client.listByServiceAsync(resourceGroupName, serviceName)
        .flatMapIterable(new Func1<Page<ApiVersionSetContractInner>, Iterable<ApiVersionSetContractInner>>() {
            @Override
            public Iterable<ApiVersionSetContractInner> call(Page<ApiVersionSetContractInner> page) {
                return page.items();
            }
        })
        .map(new Func1<ApiVersionSetContractInner, ApiVersionSetContract>() {
            @Override
            public ApiVersionSetContract call(ApiVersionSetContractInner inner) {
                return new ApiVersionSetContractImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable getEntityTagAsync(String resourceGroupName, String serviceName, String versionSetId) {
        ApiVersionSetsInner client = this.inner();
        return client.getEntityTagAsync(resourceGroupName, serviceName, versionSetId).toCompletable();
    }

    @Override
    public Observable<ApiVersionSetContract> getAsync(String resourceGroupName, String serviceName, String versionSetId) {
        ApiVersionSetsInner client = this.inner();
        return client.getAsync(resourceGroupName, serviceName, versionSetId)
        .map(new Func1<ApiVersionSetContractInner, ApiVersionSetContract>() {
            @Override
            public ApiVersionSetContract call(ApiVersionSetContractInner inner) {
                return new ApiVersionSetContractImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serviceName, String versionSetId, String ifMatch) {
        ApiVersionSetsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serviceName, versionSetId, ifMatch).toCompletable();
    }

}
