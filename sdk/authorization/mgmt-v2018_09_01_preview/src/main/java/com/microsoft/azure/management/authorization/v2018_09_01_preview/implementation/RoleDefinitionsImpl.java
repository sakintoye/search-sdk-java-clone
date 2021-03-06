/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * jkl
 */

package com.microsoft.azure.management.authorization.v2018_09_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.authorization.v2018_09_01_preview.RoleDefinitions;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.authorization.v2018_09_01_preview.RoleDefinition;

class RoleDefinitionsImpl extends WrapperImpl<RoleDefinitionsInner> implements RoleDefinitions {
    private final AuthorizationManager manager;

    RoleDefinitionsImpl(AuthorizationManager manager) {
        super(manager.inner().roleDefinitions());
        this.manager = manager;
    }

    public AuthorizationManager manager() {
        return this.manager;
    }

    @Override
    public RoleDefinitionImpl define(String name) {
        return wrapModel(name);
    }

    private RoleDefinitionImpl wrapModel(RoleDefinitionInner inner) {
        return  new RoleDefinitionImpl(inner, manager());
    }

    private RoleDefinitionImpl wrapModel(String name) {
        return new RoleDefinitionImpl(name, this.manager());
    }

    @Override
    public Observable<RoleDefinition> deleteAsync(String scope, String roleDefinitionId) {
        RoleDefinitionsInner client = this.inner();
        return client.deleteAsync(scope, roleDefinitionId)
        .map(new Func1<RoleDefinitionInner, RoleDefinition>() {
            @Override
            public RoleDefinition call(RoleDefinitionInner inner) {
                return new RoleDefinitionImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<RoleDefinition> getAsync(String scope, String roleDefinitionId) {
        RoleDefinitionsInner client = this.inner();
        return client.getAsync(scope, roleDefinitionId)
        .map(new Func1<RoleDefinitionInner, RoleDefinition>() {
            @Override
            public RoleDefinition call(RoleDefinitionInner inner) {
                return new RoleDefinitionImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<RoleDefinition> getByIdAsync(String roleId) {
        RoleDefinitionsInner client = this.inner();
        return client.getByIdAsync(roleId)
        .map(new Func1<RoleDefinitionInner, RoleDefinition>() {
            @Override
            public RoleDefinition call(RoleDefinitionInner inner) {
                return new RoleDefinitionImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<RoleDefinition> listAsync(final String scope) {
        RoleDefinitionsInner client = this.inner();
        return client.listAsync(scope)
        .flatMapIterable(new Func1<Page<RoleDefinitionInner>, Iterable<RoleDefinitionInner>>() {
            @Override
            public Iterable<RoleDefinitionInner> call(Page<RoleDefinitionInner> page) {
                return page.items();
            }
        })
        .map(new Func1<RoleDefinitionInner, RoleDefinition>() {
            @Override
            public RoleDefinition call(RoleDefinitionInner inner) {
                return new RoleDefinitionImpl(inner, manager());
            }
        });
    }

}
