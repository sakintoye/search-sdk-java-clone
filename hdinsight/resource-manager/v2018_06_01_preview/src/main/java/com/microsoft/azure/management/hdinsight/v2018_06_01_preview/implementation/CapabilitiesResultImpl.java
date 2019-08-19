/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.hdinsight.v2018_06_01_preview.implementation;

import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.CapabilitiesResult;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import java.util.List;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.QuotaCapability;
import java.util.Map;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.RegionsCapability;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.VersionsCapability;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.VmSizeCompatibilityFilter;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.VmSizesCapability;

class CapabilitiesResultImpl extends WrapperImpl<CapabilitiesResultInner> implements CapabilitiesResult {
    private final HDInsightManager manager;
    CapabilitiesResultImpl(CapabilitiesResultInner inner, HDInsightManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public HDInsightManager manager() {
        return this.manager;
    }

    @Override
    public List<String> features() {
        return this.inner().features();
    }

    @Override
    public QuotaCapability quota() {
        return this.inner().quota();
    }

    @Override
    public Map<String, RegionsCapability> regions() {
        return this.inner().regions();
    }

    @Override
    public Map<String, VersionsCapability> versions() {
        return this.inner().versions();
    }

    @Override
    public List<VmSizeCompatibilityFilter> vmSizeFilters() {
        return this.inner().vmSizeFilters();
    }

    @Override
    public Map<String, VmSizesCapability> vmSizes() {
        return this.inner().vmSizes();
    }

}
